package com.iot.spring.service;

import java.util.List;

import com.iot.spring.vo.UserInfo;



public interface UserService {
	public List<UserInfo> getUserList();
	public UserInfo getUser();
	public int insertUser();
	public int updateUser();
	public int deleteUser();
}
