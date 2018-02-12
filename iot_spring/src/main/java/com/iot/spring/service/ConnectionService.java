package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.iot.spring.vo.ColumnVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

public interface ConnectionService {
	
	ConnectionInfoVO getConnectionInfo(ConnectionInfoVO ci);
	List<ConnectionInfoVO> getConnectionInfoList(ConnectionInfoVO ci);
	void insertConnectionInfo(Map<String,Object> rMap,ConnectionInfoVO ci);
	List<TableVO> getTableList(HttpSession hs, String dbName);
	List<ColumnVO> getColumnList();
	List<ColumnVO> getColumnList(Map tbName);
	List<Map<String, Object>> getDatabaseList(HttpSession hs, int ciNo) throws Exception;

	
}
