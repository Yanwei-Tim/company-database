package com.zhang._0416;

/**
 * ���Խӿ�
 * 
 * @author zhangyu
 *
 */
public class InterfaceExample {
	public static void main(String[] args) {
		Computer computer = new Computer();
		IMobileStorage flashdisk = new FlashDisk(); // U�̶���
		IMobileStorage mp3player = new MP3Player();// MP3����
		IMobileStorage mobileharddisk = new MobileHardDisk();// �ƶ�Ӳ�̶���

		IMobileStorage sdcard = new SdCard();// ����ӵ�SD��

		computer.setImobilestorage(flashdisk);
		computer.readData(); // U�̶�����
		computer.writeData();// U��д����

		computer.setImobilestorage(mp3player);
		computer.readData(); // Mp3�̶�����
		computer.writeData();// MP3д����

		computer.setImobilestorage(mobileharddisk);
		computer.readData(); // �ƶ�Ӳ�̶�����
		computer.writeData();// �ƶ�Ӳ��д����

		computer.setImobilestorage(sdcard);
		computer.readData();
		computer.writeData();

		SuperStorage superstorage = new SuperStorage(); // ���豸����
		SuperStorageAdapter superstorageadapter = new SuperStorageAdapter();// ���豸����������
		superstorageadapter.setSuperstorage(superstorage);// ת������
		computer.setImobilestorage(superstorageadapter);
		computer.readData();
		computer.writeData();

	}

}
