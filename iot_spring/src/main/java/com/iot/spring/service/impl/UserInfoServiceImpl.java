package com.iot.spring.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.UserInfoDAO;
import com.iot.spring.service.UserInfoService;
import com.iot.spring.vo.UserInfoVO;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDAO udao;

	@Override
	public List<UserInfoVO> getUserInfoList(UserInfoVO ui) {
		return udao.selectUserInfoList();
	}
	@Override
	public UserInfoVO getUserInfo(UserInfoVO ui) {
			return null;
	}


	
	@Override
	public int updateUserInfo(UserInfoVO ui) {
		return udao.updateUserInfo(ui);
	}

	@Override
	public int deleteUserInfo(UserInfoVO ui) {
		return udao.deleteUserInfo(ui);
	}


	private boolean isDuplUserInfo(UserInfoVO ui) {
		if(udao.checkUser(ui)==1) {
			return true;
		}
		return false;
	}
	@Override
	public void insertUserInfo(Map<String, Object> rMap, UserInfoVO ui) {
		rMap.put("msg", "회원가입 실패");
		rMap.put("singupOk", false);
		if(isDuplUserInfo(ui)) {
			rMap.put("msg", ui.getuID() + "는 이미 존재 하는 아디이 입니다.");
			return;
		}
		int result = udao.insertUserInfo(ui);
	
		if (result == 1) {
			rMap.put("msg", "회원가입 성공");
			rMap.put("singupOk", true);
		}

	}

	



}
