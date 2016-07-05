package org.bussiness;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tgb.SpringActivemq.mq.base.LogQueueProducer;

@Controller
public class UserControl {
	@Autowired
	private UserService userService;
	@Autowired
	private LogQueueProducer logQueueProducer;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("userlist")
	@ResponseBody
	public Map<String, Object> getUserList(HttpServletRequest request, HttpServletResponse response) {
/*
		ServletContext servletContext =request.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		userService = (UserService) context.getBean("userService");
*/
		Map<String, Object> map = new HashMap<String, Object>();
		userService.getUserById(null);
		
		logQueueProducer.send("ssssssssssssssssssssssssssssssssss");
		return map;
	}

}
