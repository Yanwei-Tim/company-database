package com.zhang._0422;

/**
 * ȡǮ���߳���
 **/
public class DrawThread implements Runnable {

	private Accout accout;// �˻�����

	private double drawAmount;// ȡǮ��

	public DrawThread(Accout accout, double drawAmount) {
		super();
		this.accout = accout;
		this.drawAmount = drawAmount;
	}

	// �������߳��޸�ͬһ����������ʱ���ᷢ�����ݰ�ȫ����
	public synchronized void run() {
		// �˻�������ȡ����ʱ
		if (accout.getBalance() >= drawAmount) {
			// ȡ��ɹ�
			System.out.println(Thread.currentThread().getName() + accout.getAccoutName() + "ȡ��ɹ����³���Ʊ��" + drawAmount);
			// �޸����
			accout.setBalance(accout.getBalance() - drawAmount);
			System.out.println("��ǰ���Ϊ��" + accout.getBalance());
		}
		// �˻�����ʱ
		else {
			System.out.println("�˻��������������ֻ��" + accout.getBalance());
		}
	}
}