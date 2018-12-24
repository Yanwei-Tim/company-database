package cy.its.com.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map.Entry;

import cy.its.platform.common.utils.Log4jFactoryProxy;

public class ObjectMapUtils {

	private static Log4jFactoryProxy log = Log4jFactoryProxy.getSingleton(ObjectMapUtils.class);
	
	@SuppressWarnings("rawtypes")
	private static HashMap<Class, HashMap<String, Field>> ClassDef = new HashMap<Class, HashMap<String, Field>>();

	/**
	 * ��Դ���������ֵ���ݵ�Ŀ����������ͬ���Ƶ�������
	 * 
	 * @param target
	 * @param src
	 */
	public static void parseObject(Object target, Object src) {
		parseObject(target, src, false);
	}

	/**
	 * ��Դ���������ֵ���ݵ�Ŀ����������ͬ���Ƶ������ϣ�����ʽ��
	 */
	public static void parseObjectOverWrite(Object target, Object src) {
		parseObject(target, src, true);
	}
	
	/**
	 * ��Դ���������ֵ���ݵ�Ŀ����������ͬ���Ƶ�������
	 * @param target
	 * @param src
	 * @param overWrite �Ƿ񸲸�
	 */
	public static void parseObject(Object target, Object src, boolean overWrite) {
		if (target == null || src == null) {
			return;
		}

		// ��ȡĿ����������
		HashMap<String, Field> tf = fieldOfClass(target.getClass());
		// ��ȡԴ���������
		HashMap<String, Field> sf = fieldOfClass(src.getClass());
		// ����ֵ����
		for (Entry<String, Field> kv : tf.entrySet()) {
			String tFn = kv.getKey();
			Field tFd = kv.getValue();
			try {
				if (sf.containsKey(tFn) && sf.get(tFn).getClass() == tFd.getClass()) {
					if (overWrite) {
						// Դ�������ͬ������������������ͬ��Ŀ����� ����ֵΪ��
						// ��Դ����ֵ���ݵ�Ŀ������
						kv.getValue().set(target, sf.get(tFn).get(src));
					} else {
						if (tFd.get(target) == null) {
							kv.getValue().set(target, sf.get(tFn).get(src));
						}
					}
				}
			} catch (Exception e) {
				log.debug(e.getMessage());
			}
		}

	}
	
	/**
	 * �ݹ���ȡ�����������
	 * 
	 * @param c
	 * @param map
	 */
	private static void extractFieldOfClass(Class<?> c,
			HashMap<String, Field> map) {
		if (c != Object.class) {
			for (Field field : c.getDeclaredFields()) {
				field.setAccessible(true);
				map.put(field.getName(), field);
			}

			if (c.getSuperclass() != null) {
				extractFieldOfClass(c.getSuperclass(), map);
			}
		}
	}

	/**
	 * ��ȡ�����������
	 * 
	 * @param c
	 * @return
	 */
	private static HashMap<String, Field> extractFieldOfClass(
			Class<? extends Object> c) {
		HashMap<String, Field> map = new HashMap<String, Field>();
		extractFieldOfClass(c, map);
		return map;
	}

	/**
	 * ��ѯ�����������
	 * 
	 * @param tClass
	 * @return
	 */
	private static HashMap<String, Field> fieldOfClass(
			Class<? extends Object> tClass) {
		if (!ClassDef.containsKey(tClass)) {
			try {
				ClassDef.put(tClass, extractFieldOfClass(tClass));
			} catch (Exception e) {
			}
		}

		return ClassDef.get(tClass);
	}
}
