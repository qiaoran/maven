package com.shangqiu.school.httpcliTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpClientTest {
	private static HttpClient httpClient = new DefaultHttpClient();

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static void main(String[] args) throws ClientProtocolException, IOException {
		HttpClientTest clientTest = new HttpClientTest();
		Map<String, String> map = new HashMap<String, String>();
		map.put("number", "11");
		map.put("date", "2016-01");
		clientTest.httpGet("http://localhost:8081/sq/api/check", map);
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("formid", "11");
		map1.put("images", "dasdfsaf,1231313");
		clientTest.httpGet("http://localhost:8081/sq/api/save", map1);
	}

	public static void httpGet(String url, Map<String, String> requestParams) {
		HttpGet httpGet = null;
		try {
			// 参数设置
			StringBuilder builder = new StringBuilder(url);
			builder.append("?");
			for (Map.Entry<String, String> entry : requestParams.entrySet()) {
				builder.append((String) entry.getKey());
				builder.append("=");
				builder.append((String) entry.getValue());
				builder.append("&");
			}
			String tmpUrl = builder.toString();
			tmpUrl = tmpUrl.substring(0, tmpUrl.length() - 1);
			httpGet = new HttpGet(tmpUrl);
			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity httpEntity = response.getEntity();
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Object> map = objectMapper.readValue(EntityUtils.toString(httpEntity), Map.class);
			System.out.println(map.get("success"));

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (httpGet != null) {
				httpGet.abort();
			}
		}
	}

}
