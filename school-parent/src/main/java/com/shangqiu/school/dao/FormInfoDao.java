package com.shangqiu.school.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.shangqiu.school.entity.business.FormInfo;
import com.shangqiu.school.util.DateHelper;
import com.shangqiu.school.util.dao.Page;
import com.shangqiu.school.util.dao.PageHibernateDao;

/**
 * 发票信息持久化
 * @author joy-pc
 *
 */
@Repository
public class FormInfoDao  extends PageHibernateDao<FormInfo, Long> {
	/**
	 * 获取库中有的年月
	 * @return
	 */
	public List<Map<String,Object>> getYearMonthList(Date starDate,Date endDate){
		String hql = "SELECT DISTINCT(date_format(bs.form_reim,'%Y-%c')) as mymonth,date_format(bs.form_reim,'%c月份') as mymonthname"
				+ " from bs_form_info bs where bs.isclosed = 0 and bs.form_reim >= '"+DateHelper.toTime(starDate)+"' and bs.form_reim <= '"+DateHelper.toTime(endDate)
				+ "' ORDER BY bs.form_reim ASC";
		Query query = this.getSession().createSQLQuery(hql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
	/**
	 * 获取库中有的年
	 * @return
	 */
	public List<Map<String,Object>> getYearLists(){
		String hql = "SELECT DISTINCT(date_format(bs.form_reim,'%Y')) as myyear,date_format(bs.form_reim,'%Y年') as myyearname "
				+ "from bs_form_info bs where bs.isclosed = 0 ORDER BY myyear ASC";
		Query query = this.getSession().createSQLQuery(hql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
	
	/**
	 * 获取发票列表
	 * @param starDate
	 * @param endDate
	 * @param page
	 * @param formInfo
	 * @return
	 */
	public Page<FormInfo> getPages(Date starDate,Date endDate,Page<FormInfo> page,FormInfo formInfo){
		String hql = "FROM FormInfo fo where fo.isclosed = 0 ";
		if(null!=formInfo.getNumber()&&!"".equals(formInfo.getNumber())){
			hql = hql +" and fo.number like '%"+formInfo.getNumber()+"%'";
		}
		if(null!=formInfo.getRebursUser()&&!"".equals(formInfo.getRebursUser())){
			hql = hql +" and fo.rebursUser like '%"+formInfo.getRebursUser()+"%'";
		}
		if(null!=starDate){
			hql = hql + " and fo.formReim >= '"+DateHelper.toTime(starDate)+"'";
		}
		if(null!=endDate){
			hql = hql +" and fo.formReim <= '"+DateHelper.toTime(endDate)+"'";
		}
		Object[] m={};
		return this.findPage(page, hql, m);
	}
	
	/**
	 * 根据日期校验唯一性
	 * @param number
	 * @param starDate
	 * @param endDate
	 * @return
	 */
	public List<FormInfo> checkForm(String number,Date starDate,Date endDate,Long pid){
		String hql = "FROM FormInfo fo where fo.isclosed = 0 and number = '"+number; 
		hql = hql + "' and fo.formReim >= '"+DateHelper.toTime(starDate)+"' and fo.formReim <= '"+DateHelper.toTime(endDate)+"'";
		if(null!=pid){
			hql = hql +" and fo.pid !=" +pid;
		}
		Object[] m={};
		return this.find(hql, m);
	}
	
	/**
	 * 删除发票
	 * @param id
	 */
	public void deleteForm(Long id){
		String hql = "UPDATE FormInfo SET isclosed = 1 where pid =" +id;
		Object[] m={};
		this.batchExecute(hql, m);
	}

}
