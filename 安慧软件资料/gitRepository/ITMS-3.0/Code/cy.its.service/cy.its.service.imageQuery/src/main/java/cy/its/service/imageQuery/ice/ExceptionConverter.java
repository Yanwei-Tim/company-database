package cy.its.service.imageQuery.ice;

import cy.its.service.common.StringUtil;

public class ExceptionConverter {
	final static String ALERT_MSG_TIMEOUT = "���Ӽ�ط�������ʱ!";
	final static String ALERT_MSG_CONNFAILED = "����������޷����Ӽ�ط�����!";
	final static String ALERT_MSG_CONNREFUSED = "��ط������ܾ�����!";
	final static String ALERT_MSG_OPTERROR = "��ط������˴������!";
	// final static String ALERT_MSG_DEVCOMMERROR = "%sʱ��ط���������ǰ���豸ʧ��!";
	// final static String ALERT_MSG_DBERROR = "%sʱ��ط����������ݿ����ʧ��!";
	// final static String ALERT_MSG_USERERROR = "%sʱ��ط������˳���!ԭ��:%s";
	// final static String ALERT_MSG_FAILED = "%sʧ��!";

	public static String convert(Exception e) {
		if (e instanceof Ice.ConnectTimeoutException || e instanceof Ice.TimeoutException) {
			// ���ӳ�ʱ
			return String.format(ALERT_MSG_TIMEOUT);
		} else if (e instanceof Ice.ConnectFailedException) {
			// ��ط���������ʧ��
			return String.format(ALERT_MSG_CONNFAILED);
		} else if (e instanceof Ice.ConnectionRefusedException) {
			// ��ط������ܾ�����
			return String.format(ALERT_MSG_CONNREFUSED);
		} else if (e instanceof Ice.UnknownException) {
			// ��ط������˴������
			return String.format(ALERT_MSG_OPTERROR);
		} else {
			return StringUtil.EMPTY_STR;
		}
	}
}
