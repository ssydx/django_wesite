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
public class MiaoshaOrder {
	private Long miaoshaorder_id;
	private Long user_id;
	private Long order_id;
	private Long product_id;
}
