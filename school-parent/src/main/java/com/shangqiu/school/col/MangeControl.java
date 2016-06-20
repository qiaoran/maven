package com.shangqiu.school.col;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shangqiu.school.col.base.BaseController;
import com.shangqiu.school.service.FormInfoService;

/**
 * 主界面
 * 
 * @author joy-pc
 *
 */
@Controller
@RequestMapping("/manage")
public class MangeControl extends BaseController {
	/**
	 * 发票信息业务操作注入
	 */
	@Autowired
	private FormInfoService formInfoService;
	/**
	 * 首页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/home")
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> dateLists = new HashMap<String, Object>();
		dateLists.put("yearLists", this.formInfoService.getYearList());
		return new ModelAndView("/business/manage",dateLists);
	}
}
