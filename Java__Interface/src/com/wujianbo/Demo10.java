package com.wujianbo;

import java.util.Scanner;

public class Demo10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo10 demo10= new Demo10();
		//System.out.println(demo10.login("woniuxy", "123456"));
		demo10.processNumber();
		

	}
	
	public boolean login(String a, String b) {
			String acatualUsername= "woniuxy";
			String acatualPassword= "123456";
			//String acatualUsername= a;
			//String acatualPassword= b;
			boolean isok= false;
			//Scanner sc= new Scanner(System.in);
			//System.out.println("�������û�����");
			//String name= sc.nextLine();
			String name= a;
			//������û�����ϵͳ�е��û�����ͬ
			if(!name.equals(acatualUsername)) {
				System.out.println("�û����������");
				//this.login(a, b);
			//������û�����ϵͳ�е��û�����ͬ
		} else {
			while (true) {
				//System.out.println("�����������룺");
				//String password = sc.nextLine();
				String password = b;
				if (!password.equals(acatualPassword)) {
					System.out.println("�����������");
				} else {
					System.out.println("��ϲ����¼�ɹ�");
					isok= true;
					break;
				}
			}
		}
		return isok;
			
	}
	
	
	
	public void processNumber() {
		//3456
		Scanner sc= new Scanner(System.in);
		System.out.println("��������Ҫ�жϵ�����:");
		int b= sc.nextInt();
		int a= (int)b;
		//����һ������ÿһλ֮��
		this.caculateNumber(a);
		//���������ж���λ
		this.countNumber(a);
		//�������ֵ������
		this.reverse(a);
	}
	
	
	//����һ������ÿһλ֮��
	private void caculateNumber(int a) {
		int sum= 0;
		int value= 1;
		int temp= a;
		while(value > 0) {
			 int b= a % 10;
			 //System.out.println(b);
			 a= a / 10;
			 value= a;
			sum +=b;
		}
		System.out.println("����"+temp+"����λ���Ϊ��"+sum);
	}
	//���������ж���λ
	private void countNumber(int a){
		String temp= String.valueOf(a);
		int number= temp.length();
		System.out.println("����"+temp+"���У�"+number+"λ");
	}
	//�������ֵ������
	private void reverse(int a) {
		String temp= "";
		int judge=a;
		while(a > 0) {
			int b= a % 10;
			temp +=b;
			a= a / 10;
		}
		System.out.println("����"+judge+"���е����Ľ���ǣ�"+temp);
	}
	
	
}
