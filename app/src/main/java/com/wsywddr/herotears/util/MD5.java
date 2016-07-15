package com.wsywddr.herotears.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

	/**
	 * 获取MD5加密后的字符串
	 * 
	 * @param str
	 *            明文
	 * @return 加密后的字符串
	 * @throws Exception
	 */
	public static String getMD5(String str) throws Exception {
		/** 创建MD5加密对象 */
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		/** 进行加密 */
		md5.update(str.getBytes());
		/** 获取加密后的字节数组 */
		byte[] md5Bytes = md5.digest();
		String res = "";
		for (int i = 0; i < md5Bytes.length; i++) {
			int temp = md5Bytes[i] & 0xFF;
			if (temp <= 0XF) { // 转化成十六进制不够两位，前面加零
				res += "0";
			}
			res += Integer.toHexString(temp);
		}
		return res;
	}

	
	/**
	 * 获取MD5加密后的字符串
	 * 
	 * @param str
	 *            明文
	 * @return 加密后的字符串
	 * @throws Exception
	 */
	public static String getMD5Str(String str){
		/** 创建MD5加密对象 */
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			/** 进行加密 */
			md5.update(str.getBytes());
			/** 获取加密后的字节数组 */
			byte[] md5Bytes = md5.digest();
			String res = "";
			for (int i = 0; i < md5Bytes.length; i++) {
				int temp = md5Bytes[i] & 0xFF;
				if (temp <= 0XF) { // 转化成十六进制不够两位，前面加零
					res += "0";
				}
				res += Integer.toHexString(temp);
			}
			return res;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 获取sha1加密后的字符串
	 * 
	 * @param str
	 *            明文
	 * @return 加密后的字符串
	 * @throws Exception
	 */
	public static String getSHA1(String str) throws Exception {
		
		MessageDigest md = null;
		String strDes = null;
		byte[] bt = str.getBytes();
		try {

			md = MessageDigest.getInstance("SHA-1");
			md.update(bt);
			strDes = bytes2Hex(md.digest()); // to HexString
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Invalid algorithm.");
			return null;
		}
		return strDes;
	}

	public static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}
}
