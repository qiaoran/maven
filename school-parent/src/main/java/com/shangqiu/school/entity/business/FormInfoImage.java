package com.shangqiu.school.entity.business;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.shangqiu.school.entity.BaseEntity;

/**
 * 发票关联图片信息
 * @author joy-pc
 *
 */
@Entity
@Table(name = "bs_form_info")
public class FormInfoImage extends BaseEntity {
	
	/**
	 * 图片地址
	 */
	private String imageUrl;
	/**
	 * 关联发票信息id
	 */
	private Long formInfoId;
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Long getFormInfoId() {
		return formInfoId;
	}
	public void setFormInfoId(Long formInfoId) {
		this.formInfoId = formInfoId;
	}
	

}
