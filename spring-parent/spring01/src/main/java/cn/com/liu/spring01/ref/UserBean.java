package cn.com.liu.spring01.ref;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.FactoryBean;

import cn.com.liu.spring01.helloworld.Car;
import cn.com.liu.spring01.helloworld.User;

public class UserBean implements FactoryBean<User>{

	/**
	 * ���ص� bean ��ʵ��
	 */
	@Override
	public User getObject() throws Exception {
		User user = new User();
		user.setUserName("abc");
		user.setWifeName("ABC");
		
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("ShangHai", "BuiKe", 180, 300000));
		cars.add(new Car("ShangHai", "CRUZE", 130, 150000));
		
		user.setCars(cars);
		return user;
	}

	/**
	 * ���ص� bean ������
	 */
	@Override
	public Class<?> getObjectType() {
		return User.class;
	}

	/**
	 * ���ص� bean �Ƿ�Ϊ������
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

}
