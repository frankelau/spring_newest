package cn.com.liu.spring01.helloworld;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
//		HelloWorld helloWorld = new HelloWorld();
//		helloWorld.setUser("Tom");
//		helloWorld.hello(); 
		
		//1. ���� Spring �� IOC ����
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		//2. �� IOC �����л�ȡ bean ��ʵ��
		HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld3");
		
		//������������ȡ bean ��ʵ��: Ҫ����  IOC ������ֻ��һ����֮����ƥ��� bean, ���ж������׳��쳣. 
		//һ�������, �÷�������, ��Ϊһ�������, ��һ�� IOC ������һ�����Ͷ�Ӧ�� bean Ҳֻ��һ��. 
//		HelloWorld helloWorld1 = ctx.getBean(HelloWorld.class);
		
		//3. ʹ�� bean
		helloWorld.hello();
		
		Car car = (Car) ctx.getBean("car");
		System.out.println(car);
		
		Car car2 = (Car) ctx.getBean("car2");
		System.out.println(car2);
		
		//4. ����ʹ�ü�������
		User user = (User) ctx.getBean("user5");
		System.out.println(user);
	}
	
}
