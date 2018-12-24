package ah.its.workFlow.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
* @Title: MD5Util.java 
* @Package ah.its.workFlow.util 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author lil@cychina.cn
* @date 2016��4��5�� ����3:48:21 
* @version V1.0   
 */
public class MD5Util {
	public static String md5(String in) throws NoSuchAlgorithmException{
		char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','b','d','e','f'};
        MessageDigest mdInst = MessageDigest.getInstance("MD5");
        mdInst.update(in.getBytes());
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
	
	public  static  void main(String[] args){
		try {
			System.out.println(md5("123456"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
