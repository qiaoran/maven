package com.shangqiu.school.entity.business;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.shangqiu.school.entity.BaseEntity;

/**
 * 发票报销类型
 * @author joy-pc
 *
 */
@Entity
@Table(name = "bs_form_rb_type")
public class FormRbType extends BaseEntity {
	
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 创建者
	 */
	private Long createUserId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}
	
	

}
