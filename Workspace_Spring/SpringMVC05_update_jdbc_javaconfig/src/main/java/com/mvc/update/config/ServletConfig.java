package com.mvc.update.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


//EnableWebMvc 가 Mvc 어노테이션 역할을 해줄 것이다
@Configuration
@EnableWebMvc
@ComponentScan("com.mvc.update")
public class ServletConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		
	}
	
	//생성자로 넣는 것도 가능하다
	@Bean
	public InternalResourceViewResolver viewResolver() {
		
		String prefix = "/WEB-INF/views/";
		String suffix = ".jsp";
		
		return new InternalResourceViewResolver(prefix, suffix);
	}

	
	
	
}
