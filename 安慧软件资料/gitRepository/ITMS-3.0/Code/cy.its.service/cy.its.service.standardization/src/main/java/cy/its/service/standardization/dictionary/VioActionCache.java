package cy.its.service.standardization.dictionary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cy.its.service.common.ConstValue;
import cy.its.service.common.dataAccess.DbAccess;
import cy.its.service.common.ioc.Export;
import cy.its.service.common.ioc.Import;
import cy.its.service.common.log.LogManager;
import cy.its.service.standardization.dictionary.dao.IVioActionDAO;
import cy.its.service.standardization.dictionary.model.VioAction;

@Export
public class VioActionCache extends Cache {

	private Map<String, VioAction> cache = new HashMap<String, VioAction>();

	@Import
	IVioActionDAO vioActionDAO;

	public VioAction get(String vioActionCode) {
		synchronized (cache) {
			return cache.get(vioActionCode);
		}
	}

	@Override
	void load(DbAccess dbAccess) throws Exception {		

		LogManager.info("����Υ����Ϊ���뻺�濪ʼ");
		
		List<VioAction> vioActions = vioActionDAO.selectVioAction(dbAccess);
		if (vioActions == null) {
			return;
		}

		synchronized (cache) {
			cache.clear();
			for (VioAction v : vioActions) {
				if (!cache.containsKey(v.getVioActionCode())) {
					cache.put(v.getVioActionCode(), v);
				}
			}
		}
		
		LogManager.info("����Υ����Ϊ���뻺�����");
	}

	@Override
	List<String> getRelatedRouteKeys() {
		return Arrays.asList(ConstValue.ROUTE_KEY_CACHECHANGE_VIOACTION);
	}

}
