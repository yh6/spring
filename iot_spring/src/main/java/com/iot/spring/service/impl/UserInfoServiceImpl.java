package com.iot.spring.service.impl;

import java.util.List;

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
	public List<UserInfoVO> getUserInfoList() {
		return udao.selectUserInfoList();
	}

	@Override
	public UserInfoVO getUserInfo() {
		return null;
	}

	@Override
	public int insertUserInfo() {
		return udao.insertUserInfo();
	}

	@Override
	public int updateUserInfo() {
		return udao.updateUserInfo();
	}

	@Override
	public int deleteUserInfo() {
		return udao.deleteUserInfo();
	}
	
	

}
