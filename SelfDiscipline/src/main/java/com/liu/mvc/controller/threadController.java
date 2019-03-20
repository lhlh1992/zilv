package com.liu.mvc.controller;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;

@Controller
public class threadController  implements InitializingBean,DisposableBean{

	@Override
	public void afterPropertiesSet() throws Exception {
	      System.out.println("lllllllllll");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("2222222");		
	}

}
