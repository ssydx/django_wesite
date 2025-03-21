package com.ssydx.website.app.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MiaoshaProduct extends Product {
    private Long miaoshaproduct_id;
    private Long product_id;
    private Double miaoshaproduct_price;
    private Integer miaoshaproduct_stocknum;
    private Date start_date;
    private Date end_date;
}
