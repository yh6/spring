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
		SqlSession ss = ssf.openSession();
		List<ConnectionInfoVO> List = ss.selectList("connection.selectConnectionInfo", ci);		
	
		return List;
	}



	@Override
	public int insertConnectionInfo(Map<String, Object> rMap, ConnectionInfoVO ci) {
		SqlSession ss = ssf.openSession();
		int result = ss.insert("connection.insertConnectionInfo",ci);
		return result;
				
	}

	@Override
	public List<Map<String, Object>> selectDatabaseList(SqlSession ss) throws Exception {
		List<Map<String,Object>> result = null;
		ConnectionInfoVO ci  = ss.selectOne("connection.selectConnectionInfoWithCiNo");
		ss.close();
		DBConnector dbc = new DBConnector(ci);
		ss = dbc.getSqlSession();
		result = ss.selectList("connection.selectDatabase");
		ss.close();
		return result;
	}

	   @Override
	   public List<TableVO> selectTableList(SqlSession ss,String dbName) {
	      List<TableVO> result = null;
	      result = ss.selectList("connection_info.selectTable",dbName);
	      return result;
	   }

	@Override
	public List<ColumnVO> selectColumnList(Map tbName) {
		SqlSession ss = ssf.openSession();
		List<ColumnVO> columnList  = ss.selectList("connection.selectColumn",tbName);
		return columnList;
	}

	
	


}
