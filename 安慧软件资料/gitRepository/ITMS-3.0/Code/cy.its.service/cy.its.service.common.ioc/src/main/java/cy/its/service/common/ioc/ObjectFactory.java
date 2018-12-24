package cy.its.service.common.ioc;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class ObjectFactory {

	@SuppressWarnings("rawtypes")
	static Map<Class, Object> map = new HashMap<Class, Object>();

	@SuppressWarnings({ "rawtypes" })
	public static Object getBean(Class clazz) throws Exception {
		try {
			if (map.containsKey(clazz)) {
				return map.get(clazz);
			}

			return create(clazz);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		return null;
	}

	@SuppressWarnings("rawtypes")
	private static Object create(Class clazz) throws InstantiationException, IllegalAccessException, Exception {
		Object t = clazz.newInstance();
		for (Field f : TypeHelper.fieldOfClass(clazz)) {
			create(t, f);
		}
		map.put(clazz, t);
		return t;
	}

	@SuppressWarnings("unchecked")
	private static void create(Object t, Field f) throws IllegalAccessException, Exception {
		if (f.isAnnotationPresent(Import.class)) {
			f.setAccessible(true);
			// �ֶε�����
			@SuppressWarnings("rawtypes")
			Class fc = f.getType();
			// ��������б�����
			if (fc.isArray()) {
				// ��������
			} else if (fc.isAssignableFrom(List.class)) {
				// List����
				fieldOfList(t, f);
			} else if (fc.isAssignableFrom(Set.class)) {
				// ��������
			} else {
				// ��ͨ����
				fieldOfGeneral(t, f, fc);
			}
		}
	}

	/**
	 * ������б�򼯺����͵��ֶ�
	 * 
	 * @param t
	 * @param f
	 * @param fc
	 * @throws IllegalAccessException
	 * @throws Exception
	 */
	private static void fieldOfGeneral(Object t, Field f, Class<?> fc) throws IllegalAccessException, Exception {
		// ��ȡ�ֶ����Ͷ�Ӧ��ʵ���࣬�����ж��
		List<Class<?>> lst = RegTypeFactory.typesOfSuper(fc);
		if (lst != null && lst.size() > 0) {
			f.set(t, getBean(lst.get(0)));
		}
	}

	/**
	 * �����б����͵��ֶ�
	 * 
	 * @param t
	 * @param f
	 * @throws IllegalAccessException
	 */
	private static void fieldOfList(Object t, Field f) throws IllegalAccessException {
		// ��ȡlist��Ԫ�ص�����
		Type gType = f.getGenericType();
		ParameterizedType pType = (ParameterizedType) gType;
		Type eleType = pType.getActualTypeArguments()[0];
		Class<?> eleC = (Class<?>) eleType;

		// ��ȡListԪ�����Ͷ�Ӧ��ʵ����
		List<Class<?>> lst = RegTypeFactory.typesOfSuper(eleC);
		if (lst != null && lst.size() > 0) {
			// �б�����
			f.set(t, lst.stream().map(n -> {
				try {
					return getBean(n);
				} catch (Exception e) {
					return null;
				}
			}).collect(Collectors.toList()));
		}
	}
}
