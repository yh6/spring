package com.iot.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.UserService;
import com.iot.spring.vo.Emp;
import com.iot.spring.vo.UserInfo;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService us;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<UserInfo> getUserListAjax(Model m) {
		List<UserInfo> userList = us.getUserList();
		return userList;
	}
}
