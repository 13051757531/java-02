package com.wujianbo;

import java.util.Random;
import java.util.Scanner;

     /*
	 * x��y�η�
	 */

public class Demo08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo08 demo08= new Demo08();
		//demo08.powerOne();
		//System.out.println(demo08.powerTwo(2, 3));
		//demo08.exePower();
		//demo08.charStat();
		//demo08.guessPrice();
		int a= demo08.checkNumber();
		System.out.println(a);

	}
	
	public void powerOne() {
		// 2��3�η�
		int a = 3;
		int b = 5;
		int result = 1;
		// ѭ��b�Σ�����Ϊa
		for (int i = 1; i <= b; i++) {
			result *= a;
		}
		System.out.println(a + "��" + b + "�η��ǣ�" + result);
	}
	
	// ��a��b�η�Ϊ��
	public double powerTwo(double a, double b) {
		// int a = a;
		// int b = b;
		int result = 1;
		// ѭ��b�Σ�����Ϊa
		for (int i = 1; i <= b; i++) {
			result *= a;
		}
		//System.out.println(a + "��" + b + "�η��ǣ�" + result);
		return result;
	}
	
	public void exePower() {
		//����������η�����
		while(true) {
			Scanner sc= new Scanner(System.in);
			System.out.println("�����ڤ�η������Ļ�����");
			int a= sc.nextInt();
			System.out.println("�������ڤ�η�������ڤ������");
			int b= sc.nextInt();
			//����ڤ��������������
			double result= this.powerTwo(a, b);
			//������ص�ֵ
			System.out.println(a + "��" + b + "�η��ǣ�" + result);
			if(a == 2) {
				break;
			}
		}
		
	}
	/*
	 * ���֣�48~57
	 * ��д��ĸ��65~90
	 * Сд��ĸ��97~122
	 */
	//ͳ���ַ������֡���д��ĸ��Сд��ĸ���������
	public void charStat() {
		int Upper= 0;
		int Lower= 0;
		int number= 0;
		int other= 0;
		//abc123jJJ*(
		//String str= "abc123jJJ*(";
		
		//�ַ�������
		Scanner sc= new Scanner(System.in);
		System.out.println("��������Ҫ�жϵ��ַ�����");
		String str= sc.nextLine();
		
		// ѭ�������ַ����������������ж�
		for(int j=0; j<str.length()-1; j++) {
			//System.out.println(str.charAt(i));
			//System.out.println((int)str.charAt(i));
//			int i= (int)str.charAt(j);
			
			char i= str.charAt(j);
			//���ָ���
			if(i>=48 && i<=57) {
				number++;
			//��д��ĸ����
			}else if(i>=65 && i<=90) {
				Upper++;
			//Сд��ĸ����
			}else if(i>=97 && i<=122) {
				Lower++;
			//���������ַ�����
			}else {
				other++;
			}
		}
		//����жϵĽ��
		System.out.println("���ָ����У�"+number);
		System.out.println("��д��ĸ�����У�"+Upper);
		System.out.println("Сд��ĸ�����У�"+Lower);
		System.out.println("���������ַ������У�"+other);
		
	}

	public void guessPrice() {
		//int price1= 44;
		//int price2= 44;
		//����������������
		//����һ
		//System.out.println((int)(Math.random()*200));
		//������
		Random random= new Random();
		int price1= random.nextInt(200);
		System.out.println(price1);
		int i=2;
		while(true) {
			Scanner sc= new Scanner(System.in);
			System.out.println("������������ļ۸�Ϊ��");
			int price2= sc.nextInt();
			if(price1 > price2) {
				System.out.println("�µ���С��");
			}else if(price1 < price2){
				System.out.println("�µ�������");
			}else{
				System.out.println("�µ�������Ϊ��"+price2);
				break;
			}
		}
		
	}
	
	//����ַ����Ƿ�Ϊ��Ч������
	public int checkNumber() {
		//�����ַ���Ϊ��333��-333��-45.4
		/*0~9: 48~57
		 * -:  45
		 * .:  46
		 * �������֣�0333
		 * 			333-333
		 *          888-
		 *          .333
		 *          88.-
		 */
		
		//��ȡ�ַ���
		Scanner sc= new Scanner(System.in);
		System.out.println("������Ҫ�жϵ��ַ�����");
		String str= sc.nextLine();
		//String str= "abc33JJ*((";
		//���ַ��������ж�
		int number= 0;
		int dot= 0;
		int sub= 0;
		int other= 0;
		int enable= 0;
		for(int i=0; i<str.length();i++) {
			//System.out.println(str.charAt(i));
			char cr= str.charAt(i);
			if(cr == 46) {
				dot++;
			}else if(cr == 45) {
				//System.out.println("-");
				sub++;
			}else if(cr>=48 && cr<=57) {
				number++;
			}else {
				other++;
			}
		}
		
		if(dot>=2 | sub>=2 |other>=1) {
			//System.out.println("������Ϊ����Ч����");
			enable++;
		}else {
			if(str.charAt(0) == 48){
				//System.out.println("������Ϊ����Ч����");
				enable++;
			}
			else if(sub==1 && str.charAt(0)!=45 ) {
				//System.out.println("������Ϊ����Ч����");
				enable++;
			}
			
		}
		//���ؽ����������ַ���
		if(enable != 0) {
			return -1;
		}else {
			return 1;
		}
	}
}
