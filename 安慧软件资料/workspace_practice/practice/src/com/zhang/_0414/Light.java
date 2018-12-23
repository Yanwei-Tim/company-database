package com.zhang._0414;

/**
 * 
 * @author zhangyu
 *	Lightö����  enum
 */
public enum Light {
	
	 // ���ù��캯������
    RED (1), GREEN (3), YELLOW (2);

    // ����˽�б���
    private int nCode;

    // ���캯����ö������ֻ��Ϊ˽��
    private Light( int _nCode) {
        this . nCode = _nCode;
    }

    @Override
    public String toString() {
        return String.valueOf ( this . nCode );
    } 
}
