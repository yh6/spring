package com.iot.spring.dao;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.ConnectionInfoVO;



public interface ConnectionDAO {
	
	ConnectionInfoVO selectConnectionInfo(ConnectionInfoVO ci);
	List<ConnectionInfoVO> selectConnectionInfoList(ConnectionInfoVO ci);
	int insertConnectionInfo(Map<String,Object> rMap,ConnectionInfoVO ci);
	

}
