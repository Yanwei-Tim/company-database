package cy.its.service.common;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
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
	final static Charset UTF8_CHARSET = Charset.forName("UTF-8");

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
		return getCipher(key, mode).doFinal(plainText);
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
		byte[] keyResult = key.getBytes(UTF8_CHARSET);
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
			return byteArr2HexStr(coderByDES(plainText.getBytes(UTF8_CHARSET), key, Cipher.ENCRYPT_MODE));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return StringUtil.EMPTY_STR;
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
			return new String(coderByDES(hexStr2ByteArr(secretText), key, Cipher.DECRYPT_MODE), UTF8_CHARSET);
		} catch (Exception ex) {
			ex.printStackTrace();			
		}
		
		return StringUtil.EMPTY_STR;
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
		StringBuffer sb = new StringBuffer(iLen * ConstValue.INT_2);
		int intTmp;
		for (int i = ConstValue.INT_0; i < iLen; i++) {
			intTmp = arrB[i];
			// �Ѹ���ת��Ϊ����
			while (intTmp < ConstValue.INT_0) {
				intTmp += ConstValue.INT_256;
			}
			// С��0F������Ҫ��ǰ�油0
			if (intTmp < ConstValue.INT_16) {
				sb.append(ConstValue.CHAR_ZERO);
			}
			sb.append(Integer.toString(intTmp, ConstValue.INT_16));
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
}
