package com.ssydx.website.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ssydx.website.app.domain.MiaoshaProduct;
import com.ssydx.website.app.vo.ProductVo;

@Mapper
public interface MiaoshaProductMapper {
    @Select("select m.*,p.product_name,p.product_desc,p.product_detail,p.product_price,p.product_stocknum from miaoshaproduct_info m left join product_info p on m.product_id=p.product_id")
    @Results(value = {
        // 映射MiaoshaProduct的字段
        @Result(property = "miaoshaproduct_id", column = "miaoshaproduct_id"),
        @Result(property = "product_id", column = "product_id"),
        @Result(property = "miaoshaproduct_price", column = "miaoshaproduct_price"),
        @Result(property = "miaoshaproduct_stocknum", column = "miaoshaproduct_stocknum"),
        @Result(property = "start_date", column = "start_date"),
        @Result(property = "end_date", column = "end_date"),
        
        // 映射继承自Product的字段
        @Result(property = "product_name", column = "product_name"),
        @Result(property = "product_desc", column = "product_desc"),
        @Result(property = "product_detail", column = "product_detail"),
        @Result(property = "product_price", column = "product_price"),
        @Result(property = "product_stocknum", column = "product_stocknum")
    }, id = "mymap")
    List<MiaoshaProduct> findAll();

    @Select("select m.*,p.product_name,p.product_desc,p.product_detail,p.product_price,p.product_stocknum from miaoshaproduct_info m left join product_info p on m.product_id=p.product_id where m.product_id = #{product_id}")
    @ResultMap("mymap")
    MiaoshaProduct findById(@Param("product_id") Long id);

    @Update("update miaoshaproduct_info set miaoshaproduct_stocknum = miaoshaproduct_stocknum - 1 where miaoshaproduct_id = #{miaoshaproduct_id}")
	int reduceStock(MiaoshaProduct miaoshaproduct_id);
}
