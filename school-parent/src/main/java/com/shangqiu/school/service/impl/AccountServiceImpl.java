package com.shangqiu.school.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shangqiu.school.dao.AccountDao;
import com.shangqiu.school.entity.Account;
import com.shangqiu.school.service.AccountService;
import com.shangqiu.school.util.BizException;
import com.shangqiu.school.util.SHAEncryptor;

/**
 * @author joy-pc
 *
 */
@Service("accountService")
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AccountDao accountDao;


	@Deprecated
	@Transactional(readOnly = false)
	public Account saveObje(Account account) {
		try {
			return accountDao.save(account);
		} catch (Exception e) {
			return null;
		}
	}

	public Account updateorsave(Account account) {
		try {
			return accountDao.save(account);
		} catch (Exception e) {
			return null;
		}
	}

	public Account find(Long pid) {
		return accountDao.get(pid);
	}

	/* 根据邮箱查询账户信息 */
	public Account findByEmail(String email) {
		List<Account> list = accountDao.findBy("email", email);
		return list != null ? list.size() > 0 ? list.get(0) : null : null;
	}

	/* 根据手机查询账户信息 */
	public Account findByAccount(String phone) {
		List<Account> list = accountDao.findBy("account", phone);
		return list != null ? list.size() > 0 ? list.get(0) : null : null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xnac.yz.dec.service.AccountServic#verifyLogin(com.xnac.yz.dec.entity.
	 * Account)
	 */
	public Account verifyLogin(Account account, boolean autologin, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Account realAccount = null;
		String cipherPassword = SHAEncryptor.hash(account.getPassward());

		if (null != account.getAccount() && !"".equals(account.getAccount())) {
			realAccount = accountDao.queryByAccount(account.getAccount().trim());
			if (realAccount == null) {
				realAccount = accountDao.queryByEmail(account.getAccount());
			}
			if (null == realAccount) {
				throw new BizException("账户不存在");
			}
			if (realAccount.getIsclosed()) {
				throw new BizException("账户被禁用");
			}
			if (!cipherPassword.equals(realAccount.getPassward())) {
				throw new BizException("密码错误");
			}
			// realAccount =
			// accountDao.verifyLoginByAccount(account.getAccount(),
			// cipherPassword);
		} else if (null != account.getMobile() && !"".equals(account.getMobile())) {
			realAccount = accountDao.verifyLoginByMobile(account.getMobile(), cipherPassword);
		} else if (null != account.getEmail() && !"".equals(account.getEmail())) {
			realAccount = accountDao.verifyLoginByEmail(account.getEmail(), cipherPassword);
		}

		if (null == realAccount) {
			throw new BizException("账户不存在");
		} else {
			realAccount.setLastLoginTime(new Date());
			realAccount = this.accountDao.save(realAccount);
		}
		return realAccount;
	}

	public Account verifyLogin_audio(Account account, boolean autologin, String numb, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getAccountid(String phoneNumber, String username, int type) {
		// TODO Auto-generated method stub
		return null;
	}

	public Account addOrUpdateAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	public Account queryByMobile(String mobile) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
