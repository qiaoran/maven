package com.shangqiu.school.col.bussiness;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shangqiu.school.col.base.BaseController;
import com.shangqiu.school.entity.business.FormInfo;
import com.shangqiu.school.service.FormInfoService;
import com.shangqiu.school.util.DataGridModel;
import com.shangqiu.school.util.DateHelper;

/**
 * 发票管理控制层
 * @author joy-pc
 *
 */
@Controller
@RequestMapping("/manage/form")
public class FormInfoConl extends BaseController {
	/**
	 * 发票信息业务操作注入
	 */
	@Autowired
	private FormInfoService formInfoService;
	/**
	 * 获取发票列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/lists")
	public ModelAndView lists(HttpServletRequest request, HttpServletResponse response,String date,DataGridModel dataGrid,FormInfo formInfo) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("result", this.formInfoService.getFormPages(date, formInfo, dataGrid));
		map.put("pageDate", date);
		return new ModelAndView("/business/formInfoLists",map);
	}
	/**
	 * 打开新增发票信息页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/business/formInfoAdd");
	}
	/**
	 * 打开修改发票信息页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/update")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response,Long formId) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("forminfo", this.formInfoService.getFormInfo(formId));
		return new ModelAndView("/business/formInfoAdd",map);
	}
	/**
	 * 保持发票信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> save(HttpServletRequest request, HttpServletResponse response,FormInfo formInfo,String newDate) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			formInfo.setFormReim(DateHelper.parseDate(newDate));
		} catch (Exception e) {
			formInfo.setFormReim(new Date());
		}
		formInfo.setCrateUserId(this.getSessionAccount(request).getPid());
		if(null==formInfo.getPid()){
			formInfo.setCreateDate(new Date());
		}
		formInfo.setUpdateDate(new Date());
		try {
			formInfo = this.formInfoService.saveFormInfo(formInfo);
			map.put("success", true);
		} catch (Exception e) {
			map.put("success", false);
		}
		return map;
	}
	/**
	 * 获取某个发票信息
	 * @param request
	 * @param response
	 * @param pid 发票信息id
	 * @return
	 */
	@RequestMapping("/info")
	public ModelAndView info(HttpServletRequest request, HttpServletResponse response,Long formId) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("formInfo", this.formInfoService.getFormInfo(formId));
		return new ModelAndView("/business/formInfo",map);
	}
	/**
	 * 校验发票订单编号唯一性
	 * @param request
	 * @param response
	 * @param newDate
	 * @param pid 如果为修改，那么不应该匹配这个被修改的pid
	 * @return
	 */
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> check(HttpServletRequest request, HttpServletResponse response,String newDate,String number,Long pid) {
		Map<String,Object> map = new HashMap<String, Object>();
		String[] datdss = newDate.split("-");
		newDate = datdss[0]+"-"+datdss[1];
		map.put("success", this.formInfoService.check(number,newDate,pid));
		return map;
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> delete(HttpServletRequest request, HttpServletResponse response,Long formId) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("success", this.formInfoService.delete(formId));
		return map;
	}
}
