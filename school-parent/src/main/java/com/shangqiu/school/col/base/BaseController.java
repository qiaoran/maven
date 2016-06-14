package com.shangqiu.school.col.base;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.shangqiu.school.entity.Account;

/**
 * @author joy-pc
 *
 */
@Controller
public class BaseController {
	/**
	 * 登录用户key
	 */
	public static final String sessionName = "loginAccount";
	@Autowired
	protected ServletContext servletContext;
	
	/**
	 * 根据ip解析地址
	 */
	public static final String addressbo = "addressbo";

	/**
	 * @param fieldErrors
	 * @return
	 * 
	 */
	public String errorAdapter(List<FieldError> fieldErrors) {
		StringBuffer sb = new StringBuffer();
		for (FieldError fe : fieldErrors) {
			sb.append("字段[" + fe.getField() + "]" + fe.getDefaultMessage() + "; ");
		}
		return sb.toString();
	}

	/**
	 * 
	 * @param errors
	 * @return
	 * 
	 */
	public String errorAdapter(Errors errors) {
		return this.errorAdapter(errors.getFieldErrors());
	}

	/**
	 * 获取session中账户信息
	 * 
	 * @param request
	 * @return
	 */
	public Account getSessionAccount(HttpServletRequest request) {
		return (Account) request.getSession(true).getAttribute(sessionName);
	}

	/**
	 * session中添加账户信息
	 * 
	 * @param request
	 * @param account
	 */
	public void setSessionAccount(HttpServletRequest request, Account account) {
		request.getSession(true).setAttribute(sessionName, account);
	}



}