package com.ssydx.website.app.domain;

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
public class Product {
    private Long product_id;
    private String product_name;
    private String product_desc;
    private String product_detail;
    private Double product_price;
    private Integer product_stocknum;
}
