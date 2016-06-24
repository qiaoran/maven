package com.shangqiu.school.util;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;


@SuppressWarnings({ "serial", "unused" })
public class DataGridModel implements Serializable {

	private int page = 1;// 当前页
	private int rows = 10;// 当前页条数
	private int count;// 总记录数
	private int startRow;// 开始行
	
	private String sortAlias; // 需要排序的字段名
	private boolean ascending; // true:asc, false:desc

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getStartRow() {
		return rows * (page - 1);
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public String getSortAlias() {
		return sortAlias;
	}

	public void setSortAlias(String sortAlias) {
		this.sortAlias = sortAlias;
	}

	public boolean isAscending() {
		return ascending;
	}

	public void setAscending(boolean ascending) {
		this.ascending = ascending;
	}
	
	/**
	 * 拼装排序字符串(不包括order by关键字)
	 * @return
	 */
	public String sorting() {
		if (StringUtils.isNotEmpty(sortAlias)) {
			return sortAlias + " " + (ascending ? "ASC" : "DESC"); 
		}
		return "";
	}
}
