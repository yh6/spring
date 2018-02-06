package com.iot.spring.dao;

import java.util.List;


import com.iot.spring.vo.UserInfo;

public interface UserDAO {
	public List<UserInfo> selectUserList();
	public UserInfo selectUser();
	public int insertUser();
	public int updateUser();
	public int deleteUser();
	

}
