package com.iot.spring.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.UserInfoDAO;
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
	public UserInfoVO selectUserInfo(UserInfoVO ui) {
		SqlSession ss = ssf.openSession();
		UserInfoVO user = ss.selectOne("userInfo.selectUserInfo", ui);	
		ss.close();
		return user;
	}

	@Override
	public int insertUserInfo(UserInfoVO ui) {		
		SqlSession ss = ssf.openSession();
		int result = ss.insert("userInfo.insertUserInfo",ui); 
		return result;
	}
	
	@Override
	public int updateUserInfo(UserInfoVO ui) {
		SqlSession ss = ssf.openSession();
		int result = ss.insert("userInfo.updateUserInfo",ui); 
		return result;
	}

	@Override
	public int deleteUserInfo(UserInfoVO ui) {
		SqlSession ss = ssf.openSession();
		int result = ss.insert("userInfo.deleteUserInfo",ui); 
		return result;
	}
	@Override
	public int checkUser(UserInfoVO ui) {
		int result = 0;
		SqlSession ss = ssf.openSession();
		 result = ss.selectOne("userInfo.checkUser",ui); 
		return result;
		
	}	
}
