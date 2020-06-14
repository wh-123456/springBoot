package com.springboot.springb.filter;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
/**
 * 自定义过滤器，过滤敏感字符串
 */
import org.slf4j.LoggerFactory;
@WebFilter(filterName="parameterFilter",urlPatterns="/**")
public class ParameterFilter implements Filter {
	//给filter加上Logger
	private final static Logger LG=LoggerFactory.getLogger(ParameterFilter.class);
	
	/*自定义过滤的字符串数组*/
	private String[] names={"特朗普","手风琴","fuck"};
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/*
		* 修改request请求中的参数
		* HttpServletRequest中的请求信息是locked状态，我们无法直接操作
		* 我们使用HttpServletRequestWrapper对请求信息做处理
		* 继续优化，自定义wrapper类，继承HttpServletRequestWrapper，重写实现方法……
		*/
		//包装为httpRequest
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		//Map被锁住，修改不被允许，这里注释掉
		//Map<String,String[]> maps=httpRequest.getParameterMap();
		//maps.put("key", new String[]{"*****"});
		HttpServletRequestWrapper wrapper=new HttpServletRequestWrapper(httpRequest){
            //重写了getParameter方法，value2改变
			@Override
			public String getParameter(String name) {
				String value=httpRequest.getParameter(name);
				//遍历并替换掉数组里的敏感词
				for (String string : names) {
					if(value.equals(string)){
						return "**";
					}
				}
				return super.getParameter(name);
			}
			//重写了getParameterValuesr方法，value1改变
			@Override
			public String[] getParameterValues(String name) {
				String[] values=httpRequest.getParameterValues(name);
				if(values!=null){
					//遍历并替换掉数组里的敏感词
					for (String string : names) {
						values[0]= values[0].replace(string, "*");
					}
				return values;
				}
				return super.getParameterValues(name);
			}
			
		};
		//chain是链条
		chain.doFilter(wrapper, response);

	}

	@Override
	public void destroy() {
		LG.debug("this is parameter fiter destroy.");
		Filter.super.destroy();
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LG.debug("this is parameter fiter init.");
		Filter.super.init(filterConfig);
	}

}
