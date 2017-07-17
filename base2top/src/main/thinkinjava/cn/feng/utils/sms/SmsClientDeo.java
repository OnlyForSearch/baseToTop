package cn.feng.utils.sms;/*
package cn.feng.utils.sms;

import cn.feng.utils.sms.entity.SendSms;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;



*/
/**
 * @author Administrator
 *
 *//*

public class SmsClientDeo {

	static Logger logger = Logger.getLogger(SmsUtil.class.getName());

	public static void main(String args[]) {
		SendSms sendSms = new SendSms();
		sendSms.setAccount("account");
		sendSms.setMobile(Arrays.asList("1", "2", "3"));
		String[] demo = new String[] { };
		sendSms.setDemo(demo);
		try {
			String result = getURLparameter(sendSms);
			System.out.println(result);

		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException e) {
			e.printStackTrace();
		}
		List list;

	}

	public static String sendMsm(String httpURL, SendSms sendSms) throws Exception {
		if (httpURL == null) {
			return null;
		}
		
		StringBuilder sb=new StringBuilder("http://sms.chanzor.com:8001/sms.aspx?action=send");
		//&account=账号&password=密码&mobile=手机号&content=内容&sendTime=
		sb.append("&account=账号").append("lcs9501");
		sb.append("&password=密码").append("153373");
		sb.append("&mobile=手机号").append("18059041344");
		sb.append("&content=").append(URLEncoder.encode("内容", "UTF-8"));
		sb.append("&sendTime=").append("");
	
		
		String url = httpURL + getURLparameter(sendSms);
		
		
		String doGet = HttpRequestProxyUtil.doGet("");
		return doGet;
	}
	
	@Test
	public void testSendMsm() throws Exception{
		StringBuilder sb=new StringBuilder("http://sms.chanzor.com:8001/sms.aspx?action=send");
		//&account=账号&password=密码&mobile=手机号&content=内容&sendTime=
		sb.append("&account=").append("lcs9501");
		sb.append("&password=").append("153373");
		sb.append("&mobile=").append("18059041344");
		sb.append("&content=").append(URLEncoder.encode("您的验证码是111111【橙子生活】", "UTF-8"));
		sb.append("&sendTime=").append("");
		
	
		String doGet = HttpRequestProxyUtil.doGet(sb.toString());
		System.out.println(doGet);
	//	Map<String, Object> mapFromXML = XMLParser.getMapFromXML(doGet);
	//	System.out.println(mapFromXML);
	
	}
	
	

	*/
/**
	 * 将对象中的变量合成为请求参数,如果变量为空值则不设置 ,并且去掉中括号
	 * 
	 * @param obj
	 * @return
	 * @throws IntrospectionException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 *//*

	private static String getURLparameter(Object obj) throws IntrospectionException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		if (obj == null) {
			return "";
		}
		BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

		StringBuilder sb = new StringBuilder();
		Object retVal = null;
		for (PropertyDescriptor pd : propertyDescriptors) {
			Method readMethod = pd.getReadMethod();
			Class<?> returnType = readMethod.getReturnType();
			// System.out.println(returnType);
			retVal = readMethod.invoke(obj);
			if (retVal == null || pd.getName().equals("class")) {
				continue;
			}
			if(pd.getName().equals("mobile")){
				
				System.out.println(pd.getPropertyType());
			}
			
			// 数组去掉中括号,
			if (isArray(retVal)) {	
				StringBuilder sb2 = new StringBuilder();
				sb2.append("&").append(pd.getName()).append("=");//
				String string = Arrays.toString((Object[]) retVal);
				sb2.append(string.substring(1,string.length()-1));
	        	sb.append(sb2);
			}else if(pd.getPropertyType().equals("interface java.util.List")){
				sb.append("&").append(pd.getName()).append("=");//
				sb.append(((String)retVal).substring(1,((String)retVal).length()-1));
				
			} else {

				sb.append("&").append(pd.getName()).append("=")//
						.append(retVal == null ? "" : retVal);
			}
			

		}
		sb.deleteCharAt(sb.indexOf("&"));
		return sb.toString();
	}

	private static boolean isArray(Object retVal) {
		return retVal.getClass().isArray();
	}
}
*/
