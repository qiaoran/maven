package com.shangqiu.school.col.bussiness;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shangqiu.school.entity.business.FormInfo;
import com.shangqiu.school.service.FormInfoService;

/**
 * 临时工具api
 * @author joy-pc
 *
 */
@Controller
@RequestMapping("/sq/api")
public class BussApi{
	/**
	 * 发票信息业务操作注入
	 */
	@Autowired
	private FormInfoService formInfoService;
	
	/**
	 * 根据文件夹日期（2016-09）
	 * @param request
	 * @param response
	 * @param number
	 * @param date
	 * @return
	 */
	@RequestMapping("/check")
	@ResponseBody
	public Map<String,Object> check(HttpServletRequest request, HttpServletResponse response,String number,String date) {
		Map<String,Object> map = new HashMap<String, Object>();
		FormInfo forminfo = this.formInfoService.getByNumber(number,date);
		if(null!=forminfo){
			map.put("success", true);
			map.put("formid", forminfo.getPid());
		}else{
			map.put("success", false);
			map.put("message", "该月份下不存在该编号的发票");
		}
		return map;
	}
	
	/**
	 * 保存发票图片
	 * @param request
	 * @param response
	 * @param images 用“,”分割 String
	 * @param formid 表单id，Long类型
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Map<String,Object> saveImage(HttpServletRequest request, HttpServletResponse response,String images,Long formid) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			this.formInfoService.saveFormImage(images, formid);
			map.put("success", true);
		} catch (Exception e) {
			map.put("success", false);
		}
		return map;
	}
	
	

}
