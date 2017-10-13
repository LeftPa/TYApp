package com.cn.lp.service;

import com.cn.lp.pojo.AppUser;

public interface IAppUserService {

	public int addAppUser(String userName,String password);

	public AppUser loginAppUser(String userName, String password);
	
	public AppUser getAppUserByUserName(String userName);
	
	public int updateByPrimaryKey(AppUser appUser);
}
