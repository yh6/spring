package com.iot.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.UserDAO;
import com.iot.spring.service.UserService;
import com.iot.spring.vo.UserInfo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO udao;
	
	@Override
	public List<UserInfo> getUserList() {		
		return udao.selectUserList();
	}
	@Override
	public UserInfo getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertUser() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
