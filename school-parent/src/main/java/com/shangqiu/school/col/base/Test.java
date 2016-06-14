package com.shangqiu.school.col.base;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class Test {
	/*public static void main(String args[]) {
		String targetURL = null;// TODO 指定URL
		File targetFile = null;// TODO 指定上传文件

		targetFile = new File("D:\\temp\\ddd.txt");
		targetURL = "http://127.0.0.1:8080/uploadNew"; 
		PostMethod filePost = new PostMethod(targetURL);

		try {

			Part[] parts = { new FilePart(targetFile.getName(), targetFile) };
			filePost.setRequestEntity(new MultipartRequestEntity(parts, filePost.getParams()));
			HttpClient client = new HttpClient();
			client.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
			int status = client.executeMethod(filePost);
			if (status == HttpStatus.SC_OK) {
				System.out.println("上传成功");
				// 上传成功
			} else {
				System.out.println("上传失败");
				// 上传失败
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			filePost.releaseConnection();
		}
	}*/
	
	 //file1与file2在同一个文件夹下 filepath是该文件夹指定的路径      
    public void SubmitPost(String url,String filename1,String filename2, String filepath){  
          
        HttpClient httpclient = new DefaultHttpClient();  
          
        try {  
            HttpPost httppost = new HttpPost(url);  
            FileBody bin = new FileBody(new File("D:\\temp\\ddd.txt"));  
            MultipartEntity reqEntity = new MultipartEntity();  
            reqEntity.addPart("file", bin);//file1为请求后台的File upload;属性      
            httppost.setEntity(reqEntity);  
            HttpResponse response = httpclient.execute(httppost);  
            int statusCode = response.getStatusLine().getStatusCode();  
            if(statusCode == HttpStatus.SC_OK){  
                System.out.println("服务器正常响应.....");  
                HttpEntity resEntity = response.getEntity();  
                System.out.println(EntityUtils.toString(resEntity));//httpclient自带的工具类读取返回数据  
                System.out.println(resEntity.getContent());     
                EntityUtils.consume(resEntity);  
            }  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  finally {  
                try {   
                    httpclient.getConnectionManager().shutdown();   
                } catch (Exception ignore) {  
                      
                }  
            }  
        }  
      
      
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
          
    	Test httpPostArgumentTest2 = new Test();  
    	// httpPostArgumentTest2.SubmitPost("http://127.0.0.1:8080/uploadNew",  
        httpPostArgumentTest2.SubmitPost("http://192.168.1.51:9012/uploadregion",  
                "test.xml","test.zip","D:\\temp\\ddd.txt");  
    }  
      
}
