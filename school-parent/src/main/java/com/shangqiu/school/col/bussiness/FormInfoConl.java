package com.shangqiu.school.col.bussiness;

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
	 * 保持发票信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> save(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String, Object>();
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
	public ModelAndView info(HttpServletRequest request, HttpServletResponse response,String pid) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("formInfo", this.formInfoService.getFormInfo(new Long(pid)));
		return new ModelAndView("/business/fromInfo",map);
	}
}
