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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertUserInfo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUserInfo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUserInfo() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
