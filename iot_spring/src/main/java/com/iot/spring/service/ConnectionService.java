package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.ConnectionInfoVO;

public interface ConnectionService {
	
	ConnectionInfoVO getConnectionInfo(ConnectionInfoVO ci);
	List<ConnectionInfoVO> getConnectionInfoList(ConnectionInfoVO ci);
	void insertConnectionInfo(Map<String,Object> rMap,ConnectionInfoVO ci);
	

}
