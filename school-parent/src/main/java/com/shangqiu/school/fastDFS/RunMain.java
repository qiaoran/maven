package com.shangqiu.school.fastDFS;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2015-2016 youzhai.com
 * </p>
 *
 * @Title: RunMain.java
 *         </p>
 * @Package: com.xnac.yz.fstfs
 *           </p>
 * @author: gavin
 *          </p>
 * @date 2015/9/23 10:51
 *       </p>
 * @Description: (用一句话描述该文件做什么)
 */
public class RunMain {

	public static void main(String[] args) throws Exception {
		List<String> list = new ArrayList<String>();
		list.add("101.201.196.237:22122");
		FastdfsClient fastdfsClient = new FastdfsClient(list);
		//http://image.58zmj.com/group1/M00/00/09/ZcnE7VaKKBqAU-IvAARX4qWGbuo513.jpg
		System.out.println(fastdfsClient.upload(new File("D:\\QQ截图20160512111955.png")));
		// group1/M00/00/00/wKgAM1YCaEKAAtU5AAAAEW8-ji4212.txt
		// String url="group1/M00/00/00/wKgAM1YCFaeADXYpAAAAAAAAAAA579.txt";
		fastdfsClient.close();
		//new RunMain().testCopy();
	}

	public void testCopy() {
		URL url;
		try {
			url = new URL("http://192.168.1.51:8000/group1/M00/01/1D/wKgBM1cq2nyAMnO7AAHxpzi2_qU703.png");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			DataInputStream in = new DataInputStream(connection.getInputStream());
			
			System.out.println(connection.getContentLength());
			List<String> list = new ArrayList<String>();
			list.add("192.168.1.51:22122");
			FastdfsClient fastdfsClient = new FastdfsClient(list);

			System.out.println(fastdfsClient.uploadByIO(in, connection.getContentLength(), "bmj.png"));
			// group1/M00/00/00/wKgAM1YCaEKAAtU5AAAAEW8-ji4212.txt
			// String url="group1/M00/00/00/wKgAM1YCFaeADXYpAAAAAAAAAAA579.txt";
			fastdfsClient.close();
		/*	
			
			DataOutputStream out = new DataOutputStream(new FileOutputStream("D://ddd.png"));
			byte[] buffer = new byte[4096];
			int count = 0;
			while ((count = in.read(buffer)) > 0) {
				out.write(buffer, 0, count);
			}
			out.close();*/
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
