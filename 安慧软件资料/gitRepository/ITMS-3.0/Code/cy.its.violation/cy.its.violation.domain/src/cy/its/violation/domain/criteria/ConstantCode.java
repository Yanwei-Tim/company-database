package cy.its.violation.domain.criteria;

/**
 * @title:SysCodeDic.java
 * @Package:cy.its.violation.rest.dto
 * @Description:TODO
 * @author:jinhb@cychina.cn
 * @date: 2015��9��24�� ����4:20:21
 * @version v1.0
 */
public class ConstantCode {
	/**
	 * @title:SysCodeDic.java
	 * @Package:cy.its.violation.rest.dto
	 * @Description:Υ������ 011
	 * @author:jinhb@cychina.cn
	 * @date: 2015��10��13�� ����8:36:16
	 * @version v1.0
	 */
	public static class ViolationType {

		/**
		 * ��ռ�� 0
		 */
		public static final String DA_CZD = "0";
		/**
		 * ������ 1
		 */
		public static final String CHAO_GS = "1";
		/**
		 * ���� 3
		 */
		public static final String NI_X = "3";
		/**
		 * ����� 4
		 */
		public static final String CHUANG_HD = "4";
		/**
		 * ѹ���� 5
		 */
		public static final String YA_HX = "5";
		/**
		 * Υ��ͣ�� 6
		 */
		public static final String WEI_ZTC = "6";
		/**
		 * ���䳬�� 7
		 */
		public static final String QU_JCS = "7";
		/**
		 * ���� 8
		 */
		public static final String JIN_X = "8";
		/**
		 * ���� 9
		 */
		public static final String QI_T = "9";
		/**
		 * ����������ʻ c
		 */
		public static final String BU_ADXXS = "c";
		/**
		 * ѹ�� d
		 */
		public static final String YA_X = "d";
		/**
		 * Υ��ռ�� a
		 */
		public static final String WEI_FZD = "a";
		/**
		 * �ڵ����� b
		 */
		public static final String ZHE_DHP = "b";
		/**
		 * δϵ��ȫ�� e
		 */
		public static final String WEI_JAQD = "e";
	}

	/**
	 * @title:SysCodeDic.java
	 * @Package:cy.its.violation.rest.dto
	 * @Description:��¼״̬ 301
	 * @author:jinhb@cychina.cn
	 * @date: 2015��9��24�� ����4:04:08
	 * @version v1.0
	 */
	public static class StatusFlag {

		/**
		 * �¼�¼ 0
		 */
		public static final String NEW = "0";

		/**
		 * �� ��ɸ 1
		 */
		public static final String FILTERED = "1";
		/**
		 * ��¼�� 2
		 */
		public static final String CONFIRMED = "2";
		/**
		 * ����¼ 3
		 */
		public static final String RECONFIRM = "3";
		/**
		 * �ѷ��� 9
		 */
		public static final String DISCARDED = "9";
	}

	/**
	 * @title:SysCodeDic.java
	 * @Package:cy.its.violation.rest.dto
	 * @Description:�ϴ�״̬ 305
	 * @author:jinhb@cychina.cn
	 * @date: 2015��10��13�� ����8:36:26
	 * @version v1.0
	 */
	public static class UploadFlag {
		/**
		 * δ�ϴ� 0
		 */
		public static final String NEW = "0";
		/**
		 * ���ϴ� 1
		 */
		public static final String WAITING = "1";
		/**
		 * ���ϴ� 2
		 */
		public static final String UPLOADED = "2";
		/**
		 * �ϴ�ʧ�� 3
		 */
		public static final String FAILED = "3";
		/**
		 * ȡ���ϴ� 4
		 */
		public static final String CANCEL = "4";
	}

	/**
	 * @title:SysCodeDic.java
	 * @Package:cy.its.violation.rest.dto
	 * @Description:������� 306
	 * @author:jinhb@cychina.cn
	 * @date: 2015��9��24�� ����4:20:23
	 * @version v1.0
	 */
	public static class DiscardType {
		/**
		 * ���� 1
		 */
		public static final String SINGLE = "1";
		/**
		 * �Զ� 2
		 */
		public static final String AUTO = "2";
		/**
		 * ���� 3
		 */
		public static final String BATCH = "3";
	}

	/**
	 * @title:SysCodeDic.java
	 * @Package:cy.its.violation.rest.dto
	 * @Description:����ԭ�� 312
	 * @author:jinhb@cychina.cn
	 * @date: 2015��9��24�� ����4:23:08
	 * @version v1.0
	 */
	public static class DiscardReason {
		/**
		 * �쳣���� 01
		 */
		public static final String ABNORMAL = "01";
		/**
		 * �ظ���¼ 03
		 */
		public static final String DUPLICATE = "03";
		/**
		 * ��Чͼ�� 04
		 */
		public static final String BAD_IMAGE = "04";
		/**
		 * ���Ʋ�ȫ 05
		 */
		public static final String UNCOMPLETE_PLATE = "05";
		/**
		 * �޺��� 06
		 */
		public static final String MISSIONG_PLATE = "06";
		/**
		 * ��ʱ 07
		 */
		public static final String OVER_TIME = "07";
		/**
		 * ���� 08
		 */
		public static final String OTHER = "08";
		/**
		 * ���Ƴ� 21
		 */
		public static final String IMITAT_PLATE = "21";
		/**
		 * ���Ƴ� 22
		 */
		public static final String FAKE_PALTE = "22";
		/**
		 * �������� 23
		 */
		public static final String WHITE_VEH = "23";
		/**
		 * ������ 24
		 */
		public static final String ARM_VEH = "24";
		/**
		 * ũ�ó� 25
		 */
		public static final String FARM_VEH = "25";

	}

	public static class BooleanFlag {
		/**
		 * �¼�¼ 0
		 */
		public static final String NONE = "0";

		/**
		 * �仯 1
		 */
		public static final String TRUE = "1";
	}

}
