package com.shangqiu.school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shangqiu.school.dao.FormInfoDao;
import com.shangqiu.school.dao.FormInfoImageDao;
import com.shangqiu.school.dao.FormRbTypeDao;
import com.shangqiu.school.dao.FormTypeDao;
import com.shangqiu.school.service.FormInfoService;

/**
 * 
 * 发票业务操作实现
 * @author joy-pc
 *
 */
@Service("formInfoService")
@Transactional(readOnly = true)
public class FormInfoServiceImpl implements FormInfoService {
	@Autowired
	private FormInfoDao formInfoDao;
	@Autowired
	private FormInfoImageDao formInfoImageDao;
	@Autowired
	private FormTypeDao formTypeDao;
	@Autowired
	private FormRbTypeDao formRbTypeDao;

}
