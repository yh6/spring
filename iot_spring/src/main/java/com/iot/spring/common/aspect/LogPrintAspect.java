package com.iot.spring.common.aspect;

import java.io.IOException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.iot.spring.dao.NaverTransDAO;
import com.iot.spring.vo.NaverMsg;

@Service
@Aspect
public class LogPrintAspect {
	@Autowired
	private NaverTransDAO ntd;
	
	@Autowired
	private ObjectMapper om;

	private static final Logger log = LoggerFactory.getLogger(LogPrintAspect.class);

	@Before("execution(* com.iot.spring.controller.*Controller.*(..))")
	public void beforeLog(JoinPoint jp) {
		log.info("@Before =>{}", jp);
	}

	@Around("execution(* com.iot.spring.controller.*Controller.*(..))")
	public Object aroundLog(ProceedingJoinPoint pjp) throws JsonParseException, JsonMappingException, IOException {
		log.info("@Around begin");
		Object obj = null;
		long startTime = System.currentTimeMillis();
		try {
			obj = pjp.proceed();
		} catch (Throwable e) {
			log.error("@Around error=>{}", e);
			ModelAndView mav = new ModelAndView("error/error");
			String eMsg = ntd.getText(e.getMessage());
			NaverMsg nm = om.readValue(eMsg, NaverMsg.class);
			String msg = nm.getMessage().getResult().getTranslatedText();
			mav.addObject("errorMsg", msg);			
			return mav;
		}
		log.info("@Around end, RunTime : {} ms", (System.currentTimeMillis() - startTime));
		return obj;
	}

	@After("execution(* com.iot.spring.controller.*Controller.*(..))")
	public void afterLog(JoinPoint jp) {
		log.info("@After =>{}", jp);
	}
}
