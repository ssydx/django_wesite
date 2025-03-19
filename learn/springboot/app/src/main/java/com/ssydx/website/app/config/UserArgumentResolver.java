package com.ssydx.website.app.config;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.ssydx.website.app.domain.User;

import org.springframework.core.MethodParameter;

@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {
	// 该方法的返回true则表明要解析该参数
	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		Class<?> clazz = methodParameter.getParameterType();
		return clazz == User.class;
	}

	@Override
	public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) { 
		return UserContext.getUser();
	}
}
