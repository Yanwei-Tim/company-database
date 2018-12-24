package ah.its.workFlow.web.servlet;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import ah.its.workFlow.util.DictionaryUtil;
import ah.its.workFlow.util.RedisPoolUtil;

/**
 * @author lilei ����������ʼ�����в��� Ŀǰ֮��̬�޸Ļ���Ĵ��·��
 */
public class InitServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7494197526457091687L;

	public static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator");

	/**
	 * ��Ŀ�����ļ�
	 */
	private String globalPath = "";
	
	/**
	 * �����ֵ������ļ���Ϣ
	 */
	private static String dictionaryPath;
	
	/**
	 * redis�����ļ���Ϣ
	 */
	private static String redisPath;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String prefix = config.getServletContext().getRealPath("/");
		if (FILE_SEPARATOR.equals("\\")) {
			// ��ȡ���ݷ����������ļ���·��
			globalPath = prefix + "WEB-INF\\classes\\global.properties";
			dictionaryPath = prefix + "WEB-INF\\classes\\dataDictionary.xml";
			redisPath = prefix + "WEB-INF\\classes\\redis.properties";
		} else if (FILE_SEPARATOR.equals("/")) {
			globalPath = prefix + "WEB-INF/classes/global.properties";
			dictionaryPath = prefix + "WEB-INF/classes/dataDictionary.xml";
			redisPath = prefix + "WEB-INF/classes/redis.properties";
		}
		System.out.println("��Ŀ·��Ϊ��" + prefix);
        Properties prop = getProperties();
        prop.setProperty("prefix", prefix);
        GlobalProerty.setGlobalProerty(prop);
		//��ʼ��REDIS
		initRedis();
		
		//�����ֵ��ʼ������ʼ����REDIS����
		DictionaryUtil.initAll(config,dictionaryPath);
	}
	
	/** 
	* @Description: ��ȡ�����ļ���Ϣ 
	* @param @return    �趨�ļ� 
	* @return Properties    �������� 
	* @throws 
	*/
	private Properties getProperties(){
		Properties prop = new 	Properties();
		try {
			FileInputStream fis = new FileInputStream(globalPath);
			prop.load(fis);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}

	/**
	 * @Title: initRedis @Description: redis������ʼ�� @param �趨�ļ� @return void
	 * �������� @throws
	 */
	private void initRedis() {
		Constructor c0;
		try {
			c0 = RedisPoolUtil.class.getDeclaredConstructor(new Class[] { String.class, String.class });
			c0.setAccessible(true);
			c0.newInstance(new Object[] {"", redisPath });
		} catch (Exception e) {
			System.out.println("��ʼ��redis�����쳣");
			e.printStackTrace();
		}
		System.out.println("��ʼ��redis���");
	}

}
