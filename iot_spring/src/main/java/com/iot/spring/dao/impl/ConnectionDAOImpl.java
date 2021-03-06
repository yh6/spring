package com.iot.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.common.dbcon.DBConnector;
import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.vo.ColumnVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

@Repository
public class ConnectionDAOImpl implements ConnectionDAO{
	@Autowired
	private SqlSessionFactory ssf;
	
	@Override
	public ConnectionInfoVO selectConnectionInfo(int ciNo) {
		SqlSession ss = ssf.openSession();
		ConnectionInfoVO ci = ss.selectOne("connection.selectConnectionInfoWithCiNo", ciNo);		
		ss.close();
		return ci;
	}

	@Override
	public List<ConnectionInfoVO> selectConnectionInfoList(ConnectionInfoVO ci) {
		List<ConnectionInfoVO> result = null;
		SqlSession ss = ssf.openSession();
		result = ss.selectList("connection.selectConnectionInfo", ci);			
		return result;
	}



	@Override
	public int insertConnectionInfo(ConnectionInfoVO ci) {
		int result = 0;
		final SqlSession ss = ssf.openSession();
		result = ss.insert("connection.insertConnectionInfo",ci);
		ss.close();
		return result;
				
	}

	@Override
	public List<Map<String, Object>> selectDatabaseList(SqlSession ss) throws Exception {	
		return ss.selectList("connection.selectDatabase");
		
	}

	   @Override
	   public List<TableVO> selectTableList(SqlSession ss,String dbName) {
	      List<TableVO> result = null;
	      result = ss.selectList("connection.selectTable",dbName);
	      return result;
	   }

}
