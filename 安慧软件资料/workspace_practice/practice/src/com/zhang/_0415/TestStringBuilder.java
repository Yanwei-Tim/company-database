package com.zhang._0415;

public class TestStringBuilder {
	public static void main(String[] args) {
		
		/*StringBuilder��StringBuffer
		 * 1.StringBuffer�̰߳�ȫ������Ч�ʵͣ�StringBuilder�̲߳���ȫ,����Ч�ʸߡ��Ƽ�ʹ��StringBuilder��
		 * 2.����java.lang���¡�
		 * 3.StringBuilder��Stringƴ��Ч�ʸߡ�
		 */
		//+: ÿ����Ҫȥѯ�ʳ�������û������ַ�����
		// append:ֱ�Ӽӡ������ı�ʱ��Ч�����Ը�
		StringBuilder sb = new StringBuilder();
		sb.append(1).append("abc").append(true);
		System.out.println(sb);
	}
}
