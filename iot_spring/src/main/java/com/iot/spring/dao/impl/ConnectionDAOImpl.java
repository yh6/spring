package com.iot.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.vo.ConnectionInfoVO;

@Repository
public class ConnectionDAOImpl implements ConnectionDAO{
	@Autowired
	private SqlSessionFactory ssf;
	
	@Override
	public ConnectionInfoVO selectConnectionInfo(ConnectionInfoVO ci) {
		return null;
	}

	@Override
	public List<ConnectionInfoVO> selectConnectionInfoList(ConnectionInfoVO ci) {
		return null;
	}

	@Override
	public int insertConnectionInfo(Map<String, Object> rMap, ConnectionInfoVO ci) {
		SqlSession ss = ssf.openSession();
		int result = ss.insert("connection.insertConnectionInfo",ci);
		return result;
		
		
	}

}
