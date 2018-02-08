package com.iot.spring.service;

import java.util.List;

import com.iot.spring.vo.UserInfo;
import com.iot.spring.vo.UserInfoVO;

public interface UserInfoService {
	public List<UserInfoVO> getUserInfoList();
	public UserInfoVO getUserInfo();
	public int insertUserInfo(UserInfoVO ci);
	public int updateUserInfo(UserInfoVO ci);
	public int deleteUserInfo(UserInfoVO ci);
}
