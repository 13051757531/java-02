package com.wujianbo;

import java.util.Scanner;

public class Demo09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo09 demo09= new Demo09();
		demo09.login();

	}

	public void login() {
		String acatualUsername= "woniuxy";
		String acatualPassword= "123456";
		//Scanner sc= new Scanner(System.in);
		//System.out.println("�������û�����");
		//String name= sc.nextLine();
		//System.out.println("�����������룺");
		//String password= sc.nextLine();
		while(true) {
			Scanner sc= new Scanner(System.in);
			System.out.println("�������û�����");
			String name= sc.nextLine();
			if(!name.equals(acatualUsername)) {
				System.out.println("�û����������");
			}else {
				while(true) {
					System.out.println("�����������룺");
					String password= sc.nextLine();
					if(!password.equals(acatualPassword)) {
						System.out.println("�����������");
					}else{
						System.out.println("��ϲ����¼�ɹ�");
						break;
					}
				}
			}
		}
		
		
	}
}
