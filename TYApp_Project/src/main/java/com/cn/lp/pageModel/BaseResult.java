package com.cn.lp.pageModel;

public class BaseResult {

	private String RspCode;
	private String RspDesc;
	
	private Object Body;
	
	
	
	public void writeSuccess(){
		this.RspCode="200";
		this.RspDesc="成功";
	}
	public void writeSuccess(Object o){
		this.RspCode="200";
		this.RspDesc="成功";
		this.Body=o;
	}
	public void writeFaile(){
		this.RspCode="500";
		this.RspDesc="失败";
	}
	public void writeFaile(String desc){
		this.RspCode="500";
		this.RspDesc=desc;
	}
	public void writeFaile(String code,String desc){
		this.RspCode=code;
		this.RspDesc=desc;
	}
	

	public String getRspCode() {
		return RspCode;
	}

	public void setRspCode(String rspCode) {
		RspCode = rspCode;
	}

	public String getRspDesc() {
		return RspDesc;
	}

	public void setRspDesc(String rspDesc) {
		RspDesc = rspDesc;
	}

	public Object getBody() {
		return Body;
	}

	public void setBody(Object body) {
		Body = body;
	}
	
	
}

