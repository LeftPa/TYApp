package com.cn.lp.util;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * @author lipeng
 *
 */
public class JsonHelper {

	/**
	 * @Description:���������л�Ϊjson����
	 * @param:@param o
	 * @return:Object   
	 */
	public static Object toJSON(Object o){
		return JSON.toJSON(o);
	}
	
	/**
	 * @Description:���������л�Ϊjson�ַ�����
	 * @param:@param o
	 * @return:String  
	 */
	public static String toJSONString(Object o){
		return JSON.toJSONString(o);
	}
	
	/**
	 * 
	 * @Description:��json�ַ��������л�Ϊ����
	 * @param:@param jsonStr
	 * @return:T
	 */
	public static T toObject(String jsonStr){
		return  JSON.parseObject(jsonStr, T.class);  
	}
	
	/**
	 * @Description:��json�ַ��������л�Ϊ��������
	 * @param:@param jsonStr
	 * @return:List<T>   
	 */
	public static List<T> toListObject(String jsonStr){

		return JSON.parseObject(jsonStr, new TypeReference<List<T>>() {});
		
	}
}
