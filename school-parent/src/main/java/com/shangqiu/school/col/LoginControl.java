package com.shangqiu.school.col;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shangqiu.school.col.base.BaseController;
import com.shangqiu.school.entity.Account;
import com.shangqiu.school.service.AccountService;

/**
 * @author joy-pc
 *
 */
@Controller
public class LoginControl extends BaseController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private AccountService accountService;

	/**
	 * login verify
	 * 
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "/user/login/verify", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> verifyLogin(Account account, boolean autologin, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> rsMap = new HashMap<String, Object>();
		boolean success = false;
		String message = "";
		Account realAccount = null;

		try {
			realAccount = accountService.verifyLogin(account, request, response);
			success = true;
		} catch (Exception e) {
			logger.error("login cerfication faild", e);
			message = e.getMessage();
		}
		rsMap.put("success", success);
		rsMap.put("message", message);
		rsMap.put("account", realAccount);

		return rsMap;
	}

	/**
	 * 退出
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/user/logout")
	@ResponseBody
	public Map<String, Object> logout(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> rsMap = new HashMap<String, Object>();
		destorySession(request);
		rsMap.put("success", true);
		return rsMap;
	}
}
