package com.iot.spring.dao;

import java.util.List;

import com.iot.spring.vo.Emp;
import com.iot.spring.vo.UserInfoVO;

public interface UserInfoDAO {

	public List<UserInfoVO> selectUserInfoList();
	public UserInfoVO selectUserInfo();
	public int insertUserInfo(UserInfoVO ci);
	public int updateUserInfo(UserInfoVO ci);
	public int deleteUserInfo(UserInfoVO ci);
	

}
