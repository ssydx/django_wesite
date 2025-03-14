package com.ssydx.shizhan.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MiaoshaOrder extends Order {
    private Long id;
    private Long userId;
    private Long orderId;
    private Long itemId;
}
