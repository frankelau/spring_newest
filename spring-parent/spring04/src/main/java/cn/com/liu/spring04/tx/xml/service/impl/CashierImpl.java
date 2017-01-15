package cn.com.liu.spring04.tx.xml.service.impl;

import java.util.List;

import cn.com.liu.spring04.tx.xml.service.BookShopService;
import cn.com.liu.spring04.tx.xml.service.Cashier;

public class CashierImpl implements Cashier {

	private BookShopService bookShopService;
	
	public void setBookShopService(BookShopService bookShopService) {
		this.bookShopService = bookShopService;
	}
	
	@Override
	public void checkout(String username, List<String> isbns) {
		for(String isbn: isbns){
			bookShopService.purchase(username, isbn);
		}
	}

}
