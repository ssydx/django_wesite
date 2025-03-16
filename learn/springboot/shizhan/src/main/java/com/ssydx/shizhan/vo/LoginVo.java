package com.ssydx.shizhan.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginVo {
	private String mobile;
	private String password;
	private Integer vercode;
}
