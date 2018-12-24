/**
 * @Title: MD5Util.java
 * @Package cy.its.com.util
 * @Description: TODO(����Ҫ��д��;)
 * @author zuop zuop@cychina.cn
 * @date 2015��11��13�� ����10:11:16
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.platform.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
  * @ClassName: MD5Util
  * @Description: ���ַ�������md5����
  * @author zuop zuop@cychina.cn
  * @date 2015��11��13�� ����10:11:16
  *
  */
public class MD5Util {
	public static String md5(String in) throws NoSuchAlgorithmException{
		char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','b','d','e','f'};
		// ���MD5ժҪ�㷨�� MessageDigest ����
        MessageDigest mdInst = MessageDigest.getInstance("MD5");
        // ʹ��ָ�����ֽڸ���ժҪ
        mdInst.update(in.getBytes());
        // �������
        byte[] md = mdInst.digest();
        int j = md.length;
        char str[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = md[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
       return new String(str);
	}
}
