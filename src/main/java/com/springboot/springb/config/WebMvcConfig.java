package com.springboot.springb.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
/**
 * web mvc相关配置
 * @author 86158
 *
 */
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springboot.springb.interceptor.MyInterceptor;
import com.springboot.springb.filter.ParameterFilter;


@Configuration
@AutoConfigureAfter({WebMvcAutoConfiguration.class})
public class WebMvcConfig implements WebMvcConfigurer{
	
	//引入自定义拦截器
	@Autowired
	private MyInterceptor myInterceptor;
	
	/**
	 * 注册拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(myInterceptor).addPathPatterns("/**");
	}

	/**
	 * 注册参数过滤器
	 */
	@Bean
	public FilterRegistrationBean<ParameterFilter> parameterFilter(){
		FilterRegistrationBean<ParameterFilter> file=new FilterRegistrationBean<>();
		file.setFilter(new ParameterFilter());
		return file;
	}
	
    
}
