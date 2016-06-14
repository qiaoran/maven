package com.shangqiu.school.col.base;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.shangqiu.school.fastDFS.FastdfsClient;

/**
 * @author qiaoran
 *
 */
@Controller
@RequestMapping("/common")
public class CommonController extends BaseController {

	private static Logger logger = LogManager.getLogger(CommonController.class);

	@Autowired
	private FastdfsClient fastdfsClient;

	/***
	 * data.message data.code data.url
	 **/
	@RequestMapping("/upload")
	@ResponseBody
	public Map<String, Object> upload(ServletResponse response, @RequestParam CommonsMultipartFile file, String name) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean success = false;
		String message = "";
		String url = "";
		try {
			File newfile = ((DiskFileItem) file.getFileItem()).getStoreLocation();
			url = fastdfsClient.upload(newfile, file.getOriginalFilename());
			success = true;

			logger.info("upload file success. " + url);
		} catch (Exception e) {
			message = e.getMessage();
			logger.error("upload file error", e);
		}

		map.put("success", success);
		map.put("message", message);
		map.put("url", url);
		return map;
	}

	@RequestMapping("/deleteImage")
	@ResponseBody
	public Map<String, Object> deleteImage(String url) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean success = false;
		String message = "";
		try {
			fastdfsClient.delete(url);
			success = true;
		} catch (Exception e) {
			message = e.getMessage();
			logger.error("delete file error", e);
		}

		map.put("success", success);
		map.put("message", message);
		map.put("url", url);
		return map;
	}

}
