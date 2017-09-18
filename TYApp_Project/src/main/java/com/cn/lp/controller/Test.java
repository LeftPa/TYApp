package com.cn.lp.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cn.lp.pojo.User;
import com.cn.lp.service.IUserService;

public class Test {

	public static void main(String args[]){

		//∂¡»°≈‰÷√Œƒº˛
		 ApplicationContext context = 
				 new ClassPathXmlApplicationContext("spring-mybatis.xml");
		 IUserService userService=(IUserService)context.getBean("userService");
		 User user=userService.getUserById(1);
		 
		 System.out.print(user.getId());
		 System.out.print(user.getUserName());
	}
}
