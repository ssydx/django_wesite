package com.ssydx.website.app.service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.image.BufferedImage;

import com.ssydx.website.app.dao.MiaoshaOrderMapper;
import com.ssydx.website.app.dao.MiaoshaProductMapper;
import com.ssydx.website.app.dao.OrderMapper;
import com.ssydx.website.app.dao.ProductMapper;
import com.ssydx.website.app.dao.RedisDao;
import com.ssydx.website.app.domain.MiaoshaOrder;
import com.ssydx.website.app.domain.MiaoshaProduct;
import com.ssydx.website.app.domain.Order;
import com.ssydx.website.app.domain.User;
import com.ssydx.website.app.redis.MiaoshaOrderRedis;
import com.ssydx.website.app.redis.MiaoshaPathRedis;
import com.ssydx.website.app.redis.MiaoshaRedis;
import com.ssydx.website.app.redis.MiaoshaVercodeRedis;
import com.ssydx.website.app.redis.VercodeRedis;
import com.ssydx.website.app.util.VercodeUtil;
import com.ssydx.website.app.vo.ProductVo;

import ch.qos.logback.core.util.MD5Util;

@Service
public class MiaoshaService {
    @Autowired
    private MiaoshaProductMapper miaoshaProductMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private MiaoshaOrderMapper miaoshaOrderMapper;
    @Autowired
    private RedisDao redisDao;

    public List<MiaoshaProduct> getProductList() {
        return miaoshaProductMapper.findAll();
    }
    public MiaoshaProduct getProductById(Long id) {
        return miaoshaProductMapper.findById(id);
    }
	public boolean reduceStock(MiaoshaProduct miaoshaProduct) {
		int ret = miaoshaProductMapper.reduceStock(miaoshaProduct);
		return ret > 0;
	} 
	// 创建普通订单和秒杀订单
	@Transactional
	public Order createOrder(User user, MiaoshaProduct product)
	{
		// 创建普通订单
		var order = new Order();
		// 设置订单信息
		order.setUser_id(user.getUserId());
		order.setCreate_date(new Date());
		order.setOrder_num(1);
		order.setProduct_id(product.getProduct_id());
		order.setProduct_name(product.getProduct_name());
		order.setOrder_price(product.getMiaoshaproduct_price());
		order.setOrder_channel(1);
		// 设置订单状态，0代表未支付订单
		order.setOrder_status(0);
		// 保存普通订单
		orderMapper.save(order);
		// 创建秒杀订单
		var miaoshaOrder = new MiaoshaOrder();
		// 设置秒杀订单信息
		miaoshaOrder.setUser_id(user.getUserId());
		miaoshaOrder.setProduct_id(product.getProduct_id());
		miaoshaOrder.setOrder_id(order.getOrder_id());
		// 保存秒杀订单
		miaoshaOrderMapper.save(miaoshaOrder);
		// 将秒杀订单保存到Redis缓存中
		redisDao.set(MiaoshaOrderRedis.prefix,user.getUserId() + "_" + product.getProduct_id(), miaoshaOrder,MiaoshaOrderRedis.expiredSeconds);
		return order;
	}

	@Transactional
	public Order miaosha(User user, MiaoshaProduct item)
	{
		// 将秒杀商品的库存减1
		boolean success = reduceStock(item);
		if (success) { 
			return createOrder(user, item);
		}
		else {
			redisDao.set(MiaoshaRedis.prefix,item.getProduct_id().toString(), true,MiaoshaRedis.expiredSeconds);
			return null;
		}
	}
	// 根据用户ID和商品ID获取秒杀订单
	public MiaoshaOrder getMiaoshaOrderByUserIdAndItemId(long userId, long productId) {
		// 从Redis缓存读取订单
		return redisDao.get(MiaoshaOrderRedis.prefix,userId + "_" + productId, MiaoshaOrder.class);
	} 
	public long getMiaoshaResult(Long userId, Long productId) {
		// 根据用户ID和商品ID获取秒杀订单
		MiaoshaOrder order = getMiaoshaOrderByUserIdAndItemId(userId, productId);
		// 如果秒杀订单不为null，返回订单ID
		if (order != null) {
			return order.getOrder_id();
		} else {
			// 根据物品ID获取该商品的秒杀状态
			boolean isOver = redisDao.isExist(MiaoshaRedis.prefix, productId.toString());
			// 如果秒杀已经结束返回-1
			if (isOver) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	public String createMiaoshaPath(User user, long productId)
	{
		if (user == null || productId <= 0) {
			return null;
		} 
		String str = UUID.randomUUID().toString(); 
		redisDao.set(MiaoshaPathRedis.prefix, user.getUserId() + "_" + productId, str, MiaoshaPathRedis.expiredSeconds);
		return str;
	}
	// 判断用户输入的秒杀地址是否正确
	public boolean checkPath(User user, long productId, String path)
	{
		if (user == null || path == null) {
			return false;
		}
		String pathOld = redisDao.get(MiaoshaPathRedis.prefix, user.getUserId() + "_" + productId, String.class);
		return path.equals(pathOld);
	}



	// 生成秒杀图形验证码
	public BufferedImage createVerifyCode(User user, long productId) {
		if (user == null || productId <= 0) {
			return null;
		}
        VercodeUtil vercode = new VercodeUtil();
        BufferedImage image = vercode.createVercode();
        redisDao.set(MiaoshaVercodeRedis.prefix, user.getUserId().toString() + '&' + productId, vercode.calcVercode(), MiaoshaVercodeRedis.expiredSeconds);
        return image;
	}

	// 检查用户输入的秒杀验证码是否正确
	public boolean checkVerifyCode(User user, long productId, int vercode)
	{
		if (user == null || productId <= 0)
		{
			return false;
		}
        Integer value = redisDao.get(MiaoshaVercodeRedis.prefix, user.getUserId().toString() + '&' + productId, Integer.class);
        if (value != null && value - vercode == 0) {
            redisDao.delete(MiaoshaVercodeRedis.prefix, user.getUserId().toString() + '&' + productId);
            return true;
        }
        return false;
	}
	// 根据订单ID和用户ID获取订单的方法
	public Order getOrderByIdAndOwnerId(long orderId, long userId)
	{
		return orderMapper.findByIdAndOwnerId(orderId, userId);
	}

}
