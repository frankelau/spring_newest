package cn.com.liu.spring05.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.liu.spring05.hibernate.service.BookShopService;
import cn.com.liu.spring05.hibernate.service.Cashier;

@Service
public class CashierImpl implements Cashier{
	
	@Autowired
	private BookShopService bookShopService;
	
	@Override
	public void checkout(String username, List<String> isbns) {
		for(String isbn:isbns){
			bookShopService.purchase(username, isbn);
		}
	}

}
