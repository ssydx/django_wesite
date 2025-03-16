package com.ssydx.shizhan.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private Long id;
    private Long userId;
    private Long itemId;
    private String itemName;
    private Integer orderNum;
    private Double orderPrice;
    private Integer orderChannel;
    private Integer orderStatus;
    private Date createDate;
    private Date payDate;
}
