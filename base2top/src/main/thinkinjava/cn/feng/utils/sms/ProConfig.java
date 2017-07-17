package cn.feng.utils.sms;




public class ProConfig {




	public static String getProValues(String importValue) {
		String url = "";

		ProFile proFile = new ProFile();
		url = proFile.getProValues(importValue);

		return url;
	}
	
	public static String getConfig(String importValue) {
		String url = "";

		ProFile proFile = new ProFile();
		url = proFile.getConfig(importValue);

		return url;
	}
	
	public static String getCode(String importValue) {
		String url = "";

		ProFile proFile = new ProFile();
		url = proFile.getCode(importValue);

		return url;
	}
	public static String getBasePro(String importValue) {
		String url = "";

		ProFile proFile = new ProFile();
		url = proFile.getBasePro(importValue);

		return url;
	}
	
}
