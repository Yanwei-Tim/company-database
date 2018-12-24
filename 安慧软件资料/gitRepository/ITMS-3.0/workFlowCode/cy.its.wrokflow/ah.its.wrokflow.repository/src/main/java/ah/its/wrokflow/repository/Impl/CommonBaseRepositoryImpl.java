package ah.its.wrokflow.repository.Impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ah.its.wrokflow.repository.CommonBaseRepositoryI;
import ah.its.wrokflow.repository.dao.CommonBaseObj;
import ah.its.wrokflow.repository.domain.CommonBaseMapper;

@Service
public class CommonBaseRepositoryImpl implements CommonBaseRepositoryI {
	
	
	@Autowired
	private CommonBaseMapper commonBaseMapper;//��ѯ������
	@Override
	public List<CommonBaseObj> selectAllData(Map map, String method) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//��ȡʵ�������
		Class clazz = commonBaseMapper.getClass(); 
		//��ȡʵ������
		Method md = clazz.getDeclaredMethod(method,Map.class);
		
		//���ö��󷽷�����������
		return (List<CommonBaseObj>) md.invoke(commonBaseMapper,map);
	}

}
