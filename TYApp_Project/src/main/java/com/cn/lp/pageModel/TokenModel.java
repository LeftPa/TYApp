package com.cn.lp.pageModel;

import java.util.Date;

public class TokenModel {

	private String uid;

	private long dt;
	
	private boolean verify;

	public TokenModel() {

	}

	public TokenModel(String uid) {
		this.uid = uid;
	}

	

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}


	
	public long getDt() {
		return dt;
	}

	public void setDt(long dt) {
		this.dt = dt;
	}

	public boolean isVerify() {
		return verify;
	}

	public void setVerify(boolean verify) {
		this.verify = verify;
	}

}
