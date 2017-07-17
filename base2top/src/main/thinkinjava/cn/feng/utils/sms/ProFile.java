package cn.feng.utils.sms;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProFile {

	
	public String getProValues(String importValue) {
		String url = "";
	
		//String filePath = getClass().getResource("/").getPath()
		//		+ "system.properties";
	//	System.out.println(filePath);
		Properties prop = new Properties();
		// HttpServletRequest servletRequest =
		InputStream in;
		try {
			in = getClass().getResourceAsStream("/system.properties");   //new BufferedInputStream(new FileInputStream(filePath));
			// servletRequest.getRealPath("/")
			// + "WEB-INF/classes/system.properties"));
			prop.load(in); // /加载属性列表
			url = prop.getProperty(importValue);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return url;
	}
	
	public String getConfig(String importValue) {
		String url = "";
		Properties prop = new Properties();
		InputStream in;
		try {
			in = getClass().getResourceAsStream("/config.properties");   //new BufferedInputStream(new FileInputStream(filePath));
			prop.load(in); // /加载属性列表
			url = prop.getProperty(importValue);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	public String getCode(String importValue) {
		String url = "";
	
		//String filePath = getClass().getResource("/").getPath()
		//		+ "system.properties";
	//	System.out.println(filePath);
		Properties prop = new Properties();
		// HttpServletRequest servletRequest =
		InputStream in;
		try {
			in = getClass().getResourceAsStream("/code.properties");   //new BufferedInputStream(new FileInputStream(filePath));
			// servletRequest.getRealPath("/")
			// + "WEB-INF/classes/system.properties"));
			prop.load(in); // /加载属性列表
			url = prop.getProperty(importValue);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return url;
	}
	public String getBasePro(String importValue) {
		String url = "";
	
		//String filePath = getClass().getResource("/").getPath()
		//		+ "system.properties";
	//	System.out.println(filePath);
		Properties prop = new Properties();
		// HttpServletRequest servletRequest =
		InputStream in;
		try {
			
			System.out.println("**********************加载");
			in = getClass().getResourceAsStream("/base.properties");   //new BufferedInputStream(new FileInputStream(filePath));
			// servletRequest.getRealPath("/")
			// + "WEB-INF/classes/system.properties"));
			prop.load(in); // /加载属性列表
			url = prop.getProperty(importValue);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return url;
	}
}
