package com.mytion.sousacomics.configurer;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SousaComicsWebMvcConfigurer implements WebMvcConfigurer{
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		PageableHandlerMethodArgumentResolver pageHandler = new PageableHandlerMethodArgumentResolver();
		pageHandler.setFallbackPageable(PageRequest.of(0, 20));
		resolvers.add(pageHandler);
		WebMvcConfigurer.super.addArgumentResolvers(resolvers);
	}
}
