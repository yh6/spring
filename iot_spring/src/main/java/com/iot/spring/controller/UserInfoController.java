package com.iot.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.UserInfoService;
import com.iot.spring.vo.UserInfoVO;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
	private static final Logger log = LoggerFactory.getLogger(UserInfoController.class);
	
	@Autowired
	private UserInfoService us;
		
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public @ResponseBody List<UserInfoVO> getinsertUserInfo(UserInfoVO ui) {		
		return us.getUserInfoList(ui);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public @ResponseBody List<UserInfoVO> getupdateUserInfo(UserInfoVO ui) {
		return us.getUserInfoList(ui);
	}
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public @ResponseBody List<UserInfoVO> getdeleteUserInfo(UserInfoVO ui) {
		return us.getUserInfoList(ui);
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> login(@Valid UserInfoVO ui, HttpSession hs){
		Map<String,Object> map = new HashMap<String,Object>();
		ui= us.getUserInfo(ui);
		map.put("loginOk", false);
		map.put("msg", "로그인실패");
		if(ui!=null) {	
			hs.setAttribute("userInfo", ui);
			hs.setAttribute("isLogin", true);
			map.put("msg", "로그인성공");	
			map.put("loginOk", true);
		}		
		return map;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> singup (@Valid UserInfoVO ui, HttpSession hs){
		Map<String,Object> map = new HashMap<String,Object>();
		us.insertUserInfo(map, ui);
		return map;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<UserInfoVO> getUserInfoList(UserInfoVO ui){
		return us.getUserInfoList(ui);
	}
	
}
