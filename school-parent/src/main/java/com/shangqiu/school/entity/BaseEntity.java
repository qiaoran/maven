package com.shangqiu.school.entity;


import java.io.Serializable;

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

    public Long getPid() {
        return pid;
    }

	public void setPid(Long pid) {
		this.pid = pid;
	}
    
}
