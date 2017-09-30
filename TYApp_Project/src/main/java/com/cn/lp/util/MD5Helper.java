package com.cn.lp.util;

import java.security.MessageDigest;

public class MD5Helper {
	
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
		"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/**
	 * 生成32位MD5值
	 * 
	 * @param origin
	 * @return md value
	 */
	public static String encryptByMD5(String origin) {
		String resultString = null;
	
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToString(md.digest(resultString.getBytes()));
		} catch (Exception ex) {
	
		}
		return resultString;
	}
	/**
	 * 
	 * @Description:验证MD5值
	 * @param:@param data
	 * @param:@param md5value
	 * @param:@return 
	 * @return:true为验证通过，false验证失败
	 */
	public boolean isValidateByMD5(String data,String md5value){
		
		if(encryptByMD5(data).equals(md5value)){
			return true;
		}
		return false;
	}
	
	/**
	 * 转换字节数组为16进制字串
	 * 
	 * @param b
	 *            字节数组
	 * @return 16进制字串
	 */
	public static String byteArrayToString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));// 若使用本函数转换则可得到加密结果的16进制表示，即数字字母混合的形式
			// resultSb.append(byteToNumString(b[i]));//使用本函数则返回加密结果的10进制数字字串，即全数字形式
		}
		return resultSb.toString();
	}
	
	private static String byteToNumString(byte b) {
	
		int _b = b;
		if (_b < 0) {
			_b = 256 + _b;
		}
	
		return String.valueOf(_b);
	}
	
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		// System.out.println(n);
		// System.out.println(hexDigits[d1] + hexDigits[d2]);
		return hexDigits[d1] + hexDigits[d2];
	}
}
