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
	 * @Description:将对象序列化为json对象。
	 * @param:@param o
	 * @return:Object   
	 */
	public static Object toJSON(Object o){
		return JSON.toJSON(o);
	}
	
	/**
	 * @Description:将对象序列化为json字符串。
	 * @param:@param o
	 * @return:String  
	 */
	public static String toJSONString(Object o){
		return JSON.toJSONString(o);
	}
	
	/**
	 * 
	 * @Description:将json字符串反序列化为对象
	 * @param:@param jsonStr
	 * @return:T
	 */
	public static T toObject(String jsonStr){
		return  JSON.parseObject(jsonStr, T.class);  
	}
	
	/**
	 * @Description:将json字符串反序列化为对象数组
	 * @param:@param jsonStr
	 * @return:List<T>   
	 */
	public static List<T> toListObject(String jsonStr){

		return JSON.parseObject(jsonStr, new TypeReference<List<T>>() {});
		
	}
}
