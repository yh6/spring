package com.iot.spring.dao;

import java.util.List;

import com.iot.spring.vo.Emp;
import com.iot.spring.vo.UserInfoVO;

public interface UserInfoDAO {

	public List<UserInfoVO> selectUserInfoList(UserInfoVO ui);		
	public int insertUserInfo(UserInfoVO ui);
	public int updateUserInfo(UserInfoVO ui);
	public int deleteUserInfo(UserInfoVO ui);	
	public int checkUserInfo(UserInfoVO ui);
	UserInfoVO selectUserInfo(UserInfoVO ui);


}
