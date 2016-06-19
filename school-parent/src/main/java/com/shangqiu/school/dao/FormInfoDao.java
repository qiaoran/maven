package com.shangqiu.school.dao;

import org.springframework.stereotype.Repository;

import com.shangqiu.school.entity.business.FormInfo;
import com.shangqiu.school.util.dao.PageHibernateDao;

/**
 * 发票信息持久化
 * @author joy-pc
 *
 */
@Repository
public class FormInfoDao  extends PageHibernateDao<FormInfo, Long> {

}
