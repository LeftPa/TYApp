package com.cn.lp.util;

import java.security.MessageDigest;

public class MD5Helper {
	
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
		"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/**
	 * ����32λMD5ֵ
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
	 * @Description:��֤MD5ֵ
	 * @param:@param data
	 * @param:@param md5value
	 * @param:@return 
	 * @return:trueΪ��֤ͨ����false��֤ʧ��
	 */
	public boolean isValidateByMD5(String data,String md5value){
		
		if(encryptByMD5(data).equals(md5value)){
			return true;
		}
		return false;
	}
	
	/**
	 * ת���ֽ�����Ϊ16�����ִ�
	 * 
	 * @param b
	 *            �ֽ�����
	 * @return 16�����ִ�
	 */
	public static String byteArrayToString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));// ��ʹ�ñ�����ת����ɵõ����ܽ����16���Ʊ�ʾ����������ĸ��ϵ���ʽ
			// resultSb.append(byteToNumString(b[i]));//ʹ�ñ������򷵻ؼ��ܽ����10���������ִ�����ȫ������ʽ
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