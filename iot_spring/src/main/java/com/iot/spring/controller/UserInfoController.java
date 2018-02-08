package com.iot.spring.controller;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
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
@RequestMapping("/userInfo")
public class UserInfoController {
	private static final Logger log = LoggerFactory.getLogger(UserInfoController.class);
	
	@Autowired
	private UserInfoService us;
		
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody List<UserInfoVO> getUserInfoListAjax(Model m) {
		List<UserInfoVO> userInfoList = us.getUserInfoList();
		return userInfoList;
	}
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public @ResponseBody List<UserInfoVO> getUserInfoInsertAjax(Model m) {
		List<UserInfoVO> userInfoList = us.getUserInfoList();
		return userInfoList;
	}
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public @ResponseBody List<UserInfoVO> getUserInfoUpdateAjax(Model m) {
		List<UserInfoVO> userInfoList = us.getUserInfoList();
		return userInfoList;
	}
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public @ResponseBody List<UserInfoVO> getUserInfoDeleteAjax(Model m) {
		List<UserInfoVO> userInfoList = us.getUserInfoList();
		return userInfoList;
	}
}
