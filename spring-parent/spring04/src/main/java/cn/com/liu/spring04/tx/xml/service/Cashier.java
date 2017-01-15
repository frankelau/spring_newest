package cn.com.liu.spring04.tx.xml.service;

import java.util.List;

public interface Cashier {

	public void checkout(String username, List<String> isbns);
	
}
