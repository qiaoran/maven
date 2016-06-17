package com.shangqiu.school.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shangqiu.school.col.base.BaseController;
import com.shangqiu.school.dao.AccountDao;
import com.shangqiu.school.entity.Account;
import com.shangqiu.school.service.AccountService;
import com.shangqiu.school.util.BizException;

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

	/**
	 * 登陆验证
	 * 
	 * @param account
	 * @return
	 */
	public Account verifyLogin(Account account, HttpServletRequest request, HttpServletResponse response) {
		Account realAccount = null;
		//String cipherPassword = SHAEncryptor.hash(account.getPassward());

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
			if (!account.getPassward().equals(realAccount.getPassward())) {
				throw new BizException("密码错误");
			}
		} else if (null != account.getMobile() && !"".equals(account.getMobile())) {
			realAccount = accountDao.verifyLoginByMobile(account.getMobile(), account.getPassward());
		} 

		if (null == realAccount) {
			throw new BizException("账户不存在");
		} else if (true == realAccount.getIsclosed()) {
			throw new BizException("账户已经被关闭");
		} else {
			int longnum = realAccount.getLogincun() + 1;
			realAccount.setLastLoginTime(new Date());
			realAccount.setLogincun(longnum);
			realAccount = this.accountDao.save(realAccount);
			logger.info("登陆成功");
			request.getSession(true).setAttribute(BaseController.sessionName, realAccount);
		}

		return realAccount;
	}

	public Account getAccountById(Long pid) {
		return this.accountDao.get(pid);
	}

	public void updateAccount(Account account) {
		this.accountDao.save(account);
	}

}
