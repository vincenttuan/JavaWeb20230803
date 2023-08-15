package service;

import repository.TransferDao;

// 翻譯服務
public class TransferService {
	
	private TransferDao transferDao = new TransferDao();
	
	public String transfer(String word) {
		
		String result = transferDao.getByWord(word);
		if(result == null) {
			result = "字典資料庫無此紀錄";
		}
		
		return result;
	}
	
}
