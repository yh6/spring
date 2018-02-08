package com.iot.spring.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.EmpService;
import com.iot.spring.service.UserInfoService;
import com.iot.spring.vo.Emp;
import com.iot.spring.vo.UserInfoVO;

@Controller
@RequestMapping("/userinfo")
public class UserInfoController {
	private static final Logger log = LoggerFactory.getLogger(UserInfoController.class);
	
	@Autowired
	private UserInfoService us;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getUserInfoList(Model m) {
		List<UserInfoVO> userInfoList = us.getUserInfoList();
		m.addAttribute("userInfoList",userInfoList);	
		return "userinfo/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody List<UserInfoVO> getEmpListAjax(Model m) {
		List<Emp> empList = es.getEmpList();
		return empList;
	}
}
