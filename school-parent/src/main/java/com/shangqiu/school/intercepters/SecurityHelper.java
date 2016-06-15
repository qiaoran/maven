package com.shangqiu.school.intercepters;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.shangqiu.school.col.base.BaseController;
import com.shangqiu.school.entity.Account;

/**
 * @author qiaoran
 *
 */
public class SecurityHelper {

	/**
	 * 获取当前登录用户
	 * 
	 * @return 如果没有登录，返回null
	 */
	public static Account getLoginUser() {
		return (Account) RequestContextHolder.currentRequestAttributes().getAttribute(BaseController.sessionName,
				RequestAttributes.SCOPE_SESSION);
	}
}
