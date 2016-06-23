package com.shangqiu.school.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shangqiu.school.dao.FormInfoDao;
import com.shangqiu.school.dao.FormInfoImageDao;
import com.shangqiu.school.entity.business.FormInfo;
import com.shangqiu.school.entity.business.FormInfoImage;
import com.shangqiu.school.service.FormInfoService;
import com.shangqiu.school.util.DataGridModel;
import com.shangqiu.school.util.DateHelper;
import com.shangqiu.school.util.dao.Page;

/**
 * 
 * 发票业务操作实现
 * 
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shangqiu.school.service.FormInfoService#getDateList()
	 */
	@Override
	public List<Map<String, Object>> getMonthdList(String date) {
		// yyyy-MM-dd HH:mm:ss
		Date startDate = DateHelper.parseDatetime(date + "-01-01 00:00:00");
		int dateInt = Integer.parseInt(date);
		dateInt = dateInt + 1;
		Date endDate = DateHelper.parseDatetime(dateInt + "-01-01 00:00:00");
		return this.formInfoDao.getYearMonthList(startDate, endDate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shangqiu.school.service.FormInfoService#getYearList()
	 */
	@Override
	public List<Map<String, Object>> getYearList() {
		List<Map<String, Object>> list = this.formInfoDao.getYearLists();
		if (list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				list.get(i).put("months", this.getMonthdList((String) list.get(i).get("myyear")));
			}
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.shangqiu.school.service.FormInfoService#getFormPages(java.lang.String, com.shangqiu.school.entity.business.FormInfo, com.shangqiu.school.util.DataGridModel)
	 */
	public Page<FormInfo> getFormPages(String date, FormInfo formInfo, DataGridModel dataGrid) {
		Date startDate = null;
		Date endDate = null;
		if(null!=date&&!"".equals(date)){
			startDate = DateHelper.parseDatetime(date + "-01 00:00:00");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(startDate);
			calendar.add(Calendar.MONTH, 1);
			endDate = calendar.getTime();
		}
		Page<FormInfo> page = this.formInfoDao.getPages(startDate, endDate, this.pageAdapter(dataGrid), formInfo);
		return page;
	}

	public Page<FormInfo> pageAdapter(DataGridModel dataGrid) {
		Page<FormInfo> page = new Page<FormInfo>();
		page.setPageNo(dataGrid.getPage());
		page.setPageSize(dataGrid.getRows());
		return page;
	}
	
	/* (non-Javadoc)
	 * @see com.shangqiu.school.service.FormInfoService#getFormInfo(java.lang.Long)
	 */
	public FormInfo getFormInfo(Long id){
		FormInfo formInfo = this.formInfoDao.get(id);
		formInfo.setImages(this.formInfoImageDao.findBy("formInfoId", formInfo.getPid()));
		return formInfo;
	}
	
	/* (non-Javadoc)
	 * @see com.shangqiu.school.service.FormInfoService#saveFormInfo(com.shangqiu.school.entity.business.FormInfo)
	 */
	@Transactional(readOnly = false)
	public FormInfo saveFormInfo(FormInfo formInfo){
		String[] imags = null ;
		if(null!=formInfo.getImagearrsy()&&!"".equals(formInfo.getImagearrsy())){
			imags = formInfo.getImagearrsy().split(",");
		}
		formInfo = this.formInfoDao.save(formInfo);
		if(null!=formInfo.getPid()){
			this.formInfoImageDao.deleteImage(formInfo.getPid());
		}
		if(null!=imags){
			FormInfoImage formInfoImage ;
			for(int i=0;i<imags.length;i++){
				formInfoImage = new FormInfoImage();
				formInfoImage.setImageUrl(imags[i]);
				formInfoImage.setFormInfoId(formInfo.getPid());
				this.formInfoImageDao.save(formInfoImage);
			}
		}
		return formInfo;
	}
	
	public boolean check(String number,String date,Long pid){
		Date startDate = DateHelper.parseDatetime(date + "-01 00:00:00");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(Calendar.MONTH, 1);
		Date endDate = calendar.getTime();
		List<FormInfo> list = this.formInfoDao.checkForm(number, startDate, endDate,pid);
		if(list.size()>0){
			return false;
		}
		return true;
	}
	@Transactional(readOnly = false)
	public boolean delete(Long id){
		try {
			this.formInfoDao.deleteForm(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * 根据number获取发票信息
	 * @param number
	 * @return
	 */
	public FormInfo getByNumber(String number,String date){
		Date startDate = DateHelper.parseDatetime(date + "-01 00:00:00");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(Calendar.MONTH, 1);
		Date endDate = calendar.getTime();
		List<FormInfo> list = this.formInfoDao.checkForm(number, startDate, endDate,null);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	public void saveFormImage(String imaglist,Long pid){
		String[] imags = null ;
		if(null!=imaglist&&!"".equals(imaglist)){
			imags = imaglist.split(",");
		}
		if(null!=imags){
			FormInfoImage formInfoImage ;
			for(int i=0;i<imags.length;i++){
				formInfoImage = new FormInfoImage();
				formInfoImage.setImageUrl(imags[i]);
				formInfoImage.setFormInfoId(pid);
				this.formInfoImageDao.save(formInfoImage);
			}
		}
	}

}
