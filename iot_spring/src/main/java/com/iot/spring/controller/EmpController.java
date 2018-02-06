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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value="/lista", method=RequestMethod.GET)
	public @ResponseBody List<Emp> getEmpListAjax(Model m) {
		List<Emp> empList = es.getEmpList();
		return empList;
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public ModelAndView insertEmp(
			@Valid Emp emp,Errors e,	
			ModelAndView m) throws Exception {
		logger.info("insert result =>{}",emp);
		if(e.hasErrors()) {
			logger.info("error =>{}",e);
			throw new Exception(e.getAllErrors().get(0).getDefaultMessage());
		}
			m.setViewName("emp/write");
			return m;
		}
		
	
	}

