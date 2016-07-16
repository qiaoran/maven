package org.util.common;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MD5Util {

	/**
	 * 
	 * 新的md5签名，首尾放secret。
	 * @param secret 分配给您的APP_SECRET
	 */

	public static String md5Signature(TreeMap<String, String> params, String secret) {

		String result = null;

		StringBuffer orgin = getBeforeSign(params, new StringBuffer(secret));

		if (orgin == null)

			return result;

		orgin.append(secret);

		try {

			MessageDigest md = MessageDigest.getInstance("MD5");

			result = byte2hex(md.digest(orgin.toString().getBytes("utf-8")));

		} catch (Exception e) {

			throw new java.lang.RuntimeException("sign error !");

		}
		
		return result;

	}

	/**
	 * 
	 * 二行制转字符串
	 */

	private static String byte2hex(byte[] b) {

		StringBuffer hs = new StringBuffer();

		String stmp = "";

		for (int n = 0; n < b.length; n++) {

			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));

			if (stmp.length() == 1)

				hs.append("0").append(stmp);

			else

				hs.append(stmp);

		}

		return hs.toString().toUpperCase();

	}

	/**
	 * 
	 * 添加参数的封装方法
	 */

	private static StringBuffer getBeforeSign(TreeMap<String, String> params, StringBuffer orgin) {

		if (params == null){

			return null;
			
		}

		Map<String, String> treeMap = new TreeMap<String, String>();

		treeMap.putAll(params);

		Iterator<String> iter = treeMap.keySet().iterator();

		while (iter.hasNext()) {

			String name = (String) iter.next();

			orgin.append(name).append(params.get(name));

		}

		return orgin;

	}
	
	
	/************************************** 生成MD5加密字符串 ***********************************************/
	
	public final static String MD5(String s) {
		
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		
		try {
			
			byte[] btInput = s.getBytes();// 获得MD5摘要算法的 MessageDigest 对象
			
			MessageDigest mdInst = MessageDigest.getInstance("MD5");// 使用指定的字节更新摘要
			
			mdInst.update(btInput);// 获得密文
			
			byte[] md = mdInst.digest();// 把密文转换成十六进制的字符串形式
			
			int j = md.length;
			
			char str[] = new char[j * 2];
			
			int k = 0;
			
			for (int i = 0; i < j; i++) {
				
				byte byte0 = md[i];
				
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				
				str[k++] = hexDigits[byte0 & 0xf];
				
			}
			
			return new String(str);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return "";
			
		}
		
	}
	
	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
	
	public static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname))
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes()));
			else
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes(charsetname)));
		} catch (Exception exception) {
		}
		return resultString;
	}
	
	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
		"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

}