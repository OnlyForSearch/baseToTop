package cn.feng.utils.sms;/*
package cn.feng.utils.sms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

public class SmsUtil {

	static Logger logger = Logger.getLogger(SmsUtil.class.getName());

	*/
/**
	 * 第三方PHP调用方式
	 * 
	 * @param httpUrl
	 * @param sendParam
	 *//*

	public static void getSms(String httpUrl, String sendParam) {
		try {
			URL url = new URL(httpUrl);
			HttpURLConnection httpUrlCon = (HttpURLConnection) url.openConnection();
			httpUrlCon.setDoOutput(true);
			httpUrlCon.setRequestMethod("POST");
			httpUrlCon.getOutputStream().write(sendParam.toString().getBytes());
			httpUrlCon.getOutputStream().flush();
			httpUrlCon.getOutputStream().close();

			BufferedReader xinnetIn = new BufferedReader(new InputStreamReader(
					httpUrlCon.getInputStream()));
			String result = null;
			String line = null;
			while ((line = xinnetIn.readLine()) != null) {
				result += "/n" + line;
			}
			System.out.println(result);

			xinnetIn.close();
			httpUrlCon.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	*/
/**
	 * 使用post的方式访问URL
	 * 
	 * @param url 访问地址
	 * @param jsonParam 提交json格式数据
	 * @return 请求结果
	 * @throws HttpException
	 * @throws IOException
	 *//*

	@SuppressWarnings("deprecation")
	public static String doPost(String url, String xmlParam) {
		if (url == null || xmlParam == null) {
			return null;
		}
		
		String strRequest = null;
		HttpClient httpClient = new HttpClient();
		PostMethod post = new PostMethod(url);
		try {
			post.setRequestHeader("Content-Type", "application/xml;charset=gbk");
			post.setRequestBody(xmlParam);
			int result = httpClient.executeMethod(post);
			strRequest = post.getResponseBodyAsString();
			logger.info("sms---result:" + String.valueOf(result) + ":"
					+ post.getResponseBodyAsString());

		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.debug(e.getMessage());
			e.printStackTrace();
		} finally {
			post.releaseConnection();
			httpClient.getHttpConnectionManager().closeIdleConnections(0);
		}
		return strRequest;
	}

	*/
/**
	 * 短信发送xml参数
	 * 
	 * @param loginName
	 * @param loginPwd
	 * @param phone
	 * @param content
	 * @return xml格式参数
	 *//*

	public static String getXmlInfo(String loginName, String loginPwd, String phone, String content) {
		StringBuilder sb = new StringBuilder();
		sb.append("<Group Login_Name='" + loginName + "' Login_Pwd='"
				+ MD5Util.MD5Encoder(loginPwd, "utf-8").toUpperCase() + "' InterFaceID='' OpKind='0'>");
		sb.append("<E_Time></E_Time>");
		sb.append("  <Item>");
		sb.append("    <Task>");
		sb.append("       <Recive_Phone_Number>" + phone + "</Recive_Phone_Number>");
		sb.append("       <Content><![CDATA[" + content + "]]></Content>");
		sb.append("       <Search_ID></Search_ID>");
		sb.append("    </Task>");
		sb.append("  </Item>");
		sb.append("</Group>");
		return sb.toString();
	}

}
*/
