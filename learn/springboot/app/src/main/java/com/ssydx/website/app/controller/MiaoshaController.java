package com.ssydx.website.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ssydx.website.app.config.AccessLimit;
import com.ssydx.website.app.dao.RedisDao;
import com.ssydx.website.app.domain.MiaoshaOrder;
import com.ssydx.website.app.domain.MiaoshaProduct;
import com.ssydx.website.app.domain.User;
import com.ssydx.website.app.rabbitmq.MiaoshaMessage;
import com.ssydx.website.app.rabbitmq.MiaoshaSender;
import com.ssydx.website.app.redis.ProductRedis;
import com.ssydx.website.app.service.MiaoshaService;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/miaosha")
public class MiaoshaController implements InitializingBean
{
    @Autowired
	private MiaoshaService miaoshaService;
    @Autowired
	private RedisDao redisDao;
    @Autowired
	private MiaoshaSender mqSender;
	// 存放ItemId与秒杀是否结束的对应关系
	private final Map<Long, Boolean> localOverMap =
			Collections.synchronizedMap(new HashMap<>());

	@Override
	public void afterPropertiesSet() {
		// 获取所有物品列表
		List<MiaoshaProduct> itemList = miaoshaService.getProductList();
		if (itemList == null) {
			return;
		}
		for (MiaoshaProduct item : itemList) {
			redisDao.set(ProductRedis.prefix, item.getProduct_id().toString(), item.getMiaoshaproduct_stocknum(),ProductRedis.expiredSeconds);
			localOverMap.put(item.getProduct_id(), false);
		}
	}

	@GetMapping(value = "/verifyCode")
	@ResponseBody
	@AccessLimit // 限制该方法必须登录才能访问
	public void getMiaoshaVerifyCode(HttpServletResponse response, User user, @RequestParam("itemId") long itemId) throws IOException {
		BufferedImage image = miaoshaService.createVerifyCode(user, itemId);
		OutputStream out = response.getOutputStream();
		// 将验证码输出到客户端
		ImageIO.write(image, "JPEG", out);
		out.flush();
		out.close();
	}

	@GetMapping(value = "/path")
	@ResponseBody
	// 限制该方法必须登录才能访问，且每5秒内只能调用5次
	@AccessLimit(seconds = 5, maxCount = 5)
	public String getMiaoshaPath(User user, @RequestParam("itemId") long itemId, @RequestParam(value = "verifyCode", defaultValue = "0") int verifyCode) {
		// 如果输入的验证码不匹配
		if (!miaoshaService.checkVerifyCode(user, itemId, verifyCode))  // ①
		{
			return null;
		}
		String path = miaoshaService.createMiaoshaPath(user, itemId);
		return path;
	}

	@PostMapping("/{path}/proMiaosha")
	@ResponseBody
	@AccessLimit // 限制该方法必须登录才能访问
	public String proMiaosha(Model model, User user, @RequestParam("itemId") Long itemId, @PathVariable("path") String path) throws JsonProcessingException {
		model.addAttribute("user", user);
		// 验证动态的秒杀地址是否正确
		boolean check = miaoshaService.checkPath(user, itemId, path);   // ②
		if (!check) {
			return "地址错误";
		}
		// 通过内存快速获取该商品是否秒杀结束
		Boolean over = localOverMap.get(itemId);
		// 如果秒杀已经结束
		if (over) {
			return "秒杀结束";
		}
		// 预减库存
		long stock = redisDao.decr(ProductRedis.prefix, itemId.toString());
		// 如果库存小于0，在内存中记录该商品秒杀结束，并返回秒杀结束的提示
		if (stock < 0) {
			localOverMap.put(itemId, true);
			return "秒杀结束";
		}
		// 根据用户ID和商品ID获取秒杀订单
		MiaoshaOrder miaoshaOrder = miaoshaService.getMiaoshaOrderByUserIdAndItemId(user.getUserId(), itemId);
		if (miaoshaOrder != null) {
			return "重复秒杀";
		}
		// 执行实际的订单流程
		var miaoshaMessage = new MiaoshaMessage();
		miaoshaMessage.setUser(user);
		miaoshaMessage.setItemId(itemId);
		mqSender.sendMiaoshaMessage(miaoshaMessage);
		return "成功秒杀";
	}
	@GetMapping(value = "/result")
	@ResponseBody
	@AccessLimit
	public Long miaoshaResult(Model model, User user, @RequestParam("itemId") long itemId) {
		model.addAttribute("user", user);
		long result = miaoshaService.getMiaoshaResult(user.getUserId(), itemId);
		return result;
	}
}
