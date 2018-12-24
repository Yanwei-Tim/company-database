package cy.its.service.imageQuery.ice;

import Ice.Communicator;
import Ice.Properties;
import Ice.Util;

class ProxyUtil {

	final static Communicator commun;

	static {
		// ��ȡ����
		Properties props = properties();
		// ����ͨ������ʼ�������ݼ�
		Ice.InitializationData initData = new Ice.InitializationData();
		// �����Լ��ŵ���ʼ�������ݼ���
		initData.properties = props;

		// ��ʼ��ͨ����
		commun = Ice.Util.initialize(initData);
	}

	private static Properties properties() {
		String TIME_OUT = "1000";
		Properties props = Util.createProperties();
		// ���÷�����Ϣ�����ߴ�(��λ��KB)
		props.setProperty("Ice.MessageSizeMax", "1024000");
		// �����������ռ���������Ƶ��(ÿ������������һ��)
		props.setProperty("Ice.GC.Interval", "120");
		// ���ؼ���������̳߳���С�߳���
		props.setProperty("Ice.ThreadPool.Server.Size", "1");
		// ���ؼ���������̳߳�����߳���
		props.setProperty("Ice.ThreadPool.Server.SizeMax", "300");
		// ���ؿͻ����̳߳���С�߳���
		props.setProperty("Ice.ThreadPool.Client.Size", "1");
		// ���ؿͻ����̳߳�����߳���
		props.setProperty("Ice.ThreadPool.Client.SizeMax", "500");
		// ��ʱ����
		props.setProperty("Ice.Override.ConnectTimeout", TIME_OUT);
		return props;
	}
}
