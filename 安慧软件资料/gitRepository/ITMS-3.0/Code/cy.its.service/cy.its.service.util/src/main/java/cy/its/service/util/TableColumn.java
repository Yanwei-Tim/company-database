package cy.its.service.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @Title: TableColumn.java 
* @Package cy.its.service.util 
* @Description:���ݿ��Ӧ�ֶ�
* @author lil@cychina.cn
* @date 2015��12��15�� ����5:06:51 
* @version V1.0   
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TableColumn {
	
	//��Ӧ�ֶ�ֵ
	public String name()  default "className";
	
}
