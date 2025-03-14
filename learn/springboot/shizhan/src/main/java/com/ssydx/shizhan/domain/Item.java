package com.ssydx.shizhan.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    private Long id;
    private String itemName;
    private String title;
    private String itemImg;
    private String itemDetail;
    private Double itemPrice;
    private Integer stockNum;
}
