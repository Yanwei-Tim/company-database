package cy.its.service.data2db.BulkData.Data;

import java.util.List;

import cy.its.service.common.ConstValue;
import cy.its.service.common.dataModel.Violation;
import cy.its.service.common.ioc.Export;
import cy.its.service.data2db.BulkData.Utils.BulkParam;

@Export
public class VioBulkDAL extends BulkDAL<Violation>  {
	
	public VioBulkDAL() {
		super(Violation.class);
	}

	@Override
	void extendCols(List<String[]> lst) { 
		lst.add(new String[] { "VIOLATION_ID", "SEQ_DEFAULT.NEXTVAL" });
		lst.add(new String[] { "EXPORT_FLAG", "'0'" });  // ������ʶ(314) 0��δ����
		lst.add(new String[] { "LOCK_FLAG",   "'0'" });  // ������ʶ(315) 0��δ����
		lst.add(new String[] { "STATUS_FLAG", "'0'" });  // ��¼״̬(301) 0���¼�¼
		lst.add(new String[] { "CREATE_TIME", "SYSDATE" });  // ����ʱ��
		lst.add(new String[] { "UPDATE_TIME", "SYSDATE" });  // ����ʱ�� 
	}

	@Override
	public BulkParam getBulkParam() {
		String tableName = "T_VIO_VIOLATION";
		String dataName = "VIO";
		int cacheMaxSize = 100;
		int maxBatchSize = 30;
		int readMaxPeriod = 5000;
		String routeKey = ConstValue.ROUTE_KEY_STANDARD_VIO;
		String queueName = "Data2DB_VIO";

		return new BulkParam(tableName, dataName, cacheMaxSize,
				maxBatchSize, readMaxPeriod, routeKey, queueName);
	}

}
