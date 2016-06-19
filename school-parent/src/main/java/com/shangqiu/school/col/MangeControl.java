package com.shangqiu.school.col;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shangqiu.school.col.base.BaseController;

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
	 * 首页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/home")
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/business/manage");
	}
}
