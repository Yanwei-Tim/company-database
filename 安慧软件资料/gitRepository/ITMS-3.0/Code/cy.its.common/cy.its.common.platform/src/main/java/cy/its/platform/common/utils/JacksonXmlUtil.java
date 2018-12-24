package cy.its.platform.common.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
* @Title: JacksonXmlUtil.java 
* @Package com.cy.utils 
* @Description: ������ XML��JSON���� 
* @author lil@cychina.cn
* @date 2015��8��19�� ����3:29:41 
* @version V1.0   
 */
public class JacksonXmlUtil {
	
	/** 
	* @Title: convertXMLtoMap 
	* @Description: ��XML�ļ�ת��ΪMAP 
	* @param @param path
	* @param @return    �趨�ļ� 
	* @return Map    �������� 
	* @throws 
	*/
	public static Map convertXMLtoMap(String path){
		SAXReader reader = new SAXReader();               
	    Document document=null;
		try {
			document = reader.read(new File(path));
		} catch (DocumentException e1) {
			e1.printStackTrace();
		} 
		Map map  = new HashMap();
		File  file  = new File(path);
		Element   el  = document.getRootElement();
		Iterator<Element> it = el.elementIterator();
        while (it.hasNext()) {  
            // ��ȡĳ���ӽڵ����  
            Element e = it.next();  
            // ���ӽڵ���б���  
            map.put(e.attributeValue("id"), e.attributeValue("sql"));
        }  
		return map;
	}
}
