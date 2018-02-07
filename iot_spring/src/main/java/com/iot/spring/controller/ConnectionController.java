package com.iot.spring.controller;

import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ConnectionInfoVO;

@Controller
@RequestMapping("/connection")
public class ConnectionController {
	private static final Logger logger = LoggerFactory.getLogger(ConnectionController.class);
	
	@Autowired
	private ConnectionService cs;
	
    ObjectMapper om = new ObjectMapper();  //json꺼
    
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> insertConnectionInfo(@RequestParam Map<String, Object> map) {
		ConnectionInfoVO ci = om.convertValue(map, ConnectionInfoVO.class);
		cs.insertConnectionInfo(map, ci);
		return map;
	}
	

}
