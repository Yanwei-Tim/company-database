package cy.its.com.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class SecurityEncode {

	final static Map<String, Cipher> cipher = new HashMap<String, Cipher>();
	final static String KEY = "%s_%d";

	/**
	 * MD5��ʽ�����ַ���
	 * 
	 * @param str
	 *            Ҫ���ܵ��ַ���
	 * @return ���ܺ���ַ���
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * 
	 * 
	 * @comment ����ļ�ֵ��������������:�����ڵļ�ֵ,��δ���ļ�ֵ
	 */
	// public static String encoderByMd5(String str)
	// throws NoSuchAlgorithmException, UnsupportedEncodingException {
	// // ȷ�����㷽��
	// MessageDigest md5 = MessageDigest.getInstance("MD5");
	// Base64Encoder base64en = new BASE64Encoder();
	// // ���ܺ���ַ���
	// String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
	// return newstr;
	// }

	/**
	 * DES�ӽ���
	 * 
	 * @param plainText
	 *            Ҫ�����byte[]
	 * @param key
	 *            ��Կ
	 * @param mode
	 *            ģʽ
	 * @return
	 * @throws InvalidKeyException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws UnsupportedEncodingException
	 * 
	 *
	 */
	private static byte[] coderByDES(byte[] plainText, String key, int mode)
			throws InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException,
			BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
		Cipher cipher = getCipher(key, mode);
		return cipher.doFinal(plainText);
	}

	private static Cipher createCipher(String key, int mode) throws UnsupportedEncodingException, InvalidKeyException,
			InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException {
		SecureRandom sr = new SecureRandom();
		byte[] resultKey = makeKey(key);
		DESKeySpec desSpec = new DESKeySpec(resultKey);
		SecretKey secretKey = SecretKeyFactory.getInstance("DES").generateSecret(desSpec);
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(mode, secretKey, sr);
		return cipher;
	}

	/**
	 * ����8λ��key
	 * 
	 * @param key
	 *            �ַ�����ʽ
	 * @return
	 * @throws UnsupportedEncodingException
	 * 
	 *
	 */
	private static byte[] makeKey(String key) throws UnsupportedEncodingException {
		byte[] keyByte = new byte[8];
		byte[] keyResult = key.getBytes("UTF-8");
		for (int i = 0; i < keyResult.length && i < keyByte.length; i++) {
			keyByte[i] = keyResult[i];
		}
		return keyByte;
	}

	/**
	 * DES����
	 * 
	 * @param plainText
	 *            ����
	 * @param key
	 *            ��Կ
	 * @return
	 * 
	 *
	 */
	public static String encoderByDES(String plainText, String key) {
		try {
			byte[] result = coderByDES(plainText.getBytes("UTF-8"), key, Cipher.ENCRYPT_MODE);
			return byteArr2HexStr(result);
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}

	/**
	 * DES����
	 * 
	 * @param secretText
	 *            ����
	 * @param key
	 *            ��Կ
	 * @return
	 * 
	 *
	 */
	public static String decoderByDES(String secretText, String key) {
		try {
			byte[] result = coderByDES(hexStr2ByteArr(secretText), key, Cipher.DECRYPT_MODE);
			return new String(result, "UTF-8");
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}

	/**
	 * ��byte����ת��Ϊ��ʾ16����ֵ���ַ����� �磺byte[]{8,18}ת��Ϊ��0813�� ��public static byte[]
	 * hexStr2ByteArr(String strIn) ��Ϊ�����ת������
	 * 
	 * @param arrB
	 *            ��Ҫת����byte����
	 * @return ת������ַ���
	 */
	private static String byteArr2HexStr(byte[] arrB) {
		int iLen = arrB.length;
		// ÿ��byte�������ַ����ܱ�ʾ�������ַ����ĳ��������鳤�ȵ�����
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			// �Ѹ���ת��Ϊ����
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			// С��0F������Ҫ��ǰ�油0
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString();
	}

	/**
	 * ����ʾ16����ֵ���ַ���ת��Ϊbyte���飬 ��public static String byteArr2HexStr(byte[] arrB)
	 * ��Ϊ�����ת������
	 * 
	 * @param strIn
	 *            ��Ҫת�����ַ���
	 * @return ת�����byte����
	 * @throws NumberFormatException
	 */
	private static byte[] hexStr2ByteArr(String strIn) throws NumberFormatException {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;
		// �����ַ���ʾһ���ֽڣ������ֽ����鳤�����ַ������ȳ���2
		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}
	

	private static Cipher getCipher(String key, int mode) throws InvalidKeyException, UnsupportedEncodingException,
			InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException {
		String k = String.format(KEY, key, mode);
		synchronized (cipher) {
			Cipher c = cipher.get(k);
			if (c == null) {
				c = createCipher(k, mode);
				cipher.put(k, c);
			}

			return c;
		}
	}
}
