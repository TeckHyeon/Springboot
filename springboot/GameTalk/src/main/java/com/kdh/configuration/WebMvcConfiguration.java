package com.kdh.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kdh.interceptor.LoginCheckInterceptor;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginCheckInterceptor()).addPathPatterns("/**").excludePathPatterns("/loginFail")
				.excludePathPatterns("/login").excludePathPatterns("/loginCheck").excludePathPatterns("/")
				.excludePathPatterns("/signin").excludePathPatterns("/login1").excludePathPatterns("/main");

	}
}