package com.shangqiu.school.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 * 支付工具类
 * @author Wang
 */
public class PayUtil {

	/**
	 * 将传入的一个XML String转换成一个org.w3c.dom.Document对象返回。
	 * 
	 * @param xmlString 一个符合XML规范的字符串表达。
	 * @return a Document
	 */
	public static Document parseXMLDocument(String xmlString) {
		if (xmlString == null) {
			throw new IllegalArgumentException();
		}
		try {
			return newDocumentBuilder().parse(
					new InputSource(new StringReader(xmlString)));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	/**  
     * 初始化一个DocumentBuilder  
     *  
     * @return a DocumentBuilder  
     * @throws ParserConfigurationException  
     */  
    public static DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {  
        return newDocumentBuilderFactory().newDocumentBuilder();
    } 
    
	/**
	 * 初始化一个DocumentBuilderFactory
	 * 
	 * @return a DocumentBuilderFactory
	 */
	public static DocumentBuilderFactory newDocumentBuilderFactory() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		return dbf;
	}

	/**
	 * 将请求的数据集合转换为请求xml
	 * 
	 * @param parameters 请求参数集合
	 * @return XML格式参数
	 */
	public static String getRequestXml(Map<Object, Object> parameters) {

		StringBuffer sb = new StringBuffer();

		sb.append("<xml>");

		Set es = parameters.entrySet();

		Iterator it = es.iterator();

		while (it.hasNext()) {

			Map.Entry entry = (Map.Entry) it.next();

			String k = (String) entry.getKey();

			String v = (String) entry.getValue();

			if ("trade_type".equalsIgnoreCase(k)
					|| "attach".equalsIgnoreCase(k)
					|| "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)) {

				sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");

			} else {

				sb.append("<" + k + ">" + v + "</" + k + ">");

			}

		}

		sb.append("</xml>");

		return sb.toString();
	}
	
	/**
	 * 发送HTTPS请求
	 * 
	 * @param requestUrl 请求地址
	 * @param requestMethod 请求方式
	 * @param outputStr 请求参数XML格式
	 * @return
	 */
	public static String httpsRequest(String requestUrl, String requestMethod, String outputStr) {

		try {

			TrustManager[] tm = { new MyX509TrustManager() }; // 创建SSLContext对象，并使用我们指定的信任管理器初始化
			
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");

			sslContext.init(null, tm, new java.security.SecureRandom());

			SSLSocketFactory ssf = sslContext.getSocketFactory();// 从上述SSLContext对象中得到SSLSocketFactory对象

			URL url = new URL(requestUrl);

			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

			conn.setSSLSocketFactory(ssf);

			conn.setDoOutput(true);

			conn.setDoInput(true);

			conn.setUseCaches(false);

			conn.setRequestMethod(requestMethod);// 设置请求方式（GET/POST）

			conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");

			// 当outputStr不为null时向输出流写数据
			if (null != outputStr) {

				OutputStream outputStream = conn.getOutputStream();

				outputStream.write(outputStr.getBytes("UTF-8"));// 注意编码格式

				outputStream.close();

			}

			InputStream inputStream = conn.getInputStream();// 从输入流读取返回内容

			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");

			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;

			StringBuffer buffer = new StringBuffer();

			while ((str = bufferedReader.readLine()) != null) {

				buffer.append(str);

			}

			/* 释放资源 */
			bufferedReader.close();

			inputStreamReader.close();

			inputStream.close();

			inputStream = null;

			conn.disconnect();

			return buffer.toString();

		} catch (ConnectException ce) {

			ce.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;
	}
	
	/**
	 * 构造签名字符串
	 * @param params 参数集
	 * @param appkey APP私钥
	 * @throws Exception
	 */
	public static String createSigns(Map<Object, Object> params, boolean encode, String appkey) throws Exception {

		Set<Object> keysSet = params.keySet();

		Object[] keys = keysSet.toArray();

		Arrays.sort(keys);

		StringBuffer temp = new StringBuffer();

		boolean first = true;

		for (Object key : keys) {

			if (first) {

				first = false;

			} else {

				temp.append("&");

			}

			temp.append(key).append("=");

			Object value = params.get(key);

			String valueString = "";

			if (null != value) {

				valueString = value.toString();

			}

			if (encode) {

				temp.append(URLEncoder.encode(valueString, "UTF-8"));

			} else {

				temp.append(valueString);

			}

		}

		String str = temp.toString();

		str += "&key=" + appkey;

		return str;
	}
	
	
	
	
	
}
