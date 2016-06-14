package com.shangqiu.school.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

import com.shangqiu.school.entity.emue.AccountType;
import com.shangqiu.school.util.DateHelper;

/**
 * 账号信息主表
 * @author qiaoran
 *
 */
@Entity
@Table(name = "bs_account")
public class Account extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6272089075894374799L;
	/**
	 * 登录账号
	 */
	@Column(name = "account", length = 100)
	@NotEmpty(message = "账户名不能为空")
	private String account;
	/**
	 * 登录密码
	 */
	@Column(name = "passward", length = 100)
	@NotEmpty(message = "密码不能为空")
	private String passward;
	/**
	 * 账号类型
	 */
	@Column(name = "role", length = 100)
	@Enumerated(EnumType.STRING)
	private AccountType role;

	/**
	 * 注册时间
	 */
	@Column(name = "createdate", updatable = false)
	private Date createDate;

	/**
	 * 最后登录时间
	 */
	@Column(name = "lastLogintime")
	private Date lastLoginTime;
	/**
	 * 电话号码
	 */
	@Column(name = "mobile", length = 20)
	private String mobile;
	/**
	 * 邮箱地址
	 */
	@Column(name = "email", length = 50)
	private String email;
	/**
	 * 账号是否被关闭(禁用)
	 */
	@Column(name = "isclosed")
	private Boolean isclosed = false;

	/**
	 * 昵称
	 */
	private String nickName;

	/**
	 * 头像地址
	 */
	private String logoUrl;
	/**
	 * 生日
	 */
	private Date brithday;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 登陆次数
	 */
	private int logincun;

	/**
	 * 审核状态 1：审核通过 0：未审核
	 */
	private int accountTyep;
	
	@Transient
	private String token;
	

	public String getPassward() {
		return passward;
	}

	public void setPassward(String passward) {
		this.passward = passward;
	}

	public AccountType getRole() {
		return role;
	}

	public void setRole(AccountType role) {
		this.role = role;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public String getLastLoginTimeWiew() {
		if (null != this.lastLoginTime) {
			return DateHelper.toTime(this.lastLoginTime);
		}
		return "";
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	public Boolean getIsclosed() {
		return isclosed;
	}

	public void setIsclosed(Boolean isclosed) {
		this.isclosed = isclosed;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public Date getBrithday() {
		return brithday;
	}

	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getLogincun() {
		return logincun;
	}

	public void setLogincun(int logincun) {
		this.logincun = logincun;
	}

	public int getAccountTyep() {
		return accountTyep;
	}

	public void setAccountTyep(int accountTyep) {
		this.accountTyep = accountTyep;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
