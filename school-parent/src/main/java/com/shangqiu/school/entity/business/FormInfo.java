package com.shangqiu.school.entity.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.shangqiu.school.entity.BaseEntity;

/**
 * 发票基本信息
 * @author joy-pc
 *
 */
@Entity
@Table(name = "bs_form_info")
public class FormInfo  extends BaseEntity {
	/**
	 * 发票名称
	 */
	private String name;
	/**
	 * 发票类型(差旅，住宿，餐饮)
	 */
	private Long rbType;
	/**
	 * 上传发票用户id
	 */
	private Long crateUserId;
	/**
	 * 删除标识
	 */
	private Boolean isclosed = false;
	
	/**
	 * 金额
	 */
	private int money;
	
	/**
	 * 发票类型（增值税，普通）
	 */
	private Long type;
	
	/**
	 * 关联的发票图片地址
	 */
	@Transient
	private List<FormInfoImage> images ;

	public List<FormInfoImage> getImages() {
		if(null==images){
			return new ArrayList<FormInfoImage>();
		}
		return images;
	}

	public void setImages(List<FormInfoImage> images) {
		this.images = images;
	}

	public Long getCrateUserId() {
		return crateUserId;
	}

	public void setCrateUserId(Long crateUserId) {
		this.crateUserId = crateUserId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRbType() {
		return rbType;
	}

	public void setRbType(Long rbType) {
		this.rbType = rbType;
	}

	public Boolean getIsclosed() {
		return isclosed;
	}

	public void setIsclosed(Boolean isclosed) {
		this.isclosed = isclosed;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}
	
	
	

}
