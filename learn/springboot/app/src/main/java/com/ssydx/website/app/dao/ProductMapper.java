package com.ssydx.website.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ssydx.website.app.vo.ProductVo;

@Mapper
public interface ProductMapper {
    @Select("select product_name,product_desc from product_info")
    List<ProductVo> findAll();
}
