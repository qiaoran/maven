package com.shangqiu.school.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

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
	private Long roleid;

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
	 * 登陆次数
	 */
	private int logincun;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassward() {
		return passward;
	}
	public void setPassward(String passward) {
		this.passward = passward;
	}
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
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
	public int getLogincun() {
		return logincun;
	}
	public void setLogincun(int logincun) {
		this.logincun = logincun;
	}


}
