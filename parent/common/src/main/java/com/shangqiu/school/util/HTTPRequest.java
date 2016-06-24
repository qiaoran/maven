package com.shangqiu.school.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class HTTPRequest {
	
	/**
     * 向指定URL发送GET方法的请求
     * 
     * @param url 发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
    
    public static String sendPost(String urlStr, String content) {

		URL url = null;

		HttpURLConnection connection = null;

		try {

			url = new URL(urlStr);

			connection = (HttpURLConnection) url.openConnection();

			connection.setDoOutput(true);

			connection.setDoInput(true);
			
			connection.setConnectTimeout(30000);
			
			connection.setReadTimeout(30000);

			connection.setRequestMethod("POST");

			connection.setUseCaches(false);

			connection.connect();

			DataOutputStream out = new DataOutputStream(connection.getOutputStream());

			out.write(content.getBytes("utf-8"));

			out.flush();

			out.close();

			BufferedReader reader =

			new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));

			StringBuffer buffer = new StringBuffer();

			String line = "";

			while ((line = reader.readLine()) != null) {

				buffer.append(line);

			}

			reader.close();

			return buffer.toString();

		} catch (IOException e) {

			e.printStackTrace();
			
			return Constants.RESULT_CODE_00001;

		} finally {

			if (connection != null) {

				connection.disconnect();

			}
			
		}

	}
    
    
	
}
