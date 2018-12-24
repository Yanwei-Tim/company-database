package com.cy.web.util;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cy.cache.service.CacheServiceI;
import com.cy.web.GlobalProerty;

import cy.its.common.duplex.rabbitMq.MQEntrance;
import cy.its.common.duplex.rabbitMq.RabbitMqProperties;
import cy.its.platform.common.utils.OrderedProperties;
import cy.its.platform.common.utils.RedisPoolUtil;

/**
 * @author lilei ����������ʼ�����в��� Ŀǰ֮��̬�޸Ļ���Ĵ��·��
 */
public class InitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7494197526457091687L;

	public static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator");

	private static String dataDictionaryPath;

	private static String redisPath;

	private static String rabbitMqPath;

	private String globalPath = "";

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String prefix = config.getServletContext().getRealPath("/");

		if (FILE_SEPARATOR.equals("\\")) {
			// ��ȡ���ݷ����������ļ���·��
			globalPath = prefix + "WEB-INF\\classes\\global.properties";
			dataDictionaryPath = prefix + "WEB-INF\\classes\\dataDictionary.xml";
			redisPath = prefix + "WEB-INF\\classes\\redis.properties";
			rabbitMqPath = prefix + "WEB-INF\\classes\\rabbitmq.properties";
		} else if (FILE_SEPARATOR.equals("/")) {
			globalPath = prefix + "WEB-INF/classes/global.properties";
			dataDictionaryPath = prefix + "WEB-INF/classes/dataDictionary.xml";
			redisPath = prefix + "WEB-INF/classes/redis.properties";
			rabbitMqPath = prefix + "WEB-INF/classes/rabbitmq.properties";
		}
		System.out.println("��Ŀ·��Ϊ��" + prefix);
		// System.out.println("Ӳ�̻���·��Ϊ��"+prefix);
		// chanageJcsIdxPath(); ɾ��jcs ���� ����redis��ʽ
		OrderedProperties prop = getProperties();
		setProperties(prop, prefix);
		System.out.println("ϵͳ���Գ�ʼ�����");

		// ��ʼ��redis���ӳ�
		initRedis();

		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		CacheServiceI cacheServiceImpl = (CacheServiceI) wac.getBean("cacheServiceImpl");
		cacheServiceImpl.initServicesByRoleCode();
		cacheServiceImpl.initKeyList();
		// ��ʼ��redis���ӳ�
		initRabbitMq();
	}

	private void initRabbitMq() {
		Executors.newFixedThreadPool(1).submit(() -> {
			OrderedProperties prop = new OrderedProperties();
			Map<String, String> map = new HashMap<String, String>();
			try {
				FileInputStream fis = new FileInputStream(rabbitMqPath);
				prop.load(fis);
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			Class[] paramTypes = { String.class, String.class, String.class, String.class, String.class, Map.class };
			Object[] params = { prop.getProperty("mq.ip"), prop.getProperty("mq.user"), prop.getProperty("mq.pwd"),
					prop.getProperty("mq.dataCenter"), prop.getProperty("mq.exchangeType"), map };
			Set<String> keys = prop.stringPropertyNames();

			for (String key : getNewKey(keys)) {
				String value = prop.getProperty(key);
				map.put(key, value);
			}
			Constructor con;
			Constructor con2;
			try {
				con = RabbitMqProperties.class.getDeclaredConstructor(paramTypes);
				con.setAccessible(true);
				con.newInstance(params);
				// ʵ��������
				con2 = MQEntrance.class.getDeclaredConstructor();
				con2.setAccessible(true);
				con2.newInstance(null);
			} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				System.out.println("rabbitMq��ʼ��ʧ�ܣ�");
				e.printStackTrace();
			}
			sendMqMessage();
		});

	}

	private void sendMqMessage() {
		// ��ʼ���豸״̬���� add chenzhy
		cy.its.common.duplex.mapData.DeviceStatusMapData.sendMqMessage();
		// ��ʼ��������״̬���� add chenzhy
		cy.its.common.duplex.mapData.ServerStatusMapData.sendMqMessage();
	}

	private Set<String> getNewKey(Set<String> keys) {
		// ɾ��KEY
		keys.remove("mq.ip");
		keys.remove("mq.user");
		keys.remove("mq.pwd");
		keys.remove("mq.dataCenter");
		keys.remove("mq.exchangeType");
		return keys;
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
			c0.newInstance(new Object[] { "", redisPath });
		} catch (Exception e) {
			System.out.println("��ʼ��redis�����쳣");
			e.printStackTrace();
		}
		System.out.println("��ʼ��redis���");
	}

	/**
	 * @param prop
	 * @param prefix
	 *            ����ϵͳȫ�ֱ���
	 */
	private void setProperties(OrderedProperties prop, String prefix) {
		Class[] paramTypes = { String.class, String.class, String.class, String.class, String.class, String.class,
				String.class };
		String[] params = { prefix, prop.getProperty("isDistributed"), prop.getProperty("model"),
				prop.getProperty("service_ip"), prop.getProperty("validate_ip"), prop.getProperty("servicePName"),
				prop.getProperty("authorityPName") };
		Constructor con;
		try {
			con = GlobalProerty.class.getDeclaredConstructor(paramTypes);
			con.setAccessible(true);
			con.newInstance(params);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			System.out.println("��ʼ��ȫ�ֱ���ʧ�ܣ�");
			e.printStackTrace();
		}

	}

	/**
	 * ��ȡ�����ļ� Ϊ��Ŀ�����ʼ����Ϣ ��Ŀ·����Ϣ ϵͳ�û�ΪADMIN Ŀǰģʽ��Ϣ�������������� �Ƿ�ֲ�ʽ
	 */
	private OrderedProperties getProperties() {
		OrderedProperties prop = new OrderedProperties();
		try {
			FileInputStream fis = new FileInputStream(globalPath);
			prop.load(fis);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prop;
	}
}
