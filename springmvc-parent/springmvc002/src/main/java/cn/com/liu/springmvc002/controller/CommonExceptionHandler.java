package cn.com.liu.springmvc002.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionHandler {
	Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);
	@ExceptionHandler({Exception.class})
	public ModelAndView handleExceptionMethod(Exception ex){
		logger.error("----> 出异常了: " ,ex);
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("exception", ex);
		return mv;
	}
	
}
