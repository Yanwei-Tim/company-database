package com.zhang._0416;

/**
 * SuperStorage����������ʵ��IMobileStorage�ӿ� ��ra��wt����ת����Read��Write����
 * 
 * @author zhangyu
 *
 */
public class SuperStorageAdapter implements IMobileStorage {

	private SuperStorage superstorage; // ����SuperStorage���ñ���

	public SuperStorage getSuperstorage() {
		return superstorage;
	}

	public void setSuperstorage(SuperStorage superstorage) {
		this.superstorage = superstorage;
	}

	@Override
	public void read() {
		superstorage.ra(); // ��ra()ת����read()
	}

	@Override
	public void write() {
		superstorage.wt(); // ��wt()ת����write()
	}

}
