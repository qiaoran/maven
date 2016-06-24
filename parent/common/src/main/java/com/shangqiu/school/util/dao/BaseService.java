package com.shangqiu.school.util.dao;

import com.shangqiu.school.util.DataGridModel;

/**
 * Copyright (c) 2015-2016 youzhai.com
 *
 * com.xnac.yz.daoBaseService.java
 *
 * @author Andrew
 * @date 2015年9月21日 下午3:00:33
 * @description 
 *
 */
public abstract class BaseService<T> {

	public Page<T> pageAdapter(DataGridModel dataGrid) {
		Page<T> page = new Page<T>();
		page.setPageNo(dataGrid.getPage());
		page.setPageSize(dataGrid.getRows());
		return page;
	}
}
