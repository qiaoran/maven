package com.shangqiu.school.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shangqiu.school.entity.Account;

/**
 * @author joy-pc
 *
 */
public interface AccountService {

	/**
	 * 登陆
	 * @param account
	 * @param request
	 * @param response
	 * @return
	 */
	public Account verifyLogin(Account account, HttpServletRequest request, HttpServletResponse response) ;
	
	/**
	 * @param pid
	 * @return
	 */
	public Account getAccountById(Long pid);

	/**
	 * @param account
	 */
	public void updateAccount(Account account);

}
