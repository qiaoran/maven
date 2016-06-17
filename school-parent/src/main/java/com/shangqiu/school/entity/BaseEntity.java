package com.shangqiu.school.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author qiaoran
 *
 */
@MappedSuperclass
public class BaseEntity  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
    public Long pid;
	
	/**
	 * 创建时间
	 */
	@Column(name = "create_date", updatable = false)
	private Date createDate;
	
	/**
	 * 修改事件
	 */
	private Date updateDate;

    public Long getPid() {
        return pid;
    }

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
    
}
