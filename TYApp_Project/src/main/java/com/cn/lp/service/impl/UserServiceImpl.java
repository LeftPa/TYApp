package com.cn.lp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.lp.dao.IUserDao;
import com.cn.lp.pojo.User;
import com.cn.lp.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao  userDao;
	
	public User getUserById(int userId) {

		 return this.userDao.selectByPrimaryKey(userId); 
	}

}
