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
public class Order {
    private Long order_id;
	private Long user_id;
	private Long product_id;
	private String product_name;
	private Integer order_num;
	private Double order_price;
	private Integer order_channel;
	private Integer order_status;
	private Date create_date;
	private Date pay_date;
}
