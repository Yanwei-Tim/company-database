package com.zhang._0414;
/**
 * ʵ�ֹ��������ӿڵľ���ʵ����
 * ��������Ĺ���
 * @author zhangyu
 *
 */
public class CreateIcebox implements Factory {

	@Override
	public Product create() {
		return new Icebox();
	}

}
