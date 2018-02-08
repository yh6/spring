package com.iot.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.vo.ColumnVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

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

	@Override
	public List<Map<String, Object>> selectDatabaseList() {
		SqlSession ss = ssf.openSession();
		List<Map<String,Object>> dbList = ss.selectList("connection.selectDatabase");
		return dbList;
	}

	@Override
	public List<TableVO> selectTableList(String dbName) {
		SqlSession ss = ssf.openSession();
		List<TableVO> tableList  = ss.selectList("connection.selectTable",dbName);
		return tableList;
		
	}

	@Override
	public List<ColumnVO> selectColumnList(Map tbName) {
		SqlSession ss = ssf.openSession();
		List<ColumnVO> columnList  = ss.selectList("connection.selectColumn",tbName);
		return columnList;
	}
	
	


}
