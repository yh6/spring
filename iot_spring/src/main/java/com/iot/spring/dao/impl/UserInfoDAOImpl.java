package com.iot.spring.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.UserInfoDAO;
import com.iot.spring.vo.Emp;
import com.iot.spring.vo.UserInfoVO;

@Repository
public class UserInfoDAOImpl implements UserInfoDAO {
	@Autowired
	private SqlSessionFactory ssf;

	@Override
	public List<UserInfoVO> selectUserInfoList() {
		SqlSession ss = ssf.openSession();
		List<UserInfoVO> userInfoList = ss.selectList("userInfo.selectUserInfo");	
		ss.close();
		return userInfoList;
	}

	@Override
	public UserInfoVO selectUserInfo() {
		return null;
	}

	@Override
	public int insertUserInfo(UserInfoVO ci) {		
		SqlSession ss = ssf.openSession();
		int result = ss.insert("userInfo.insertUserInfo",ci); 
		return result;
	}
	
	@Override
	public int updateUserInfo(UserInfoVO ci) {
		SqlSession ss = ssf.openSession();
		int result = ss.insert("userInfo.updateUserInfo",ci); 
		return result;
	}

	@Override
	public int deleteUserInfo(UserInfoVO ci) {
		SqlSession ss = ssf.openSession();
		int result = ss.insert("userInfo.deleteUserInfo",ci); 
		return result;
	}
	
}
