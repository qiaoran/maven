/**
 * 账号类型枚举
 */
package com.shangqiu.school.entity.emue;

/**
 * @author joy
 *
 */
public enum AccountType {
	
	/**
	 * 装修公司
	 */
	company("装修公司"),
	/**
	 * 装修精英-散工
	 */
	casualWorker("散工"),
	/**
	 * 装修精英-设计师
	 */
	designer("设计师"),
	/**
	 * 工长
	 */
	foreman("工长"),
	/**
	 * 家政服务商
	 */
	houseKeeping("家政服务商"),
	/**
	 * 消费者-个人
	 */
	personal("消费者"),
	
	/**
	 * 商城商家
	 */
	business("商城商家");
	
	/**
	 *默认构造函数
	 */
	private String value;
	private AccountType(String value){
		this.value = value;
	}
	public String getValue(){
		return this.value;
	}
	

}
