package cy.its.service.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



/**
* @Title: ServiceFileResource.java 
* @Package cy.its.service.surveillance.util 
* @Description: ϵͳ�����ļ�������ڣ���ʼ�����е���Դ
* @author lil@cychina.cn
* @date 2015��10��20�� ����2:56:00 
* @version V1.0   
 */
public class ServiceFileResource {
	
	public static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator");  
	//�����ļ�·��
    private String  fileName;
    
    //ϵͳĿ¼
    public String   globalPath;
    
    //��־����
    public String   logName;
    /**
     * ������������Դ
     * @param path
     */
    public ServiceFileResource(String fileName,String logName){
    	this.fileName = fileName;
    	this.logName = logName;
    	//��ʼ��ϵͳ��Դ
    	try {
			intiAllProperties();
		} catch (DocumentException | FileNotFoundException e) {
			System.out.println("�����ļ��������⣬�����޷�����������");
			e.printStackTrace();
		}
    }
    
	/**
	 * @throws FileNotFoundException 
	 * @throws DocumentException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException  
	* @Title: intiAllProperties 
	* @Description: ����XML�ļ�����ʼ����Ϣ 
	* @param     �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	private void intiAllProperties() throws DocumentException, FileNotFoundException {
		 	SAXReader saxReader = new SAXReader();
		 	String  path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
		 	File temp =  new File(path);
		 	String  jarPath  = temp.getParent()+FILE_SEPARATOR;
		 	File  file = new File(jarPath);
		 	globalPath =  file.getParent()+FILE_SEPARATOR;
		 	FileInputStream is=new FileInputStream(globalPath + fileName);
	        Document document = saxReader.read(is);
	        Element root = document.getRootElement();
	        // ��ȡ������Ԫ��
	        List<Element> childList = root.elements();
	        // ��ȡ�ض����Ƶ���Ԫ��
	        childList.stream().forEach(el->{
	        	String  className = el.attributeValue("class");
	        	String  id = el.attributeValue("id");
	        	if(!"".equals(className)){
	        		List<Element> list = el.elements();
	        		String  text1 = list.get(0).getStringValue()==null?"":list.get(0).getStringValue();
	        		String  text2 = list.get(1).getStringValue()==null?"":list.get(1).getStringValue();
	        		try {
						Class<?> c = Class.forName(className);
						Constructor c0= null;
						if(className.equals("cy.its.service.util.Log4jConfig")){
							c0=c.getDeclaredConstructor(new Class[]{String.class,String.class,String.class});
							c0.setAccessible(true);
							c0.newInstance(new Object[]{text1,globalPath+text2,logName}); 
						}else{
							c0=c.getDeclaredConstructor(new Class[]{String.class,String.class});   
							c0.setAccessible(true);
							c0.newInstance(new Object[]{text1,globalPath+text2}); 
						}
						
					} catch (Exception e) {
						System.out.println(id+"��ʼ��ʧ��,û�ҵ�"+id+"��ʼ���࣡");
						e.printStackTrace();
					} 
	        	}else{
	        		System.out.println(id+"��ʼ��ʧ�ܣ�");
	        	}
	        });
	}
}
