package com.wujianbo.compare;

public class MainRun {
	public static void main(String[] args) {
		StringHandle sh = new StringHandle();
		CompareHandle ch = new CompareHandle();
		// ��ʾ�û������ַ���
		Integer[] a = sh.inputString();
		Integer[] b = sh.inputString();

		// ���û���������ݽ��бȽ�
		String result = ch.mainCompare(a, b);
		System.out.println(result);
	}
}