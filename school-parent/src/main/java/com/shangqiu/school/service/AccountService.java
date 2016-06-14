package com.shangqiu.school.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shangqiu.school.entity.Account;

public interface AccountService {

	/**
	 * query by PK id
	 * @param pid
	 * @return
	 */
    public Account find(Long pid);

	/**
	 * verify login
	 * @param account
	 */
	public Account verifyLogin(Account account,boolean autologin, HttpServletRequest request,HttpServletResponse response) throws Exception;
	/**
	 * 自动登录
	 * @param account
	 * @param autologin
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public Account verifyLogin_audio(Account account, boolean autologin,String numb,HttpServletRequest request,HttpServletResponse response) throws Exception;
	
	/**
	 * @param phoneNumber
	 * @param username
	 * @return
	 */
	public Long getAccountid(String phoneNumber,String username,int type);
	
	
	
	/**
	 * 新增或者修改账号
	 * @param account
	 * @return
	 */
	public Account addOrUpdateAccount(Account account);
	
	/**
	 * @param mobile
	 * @return
	 */
	public Account queryByMobile(String mobile);

}
