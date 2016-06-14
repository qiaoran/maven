package com.shangqiu.school.util;

import java.security.MessageDigest;

/**
 * Copyright (c) 2015-2016 youzhai.com
 *
 * com.xnac.yz.utilsSHAEncryptor.java
 *
 * @author Andrew
 * @date 2015年9月9日 上午9:17:08
 * @description 
 *
 */
public class SHAEncryptor {
	
	private static final String SHA256 = "SHA-256";

	/**
	 * @param plainText
	 * @return
	 */
	public static String hash(String plainText) {
		
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(SHA256);

			byte[] dataBytes = plainText.getBytes("UTF-8");
			messageDigest.update(dataBytes);
			
			byte[] cipherBytes = messageDigest.digest();
			
			return byte2hex(cipherBytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 将byte数组转换为16进制表示
	 * @param byteArray
	 * @return
	 */
    private static String byte2hex(byte[] byteArray) {
        StringBuffer md5StrBuff = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                md5StrBuff.append("0").append(
                        Integer.toHexString(0xFF & byteArray[i]));
            } else {
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
            }
 
        }
        return md5StrBuff.toString();
    }
}
