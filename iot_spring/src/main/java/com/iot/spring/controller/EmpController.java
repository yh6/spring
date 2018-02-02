package com.iot.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iot.spring.service.EmpService;
import com.iot.spring.vo.Emp;

@Controller
@RequestMapping("/emp")
public class EmpController {
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	private EmpService es;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getEmpList(Model m) {
		List<Emp> empList = es.getEmpList();
		m.addAttribute("empList",empList);	
		return "emp/jstl_list";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insertEmp(
			@Valid Emp empDTO,Errors e,
		//	@RequestParam("empName") String empName,
		//	@RequestParam("empSal") int empSal,
		//	@RequestParam Map<String, String>map,			
			Model m) {
		if(e.hasErrors()) {
			logger.info("error =>{}",e);
			m.addAttribute("errorMsg",e.getAllErrors());
			return "error/error";
		}
		es.insertEmp(empDTO);
	 //  logger.info("empName=>{}", empName);
		//logger.info("empSal=>{}", empSal);
	 logger.info("insert result => {}", empDTO);
		return "emp/write";
	}
}
