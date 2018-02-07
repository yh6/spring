package com.iot.spring.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ConnectionInfoVO;

@Service
public class ConnectionServiceImpl implements ConnectionService {

	@Autowired
	private ConnectionDAO cado;

	@Override
	public ConnectionInfoVO getConnectionInfo(ConnectionInfoVO ci) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConnectionInfoVO> getConnectionInfoList(ConnectionInfoVO ci) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertConnectionInfo(Map<String, Object> rMap, ConnectionInfoVO ci) {
		int result = 0;
		result = cado.insertConnectionInfo(rMap, ci);
		rMap.put("msg", "실패");
		if (result != 0) {
			rMap.put("msg", "성공");
		}

	}

}
