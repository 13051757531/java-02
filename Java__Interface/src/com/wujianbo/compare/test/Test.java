package com.wujianbo.compare.test;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a= "45678";
		int b= 45678;
		//String f= Integer.toString(b);
		String c="45678";
		double d= 45678;
		String g= Double.toString(d);
		//�ַ���������
		//�ַ���������
		if(a.equals(Integer.toString(b))) {
			System.out.println("���");
		}else {
			System.out.println("�����");
		}

	}

}
