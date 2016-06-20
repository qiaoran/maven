package com.shangqiu.school.service;

import java.util.List;
import java.util.Map;

import com.shangqiu.school.entity.business.FormInfo;
import com.shangqiu.school.util.DataGridModel;
import com.shangqiu.school.util.dao.Page;

/**
 * 电子发票业务操作
 * @author joy-pc
 *
 */
public interface FormInfoService {
	
	/**
	 * 获取库中有的年月节点
	 * @return
	 */
	public List<Map<String,Object>> getMonthdList(String date);
	/**
	 * 获取库中有的年份
	 * @return
	 */
	public List<Map<String,Object>> getYearList();
	
	/**
	 * 根据时间获取发票信息列表
	 * @param date
	 * @return
	 */
	public Page<FormInfo> getFormPages(String date,FormInfo formInfo,DataGridModel dataGrid);
	
	/**
	 * 获取发票详情
	 * @param id
	 * @return
	 */
	public FormInfo getFormInfo(Long id);

}
