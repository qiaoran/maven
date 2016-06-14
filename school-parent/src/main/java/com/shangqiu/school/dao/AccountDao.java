package com.shangqiu.school.dao;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.shangqiu.school.entity.Account;
import com.shangqiu.school.entity.emue.AccountType;
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
	
	/**
	 * 根据手机号进行唯一性校验
	 * @param mobile
	 * @return
	 */
	public Boolean checkMobile(String mobile){
		boolean  s=false;
		Query querycount =null;
		
		querycount=	this.getSession().createSQLQuery("SELECT count(*) from bs_account a where a.mobile='"+mobile+"' or a.account='"+mobile+"'");
		
		BigInteger  count =(BigInteger)querycount.uniqueResult();
		int b = count.intValue();
		if(b>=1)
			s=false;
			else
			s=true;	
		return s;
	}
	
	/**
	 * 根据手机号进行唯一性校验
	 * @param mobile
	 * @return
	 */
	public boolean checkMobileNew(String mobile){
		String hql = "from Account a where a.mobile='"+mobile+"' or a.account='"+mobile+"'";
		Query query  = this.getSession().createQuery(hql);
		List<Account> list = query.list();
		boolean falt = true;
		for(int i=0;i<list.size();i++){
			if(list.get(i).getRole().equals(AccountType.business)
					||list.get(i).getRole().equals(AccountType.designer)
					||list.get(i).getRole().equals(AccountType.personal)){
				falt = false;
				break;
				
			}
		}
		
		return falt;
	}
}
