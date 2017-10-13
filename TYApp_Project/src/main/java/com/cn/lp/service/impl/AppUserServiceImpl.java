package com.cn.lp.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.lp.dao.IAppUserDao;
import com.cn.lp.pojo.AppUser;
import com.cn.lp.service.IAppUserService;
import com.cn.lp.util.DateHelper;

@Service("appUserService")
public class AppUserServiceImpl implements IAppUserService {

	@Resource
	private IAppUserDao appUserDao;

	/**
	 * 
	 */
	public int addAppUser(String userName, String password) {
		int r = -1;
		// 检查是否已经注册
		AppUser appUser = appUserDao.selectByUserName(userName);
		if (appUser == null) {
			appUser = new AppUser();
			appUser.setAppId(UUID.randomUUID().toString());
			appUser.setUserName(userName);
			appUser.setPassword(password);
			appUser.setRegistTime(DateHelper.getDateNow());
			r = appUserDao.insert(appUser);
		} else {
			r = 2;
		}
		return r;
	}

	public AppUser loginAppUser(String userName, String password) {
		return appUserDao.selectByUserNameAndPassword(userName, password);
	}

	public AppUser getAppUserByUserName(String userName){
		return appUserDao.selectByUserName(userName);
	}
	
	public int updateByPrimaryKey(AppUser appUser){
		return appUserDao.updateByPrimaryKey(appUser);
	}
}
