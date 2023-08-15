package service;

// 翻譯服務
public class TransferService {
	
	public String transfer(String word) {
		
		switch (word) {
			case "book":
				return "書";
			case "pen":
				return "筆";
			case "apple":
				return "蘋果";
			default:
				return "我不知道";
		}
		
	}
	
}
