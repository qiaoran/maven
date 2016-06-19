package com.shangqiu.school.dao;

import org.springframework.stereotype.Repository;

import com.shangqiu.school.entity.business.FormInfoImage;
import com.shangqiu.school.util.dao.PageHibernateDao;

/**
 * 发票信息关联图片持久化
 * @author joy-pc
 *
 */
@Repository
public class FormInfoImageDao extends PageHibernateDao<FormInfoImage, Long> {

}
