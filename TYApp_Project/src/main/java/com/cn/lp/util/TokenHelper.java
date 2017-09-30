package com.cn.lp.util;

import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.cn.lp.pageModel.TokenModel;

public class TokenHelper {

	private final static long tokenValidTime=30;
	
	public static String createToken(TokenModel tm) throws Exception {

		tm.setDt(new Date().getTime());
		return createToken(JsonHelper.toJSONString(tm));
	}

	public static String createToken(String str) throws Exception {

		String token = Security.encrypt(str);
		return token;
	}
	public static TokenModel checkToken(String token) throws Exception{
		TokenModel tokenModel=JSON.parseObject(Security.decrypt(token),TokenModel.class);
		long dtNow=new Date().getTime();
		long expired=(dtNow-tokenModel.getDt())/1000*60; //转成分钟数
		if(expired>tokenValidTime){
			//token超时失效
			tokenModel=new TokenModel();
			tokenModel.setVerify(false);
		}else{
			tokenModel.setVerify(true);
		}
		return tokenModel;
	}
}
