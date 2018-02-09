package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.UserInfo;
import com.iot.spring.vo.UserInfoVO;

public interface UserInfoService {
	public void insertUserInfo(Map<String,Object> rMap,UserInfoVO ui);
	public int updateUserInfo(UserInfoVO ui);
	public int deleteUserInfo(UserInfoVO ui);	
	public List<UserInfoVO> getUserInfoList(UserInfoVO ui);
	public UserInfoVO getUserInfo(UserInfoVO ui);
	
	
	
	
	

}
