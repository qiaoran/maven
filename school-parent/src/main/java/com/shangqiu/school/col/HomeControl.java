package com.shangqiu.school.col;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shangqiu.school.col.base.BaseController;
import com.shangqiu.school.entity.Account;
import com.shangqiu.school.intercepters.SecurityHelper;

/**
 * @author joy
 *
 */
@Controller
public class HomeControl extends BaseController {
	/**
	 * 打开首页
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		Account account = SecurityHelper.getLoginUser();
		if (null == account || null == account.getPid()) {
			mav = new ModelAndView("/base/login");
		} else {
			try {
				response.sendRedirect("/manage/home");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return mav;

	}

	@RequestMapping("/error")
	public ModelAndView error(HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/common/e404");
		return mav;
	}

}
