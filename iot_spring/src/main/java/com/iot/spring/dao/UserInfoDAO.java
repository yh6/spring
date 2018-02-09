package com.iot.spring.dao;

import java.util.List;

import com.iot.spring.vo.Emp;
import com.iot.spring.vo.UserInfoVO;

public interface UserInfoDAO {

	public List<UserInfoVO> selectUserInfoList();		
	public int insertUserInfo(UserInfoVO ui);
	public int updateUserInfo(UserInfoVO ui);
	public int deleteUserInfo(UserInfoVO ui);	
	public int checkUser(UserInfoVO ui);
	public UserInfoVO selectUserInfo(UserInfoVO ui);


}
