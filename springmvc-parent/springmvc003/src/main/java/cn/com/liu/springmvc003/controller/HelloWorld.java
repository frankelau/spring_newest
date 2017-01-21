package cn.com.liu.springmvc003.controller;

import cn.com.liu.springmvc003.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {
	Logger logger = LoggerFactory.getLogger("HelloWorld");
	@Autowired
	private UserService userService;
	
	public HelloWorld() {
		logger.info("HelloWorld Constructor...");
	}
	
	@RequestMapping("/helloworld")
	public String hello(){
		logger.info("success");
		logger.info(userService.toString());
		return "success";
	}
	
}
