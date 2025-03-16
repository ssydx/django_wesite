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
public class User {
    private Long userId;
    private String userName;
    private String userPwd;
    private Date userRegisterDate;
    private Date userLastLoginDate;
    private Integer userLoginCount;
    private Clazz clazz;
}
