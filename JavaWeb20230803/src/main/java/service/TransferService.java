package service;

import repository.TransferDao;

// 翻譯服務
public class TransferService {
	
	private TransferDao transferDao = new TransferDao();
	
	public String transfer(String word) {
		
		String result = transferDao.getByWord(word);
		if(result == null) {
			result = "我不知道";
		}
		
		return result;
	}
	
}
