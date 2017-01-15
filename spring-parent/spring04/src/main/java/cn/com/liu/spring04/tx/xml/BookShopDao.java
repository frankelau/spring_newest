package cn.com.liu.spring04.tx.xml;

public interface BookShopDao {

	//������Ż�ȡ��ĵ���
	public int findBookPriceByIsbn(String isbn);
	
	//�������Ŀ��. ʹ��Ŷ�Ӧ�Ŀ�� - 1
	public void updateBookStock(String isbn);
	
	//�����û����˻����: ʹ username �� balance - price
	public void updateUserAccount(String username, int price);
}
