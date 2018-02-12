package com.iot.spring.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.common.dbcon.DBConnector;
import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ColumnVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

@Service
public class ConnectionServiceImpl implements ConnectionService {
 
	@Autowired
	private ConnectionDAO cdao;

	@Override
	public ConnectionInfoVO getConnectionInfo(ConnectionInfoVO ci) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConnectionInfoVO> getConnectionInfoList(ConnectionInfoVO ci) {
		List<ConnectionInfoVO> List = cdao.selectConnectionInfoList(ci);
		return List;
	}

	@Override
	public void insertConnectionInfo(Map<String, Object> rMap, ConnectionInfoVO ci) {
		int result = 0;
		result = cdao.insertConnectionInfo(rMap, ci);
		rMap.put("msg", "실패");
		if (result != 0) {
			rMap.put("msg", "성공");
		}

	}

	  public List<Map<String,Object>> getDatabaseList(HttpSession hs,int ciNo)throws Exception {
	      ConnectionInfoVO ci = cdao.selectConnectionInfo(ciNo);
	      DBConnector dbc = new DBConnector(ci);
	      SqlSession ss = dbc.getSqlSession();
	      hs.setAttribute("sqlSession", ss);
	      List<Map<String,Object>> dbList = cdao.selectDatabaseList(ss);
	      int idx = 0;
	      for(Map<String,Object> mDb : dbList) {
	         mDb.put("id", ciNo + "_" + (++idx));
	         mDb.put("text", mDb.get("Database"));
	         mDb.put("items", new Object[] {});
	      }
	      return dbList;
	   }

	   @Override
	   public List<TableVO> getTableList(HttpSession hs, String dbName) {
	      SqlSession ss = (SqlSession)hs.getAttribute("sqlSession");
	      return cdao.selectTableList(ss, dbName);
	   }

	@Override
	public List<ColumnVO> getColumnList(Map tbName) {
		List<ColumnVO> columnList = cdao.selectColumnList(tbName);
		return columnList;
	}

	@Override
	public List<ColumnVO> getColumnList() {
		// TODO Auto-generated method stub
		return null;
	}


}
