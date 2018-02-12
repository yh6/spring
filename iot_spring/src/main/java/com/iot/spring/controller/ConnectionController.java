package com.iot.spring.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ColumnVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;
import com.iot.spring.vo.UserInfoVO;

@Controller
@RequestMapping("/connection")
public class ConnectionController {
	private static final Logger logger = LoggerFactory.getLogger(ConnectionController.class);

	@Autowired
	private ConnectionService cs;

	ObjectMapper om = new ObjectMapper(); // json꺼
	

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> insertConnectionInfo(@RequestParam Map<String, Object> map) {
		ConnectionInfoVO ci = om.convertValue(map, ConnectionInfoVO.class);
		cs.insertConnectionInfo(map, ci);
		return map;
	}

	@RequestMapping(value = "/db_list/{ciNo}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getDatabaseList(@PathVariable("ciNo") int ciNo,
			Map<String,Object> map,HttpSession hs){
		List<Map<String, Object>> dbList;
		try {
			dbList =  cs.getDatabaseList(hs, ciNo);
			map.put("List",dbList);
			map.put("parentId", ciNo);
		}catch (Exception e) {
			map.put("error", e.getMessage());
			logger.error("db connection error =>{}",e);
		}			
		return map;
	}
	
	  @RequestMapping(value="/tables/{dbName}/{parentId}", method=RequestMethod.GET)
	   public @ResponseBody Map<String,Object> getTabeList(
	         @PathVariable("dbName")String dbName, 
	         @PathVariable("parentId")String parentId,
	         HttpSession hs,
	         Map<String,Object> map) {
	      List<TableVO> tableList = cs.getTableList(hs, dbName);
	      map.put("list", tableList);
	      map.put("parentId", parentId);
	      return map;
	   }
	  
	@RequestMapping(value = "/column/{dbName}/{tbName}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getColumnList(@RequestParam Map<String, Object> map) {
		List<ColumnVO> columnList = cs.getColumnList();
		map.put("columnList", columnList);
		return map;
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getConnectInfoList(Map<String, Object> map, HttpSession hs) {
		UserInfoVO ui = new UserInfoVO();
		if(hs.getAttribute("userInfo")!=null){
			ui=(UserInfoVO)hs.getAttribute("userInfo");
		}else {
			ui.setuID("red");
		}
		ConnectionInfoVO ci = new ConnectionInfoVO();
		ci.setuID(ui.getuID());
		List<ConnectionInfoVO> ciList = cs.getConnectionInfoList(ci);
		map.put("List", ciList);
		return map;
	}
}
