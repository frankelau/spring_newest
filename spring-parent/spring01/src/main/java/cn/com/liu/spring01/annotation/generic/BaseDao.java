package cn.com.liu.spring01.annotation.generic;

public class BaseDao<T> {

	public void save(T entity){
		System.out.println("Save:" + entity);
	}
	
}
