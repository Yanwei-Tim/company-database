package ah.its.wrokflow.domain.util;

import java.util.HashMap;
import java.util.Map;

public class ReturnResultUtil {
	/**
	 * @param status ״̬ AAAAAA�ɹ���000000ʧ��
	 * @param msg �����Ϣ
	 * @param data ��������
	 */
	public static  Map<String, Object> returnResult(String status,String msg,Object data) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("status", status);
		returnMap.put("msg", msg);
		returnMap.put("data", data);
		return returnMap;
	}
	/**
	 * @param data ��������
	 */
	public static  Map<String, Object> returnSuccessResult(Object data) {
		return returnResult("AAAAAA",null,data);
	}
	/**
	 * @param msg ʧ����Ϣ
	 */
	public static  Map<String, Object> returnErrorResult(String msg) {
		return returnResult("000000",msg,null);
	}
}