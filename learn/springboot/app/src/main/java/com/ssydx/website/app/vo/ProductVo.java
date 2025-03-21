package com.ssydx.website.app.vo;

import com.ssydx.website.app.domain.MiaoshaProduct;
import com.ssydx.website.app.domain.User;

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
public class ProductVo {
    private User user;
    private MiaoshaProduct  miaoshaProduct;
    private int toStartTime = 0;
    private int toEndTime = 0;
}
