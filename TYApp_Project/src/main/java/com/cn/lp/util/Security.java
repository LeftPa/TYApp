package com.cn.lp.util;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

public class Security {
	// ������ܷ�ʽ
		private final static String DES = "DES";
		private final static String UTF8 = "GBK";
		// ע�⣺DES���ܺͽ��ܹ����У���Կ���ȶ�������8�ı���
		private final static String key="qsjxkEwoslqYrnRm";
		static SecretKeyFactory keyFactory = null;
		static {
			try {
				keyFactory = SecretKeyFactory.getInstance("DES");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}

		public static void main(String[] args) throws Exception {
			long begin = new Date().getTime();
			String data = "aaades���ܲ���";
			
			String v=encrypt(data);
			System.err.println(v);
			System.err.println(decrypt(v));
			long end = new Date().getTime();
			System.out.println(end - begin);
		}

		/**
		 * Description ���ݼ�ֵ���м���
		 * 
		 * @param data
		 * @param key
		 *            ���ܼ�byte����
		 * @return
		 * @throws Exception
		 */
		public static String encrypt(String data) throws Exception {
			// ʹ��ָ���ı����ȡҪ���ܵ����ݣ�һ����Կ������ĸ�����ֲ���ָ�����룬��ָ��Ҳ����
			byte[] bt = encrypt(data.getBytes(UTF8), key.getBytes());
			// ��һ��ʹ����sun.misc.BASE64Encoder;�����˱��룬������˵ʹ��org.apache.commons.codec.binary.Base64�ȽϺ�������������
			String strs = Base64.encodeBase64String(bt);
			return strs;
		}

		/**
		 * Description ���ݼ�ֵ���н���
		 * 
		 * @param data
		 * @param key
		 *            ���ܼ�byte����
		 * @return
		 * @throws IOException
		 * @throws Exception
		 */
		public static String decrypt(String data) throws IOException,
				Exception {
			if (data == null)
				return null;
			// ʹ��org.apache.commons.codec.binary.Base64����
			byte[] buf = Base64.decodeBase64(data);
			byte[] bt = decrypt(buf, key.getBytes());
			return new String(bt, UTF8);
		}

		/**
		 * Description ���ݼ�ֵ���м���
		 * 
		 * @param data
		 * @param key
		 *            ���ܼ�byte����
		 * @return
		 * @throws Exception
		 */
		private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
			// ����һ�������ε������Դ
			SecureRandom sr = new SecureRandom();
			// ��ԭʼ��Կ���ݴ���DESKeySpec����Ҳ���Ǵ�����Կ����Կ����
			DESKeySpec dks = new DESKeySpec(key);
			// ��Կ������������Կ������ Key
			// �Ĳ�͸��������Կ��ת��Ϊ��Կ�淶���ײ���Կ���ϵ�͸����ʾ��ʽ������֮��Ȼ��������Կ����ֻ�����ܣ��Գƣ���Կ���в�����
			// �����Ϊʹ�õ���ģʽ
			// SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
			// �����ṩ����Կ�淶����Կ���ϣ����� SecretKey(��Կ) ����
			SecretKey securekey = keyFactory.generateSecret(dks);
			// Cipher����ʵ����ɼ��ܲ���,����Ϊ���ܺͽ����ṩ���빦��
			Cipher cipher = Cipher.getInstance(DES);
			// ����Կ�����Դ��ʼ���� Cipher��ENCRYPT_MODE���ڽ� Cipher ��ʼ��Ϊ����ģʽ�ĳ�����
			cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
			// ��ʽִ�м��ܲ���
			return cipher.doFinal(data);
		}

		/**
		 * Description ���ݼ�ֵ���н���
		 * 
		 * @param data
		 * @param key
		 *            ���ܼ�byte����
		 * @return
		 * @throws Exception
		 */
		private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
			// ����һ�������ε������Դ
			SecureRandom sr = new SecureRandom();
			// ��ԭʼ��Կ���ݴ���DESKeySpec����Ҳ���Ǵ�����Կ����Կ����
			DESKeySpec dks = new DESKeySpec(key);
			// ��Կ������������Կ������ Key
			// �Ĳ�͸��������Կ��ת��Ϊ��Կ�淶���ײ���Կ���ϵ�͸����ʾ��ʽ������֮��Ȼ��������Կ����ֻ�����ܣ��Գƣ���Կ���в�����
			// �����Ϊʹ�õ���ģʽ
			// SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
			// �����ṩ����Կ�淶����Կ���ϣ����� SecretKey(��Կ)����
			SecretKey securekey = keyFactory.generateSecret(dks);
			// Cipher��Ϊ���ܺͽ����ṩ���빦��
			Cipher cipher = Cipher.getInstance(DES);
			// DECRYPT_MODE���ڽ� Cipher ��ʼ��Ϊ����ģʽ�ĳ�����
			cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
			// ��ʽ���н��ܲ���
			return cipher.doFinal(data);
		}
}
