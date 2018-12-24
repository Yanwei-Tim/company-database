/**
 * 
 */
package cy.its.syscfg.domain.model.duty;

import java.math.BigDecimal;

import cy.its.com.domain.Value;

/**
 * @author STJ ����פ����Ϣ
 */
public class OrgSeat extends Value {
	/**
	 * ����פ�ص�ַ
	 */
	public java.lang.String addressDesc;
	
	/**
	 * ����פ����������(007)
	 */
	public java.lang.String districtCode;
	
	/**
	 * ����פ�����ڳ���
	 */
	public java.lang.String city;
	
	/**
	 * ����פ������ľ���
	 */
	public BigDecimal orgLongitude;
	
	/**
	 * ����פ�ص������γ��
	 */
	public BigDecimal orgLatitude;
	
	
	
	@Override
	protected boolean IsEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
}
