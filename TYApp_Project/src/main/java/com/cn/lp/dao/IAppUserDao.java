package com.cn.lp.dao;

import com.cn.lp.pojo.AppUser;

public interface IAppUserDao {
	
    int deleteByPrimaryKey(String appId);

    int insert(AppUser record);

    int insertSelective(AppUser record);

    AppUser selectByPrimaryKey(String appId);

    int updateByPrimaryKeySelective(AppUser record);

    int updateByPrimaryKey(AppUser record);


    AppUser selectByUserName(String username);
    
    AppUser selectByUserNameAndPassword(String username,String password);


}
