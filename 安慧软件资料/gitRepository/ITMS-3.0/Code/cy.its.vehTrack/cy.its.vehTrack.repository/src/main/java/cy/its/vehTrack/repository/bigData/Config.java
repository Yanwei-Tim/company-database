package cy.its.vehTrack.repository.bigData;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

	public static Properties prop = null;

	/**
	 * ���ش����������ļ�
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void loadConfig() throws FileNotFoundException, IOException {
		prop = new Properties();
		InputStream input = Config.class.getResourceAsStream("/bigData.properties");
		prop.load(input);
		input.close();
	}

	/**
	 * ��ȡ������
	 * 
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String getProperties(String key) throws FileNotFoundException, IOException {
		if (prop == null) {
			loadConfig();
		}
		//�����use_big_data��bigdata_urlΪkey��ֱ��ȡֵ�������bigdata_url
		if("use_big_data".equals(key)||"bigdata_url".equals(key)){
			return prop.getProperty(key);
		}else{
			return prop.getProperty("bigdata_url")+prop.getProperty(key);
		}
	}

}
