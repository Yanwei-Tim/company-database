package cy.its.web;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

import cy.its.com.bus.EventBus;
import cy.its.com.util.Config;
import cy.its.device.repository.SysRepository;
import cy.its.platform.common.utils.OrderedProperties;
import cy.its.platform.common.utils.RedisPoolUtil;
import cy.its.platform.common.utils.SftpUtil;
import cy.its.platform.common.utils.SpringBeanFactoryUtil;
import cy.its.service.imageQuery.cfg.dataAccess.DataSourceFactory;

/**
 * @author lilei ����������ʼ�����в��� Ŀǰ֮��̬�޸Ļ���Ĵ��·��
 */
public class InitServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7494197526457091687L;

	public static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator");

	private String globalPath = "";

	private static String redisPath;

	private static String sftpPath;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String prefix = config.getServletContext().getRealPath("/");
		if (FILE_SEPARATOR.equals("\\")) {
			// ��ȡ���ݷ����������ļ���·��
			globalPath = prefix + "WEB-INF\\classes\\global.properties";
			redisPath = prefix + "WEB-INF\\classes\\redis.properties";
			sftpPath = prefix + "WEB-INF\\classes\\sftp.properties";
		} else if (FILE_SEPARATOR.equals("/")) {
			redisPath = prefix + "WEB-INF/classes/redis.properties";
			globalPath = prefix + "WEB-INF/classes/global.properties";
			sftpPath = prefix + "WEB-INF/classes/sftp.properties";
		}
		System.out.println("��Ŀ·��Ϊ��" + prefix);

		OrderedProperties prop = getProperties();
		prop.setProperty("prefix", prefix);
		GlobalProerty.setGlobalProerty(prop);
		System.out.println("ϵͳ���Գ�ʼ�����");
		System.out.println(GlobalProerty.getGlobalProerty().validate_ip);

		// ����SPRING BEAN
		SpringBeanFactoryUtil.setServletContext(this.getServletContext());

		Config.init(prop);
		EventBus eventBus = EventBus.class.cast(SpringBeanFactoryUtil.getBeanFromFactory("eventBus"));

		if (eventBus != null) {
			eventBus.start();
		}

		DataSourceFactory.setDataSource((DataSource) (SpringBeanFactoryUtil.getBeanFromFactory("dataSource")));

		// ��ʼ��redis
		initRedis();
		// ��ʼ��sftp
		initSftp();

		initDevCertiStatus();

	}

	private void initDevCertiStatus() {
		SysRepository sysRep = SysRepository.class.cast(SpringBeanFactoryUtil.getBeanFromFactory("sysRepository"));
		sysRep.cacheCertiDevice();

	}

	/**
	 * @Title: initRedis @Description:��ʼ��redis��Ϣ @param �趨�ļ� @return void
	 *         �������� @throws
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
	 * @Title: initRedis @Description:��ʼ��redis��Ϣ @param �趨�ļ� @return void
	 *         �������� @throws
	 */
	private void initSftp() {
		Constructor c0;
		try {
			c0 = SftpUtil.class.getDeclaredConstructor(new Class[] { String.class });
			c0.setAccessible(true);
			c0.newInstance(new Object[] { sftpPath });
		} catch (Exception e) {
			System.out.println("��ʼ��sftp�����쳣");
			e.printStackTrace();
		}
		System.out.println("��ʼ��sftp���");
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
