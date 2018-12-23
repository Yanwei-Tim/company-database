package com.zhang._0416;

/**
 * �������
 * 
 * @author zhangyu
 *
 */
public class Computer {

	private IMobileStorage imobilestorage;// ��IMobileStorage�ӿ�һ�����ñ���
	
	public Computer() {

	}

	public Computer(IMobileStorage imobilestorage) {
		super();
		this.imobilestorage = imobilestorage;
	}

	// ΪIMobileStorage�����ṩget/set����
	public IMobileStorage getImobilestorage() {
		return imobilestorage;
	}

	public void setImobilestorage(IMobileStorage imobilestorage) {
		this.imobilestorage = imobilestorage;
	}

	/**
	 * ����IMobileStorage�еĶ����ݷ���
	 */
	public void readData() {
		imobilestorage.read();
	}

	/**
	 * ����IMobileStorage�е�д���ݷ���
	 */
	public void writeData() {
		imobilestorage.write();
	}

}
