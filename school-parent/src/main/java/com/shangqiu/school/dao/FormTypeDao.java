package com.shangqiu.school.dao;

import org.springframework.stereotype.Repository;

import com.shangqiu.school.entity.business.FormType;
import com.shangqiu.school.util.dao.PageHibernateDao;

/**
 * 发票分类持久化
 * @author joy-pc
 *
 */
@Repository
public class FormTypeDao extends PageHibernateDao<FormType, Long> {

}
