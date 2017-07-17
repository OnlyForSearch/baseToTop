package cn.feng.utils.sms;/*
package cn.feng.utils.sms;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.orange.PropInfo.webservice.base.util.BeanUtil;

public class XmlUtils {
	@SuppressWarnings("unchecked")
	public static Map<String, Object> Dom2Map(Document doc) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (doc == null)
			return map;
		Element root = doc.getRootElement();
		for (Iterator iterator = root.elementIterator(); iterator.hasNext();) {
			Element e = (Element) iterator.next();
			List list = e.elements();
			if (list.size() > 0) {
				map.put(e.getName(), Dom2Map(e));
			} else
				map.put(e.getName(), e.getText());
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public static Map Dom2Map(Element e) {
		Map map = new HashMap();
		List list = e.elements();
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Element iter = (Element) list.get(i);
				List mapList = new ArrayList();

				if (iter.elements().size() > 0) {
					Map m = Dom2Map(iter);
					if (map.get(iter.getName()) != null) {
						Object obj = map.get(iter.getName());
						if (!obj.getClass().getName()
								.equals("java.util.ArrayList")) {
							mapList = new ArrayList();
							mapList.add(obj);
							mapList.add(m);
						}
						if (obj.getClass().getName()
								.equals("java.util.ArrayList")) {
							mapList = (List) obj;
							mapList.add(m);
						}
						map.put(iter.getName(), mapList);
					} else
						map.put(iter.getName(), m);
				} else {
					if (map.get(iter.getName()) != null) {
						Object obj = map.get(iter.getName());
						if (!obj.getClass().getName()
								.equals("java.util.ArrayList")) {
							mapList = new ArrayList();
							mapList.add(obj);
							mapList.add(iter.getText());
						}
						if (obj.getClass().getName()
								.equals("java.util.ArrayList")) {
							mapList = (List) obj;
							mapList.add(iter.getText());
						}
						map.put(iter.getName(), mapList);
					} else
						map.put(iter.getName(), iter.getText());
				}
			}
		} else
			map.put(e.getName(), e.getText());
		return map;
	}


	//将xml装换成相应的bean对象
	   public static <T> T xmlToBean(Class clazz,String xmls) throws DocumentException, InvocationTargetException, Exception {
	     	        Document doc = DocumentHelper.parseText(xmls);
	        System.out.println(doc.asXML());
	        long beginTime = System.currentTimeMillis();

	        Map<String, Object> map = XmlUtils.Dom2Map(doc);
	     	   T t1 = (T) BeanUtil.copyProperties(clazz, map);
	      //  System.out.println(t1);
	        System.out.println("Use time:" + (System.currentTimeMillis() - beginTime));
	        return t1;

	    }
	   
		public static void main(String[] args) throws IOException,
		DocumentException {

	// FileInputStream fis = new FileInputStream("d://a.xml");
	// byte[] b = new byte[fis.available()];
	// fis.read(b);
	// String str = new String(b);
	String xmls = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>"
			+ "<returnsms>" + "<returnstatus>Success</returnstatus>"
			+ "<message>操作成功</message>" + "<remainpoint>6</remainpoint>"
			+ "<taskID>1510302125010961</taskID>"
			+ "<successCounts>1</successCounts>" + "</returnsms>";

	Document doc = DocumentHelper.parseText(xmls);

	
	System.out.println(doc.asXML());
	long beginTime = System.currentTimeMillis();

	Map<String, Object> map = XmlUtils.Dom2Map(doc);
	System.out.println(map.toString());

	System.out.println("Use time:"
			+ (System.currentTimeMillis() - beginTime));
}
}
*/
