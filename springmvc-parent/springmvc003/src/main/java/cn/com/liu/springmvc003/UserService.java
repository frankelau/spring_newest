package cn.com.liu.springmvc003;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private HelloWorld helloWorld;
	
	public UserService() {
		System.out.println("UserService Constructor...");
	}
	
}
