package com.wujianbo;

/**
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args){
		System.out.println(args);
		Demo02 demo02= new Demo02();
		System.out.println(demo02);
		System.out.println("�����ڶ�ջ�е��ڴ��׵�ַ��"+demo02.hashCode());
		demo02.dataTye();
		int age=34;
		System.out.println(age);
		
	}
	
	public void dataTye(){
		int i= (int)1000.1;
		char[] s= {'w', 'o', 'n', 'i', 'u'};
		System.out.println(s);
		System.out.println("�ַ������ڶ���ջ�����׵�ַ��"+s.hashCode());
		String b= "��ţѧԺ";
		System.out.println("�ַ����ڶ���ջ�����׵�ַ��"+b.hashCode());
		float f= 9999.82F;
	}

}
