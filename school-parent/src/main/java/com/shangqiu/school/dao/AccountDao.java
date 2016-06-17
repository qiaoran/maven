package com.shangqiu.school.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.shangqiu.school.entity.Account;
import com.shangqiu.school.util.dao.PageHibernateDao;
/**
 * 登陆账号数据持久
 * @author qiaoran
 *
 */
@Repository
public class AccountDao extends PageHibernateDao<Account, Long> {

	/**
	 * @param account
	 * @return
	 */
	public Account queryByAccount(String account) {
		List<Account> list = this.findBy("account", account);
		if(list != null && list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}

	/**
	 * @param mobile
	 * @return
	 */
	public Account queryByMobile(String mobile) {
		return this.findUniqueBy("mobile", mobile);
	}

	/**
	 * @param email
	 * @return
	 */
	public Account queryByEmail(String email) {
		return this.findUniqueBy("email", email);
	}

	/**
	 * @param account
	 * @param cipherPassword
	 * @return
	 */
	public Account verifyLoginByAccount(String account, String cipherPassword) {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("account", account);
		param.put("passward", cipherPassword);
		
		return this.findUnique(" from Account a where a.account=:account and a.passward=:passward", param);
	}

	/**
	 * @param mobile
	 * @param cipherPassword
	 * @return
	 */
	public Account verifyLoginByMobile(String mobile, String cipherPassword) {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("mobile", mobile);
		param.put("passward", cipherPassword);
		return this.findUnique(" from Account where mobile=:mobile and passward=:passward", param);
	}

	/**
	 * @param email
	 * @param cipherPassword
	 * @return
	 */
	public Account verifyLoginByEmail(String email, String cipherPassword) {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("email", email);
		param.put("passward", cipherPassword);
		
		return this.findUnique(" from Account where email=:email and passward=:passward", param);
	}
	
}
