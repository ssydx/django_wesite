package com.ssydx.shizhan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ssydx.shizhan.domain.MiaoshaItem;

import io.lettuce.core.dynamic.annotation.Param;

@Mapper
public interface MiaoshaItemMapper {
    @Select("select it.*,mi.stock_count,mi.start_date,mi.miaosha_price from miaosha_item mi left join item_info it on mi.item_id=it.item_id")
    @Results( id = "itemMapper",value = {
        @Result(property = "itemId",column = "item_id"),
        @Result(property = "itemName",column = "item_name"),
        @Result(property = "itemImg",column = "item_img"),
        @Result(property = "itemDetail",column = "item_detail"),
        @Result(property = "itemPrice",column = "item_price"),
        @Result(property = "stockNum",column = "stock_num"),
        @Result(property = "miaoshaPrice",column = "miaosha_price"),
        @Result(property = "stockCount",column = "stock_count"),
        @Result(property = "startDate",column = "start_date"),
        @Result(property = "endDate",column = "end_date")
    })
    List<MiaoshaItem> findAll();

    @Select("select it.*,mi.stock_count,mi.start_date,mi.miaosha_price from miaosha_item mi left join item_info it on mi.item_id=it.item_id where it.item_id=#{itemId}")
    @ResultMap("itemMapper")
    MiaoshaItem findById(long itemId);

    @Update("update miaosha_item set stock_count = stock_count -1 where item_id = #{itemId}")
    int reduceStock(MiaoshaItem miaoshaItem);
}
