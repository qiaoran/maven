package com.shangqiu.school.entity.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.shangqiu.school.entity.BaseEntity;
import com.shangqiu.school.util.DateHelper;

/**
 * 发票基本信息
 * @author joy-pc
 *
 */
@Entity
@Table(name = "bs_form_info")
public class FormInfo  extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 报销凭证号
	 */
	private String number;
	/**
	 * 发票名称
	 */
	private String name;
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
	private double money;
	
	/**
	 * 报销人名称
	 */
	private String rebursUser;
	
	/**
	 * 摘要
	 */
	private String formAbstract;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 报销时间
	 */
	private Date formReim;
	
	/**
	 * 关联的发票图片地址
	 */
	@Transient
	private List<FormInfoImage> images ;
	
	@Transient
	private String imagearrsy;
	

	public String getImagearrsy() {
		return imagearrsy;
	}

	public void setImagearrsy(String imagearrsy) {
		this.imagearrsy = imagearrsy;
	}

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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Boolean getIsclosed() {
		return isclosed;
	}

	public void setIsclosed(Boolean isclosed) {
		this.isclosed = isclosed;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getRebursUser() {
		return rebursUser;
	}

	public void setRebursUser(String rebursUser) {
		this.rebursUser = rebursUser;
	}

	public String getFormAbstract() {
		return formAbstract;
	}

	public void setFormAbstract(String formAbstract) {
		this.formAbstract = formAbstract;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getFormReim() {
		return formReim;
	}

	public void setFormReim(Date formReim) {
		this.formReim = formReim;
	}
	
	public String getFormReimViem(){
		return DateHelper.toTime(formReim);
	}


}
