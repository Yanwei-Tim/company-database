package cy.its.service.imageQuery.cfg.dataAccess;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

class OraDiscardedDbError implements IDiscardedDbError {

	Map<Integer, String> Error = new HashMap<Integer, String>();

	OraDiscardedDbError() {
		// �������´���ʱ���ݽ��ᱻ����
		Error.put(1, "Υ��ΨһԼ������");
		Error.put(67, "ֵ�Բ�����Ч�����ٱ���Ϊ");
		Error.put(68, "ֵ�Բ�����Ч�������ں�֮��");
		Error.put(70, "������Ч");
		Error.put(79, "δ�ҵ�����");
		Error.put(93, "������ں�֮��");
		Error.put(94, "Ҫ������ֵ");
		Error.put(96, "ֵ�Բ�����Ч������������֮��");
		Error.put(910, "ָ���ĳ��ȶ����������Ͷ��Թ���");
		Error.put(959, "��ռ�''������");
		Error.put(1282, "ָ�������ڷ�Χ��Ч");
		Error.put(1400, "�޷���NULL����()");
		Error.put(1401, "�����ֵ�����й���");
		Error.put(1407, "�޷�����()ΪNULL");
		Error.put(1412, "���������Ͳ������㳤��");
		Error.put(1414, "���Զ����鸳ֵʱ����Ч���鳤��");
		Error.put(1428, "����''������Χ");
		Error.put(1438, "ֵ���ڴ���ָ��������ȷ��");
		Error.put(1449, "�а���NULLֵ���޷�����ı�ΪNOTNULL");
		Error.put(1450, "�������Ĺؼ��ֳ���()");
		Error.put(1451, "Ҫ�޸�ΪNULL�����޷��޸�ΪNULL");
		Error.put(1458, "�ڲ������ַ������ȷ�");
		Error.put(1459, "�����ַ������ȷǷ�");
		Error.put(1461, "������Ϊ����LONG�е�LONGֵ��ֵ");
		Error.put(1462, "���ܲ��볬��4000���ַ����������ַ���");
		Error.put(1481, "��Ч�����ָ�ʽģ��");
		Error.put(1482, "����֧�ֵ��ַ���");
		Error.put(1488, "���������е���Ч���ֽڻ��ֽ�");
		Error.put(2017, "Ҫ������ֵ");
		Error.put(24381, "���� DML ����");

	}

	@Override
	public Boolean isDiscardedDataError(Exception e) {
		if (e instanceof SQLException) {
			SQLException sqlException = SQLException.class.cast(e);
			if (sqlException != null) {
				int errorCode = sqlException.getErrorCode();
				return Error.containsKey(errorCode);
			}
		}

		return false;
	}
}