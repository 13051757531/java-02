package com.wujinabo.woniuatmfour;
import java.util.Scanner;
import java.util.jar.Manifest;


import java.sql.Connection;


public class MainUI {
	//static String tryUser;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainUI mainui= new MainUI();
		mainui.mainMenu();
	}
	
	// ���˵�����¼ǰ
		public void mainMenu() {
			System.out.println("=====��ӭʹ����ţATM������ȡ��ϵͳ======");
			System.out.println("=====��ѡ����������1����¼  2��ע�� 3���˳�======");
			System.out.println("======================================");

			//UserManager um1 = new UserManager();
			//for (int i = 0; i < um1.uds.length; i++) {
			//	System.out.println("�û��ǣ�" + um1.uds[i].getNamnes());
			//}

			while (true) {
				Scanner sc = new Scanner(System.in);
				String option = sc.next();
				Boolean isOk = false;
				if (option.equals("1") || option.equals("2") || option.equals("3")) {
					isOk = true;
				}else {
					System.out.println("��������Ҫ�ľ����������Ӧ����ǣ�1��2��3");
				}
				if (isOk) {
					if (option.equals("1")) {                     
					    new UserManager().login("1"); //�����¼����
						
					} else if (option.equals("2")) {             
						new UserManager().register();// ����ע�����
						
					} else if (option.equals("3")) {              // �˳���ǰATMϵͳ            
						System.out.println("��ϲ���Ѿ��˳���ǰϵͳ����");
						 break;
						// return 0;
						//System.exit(0);
					}
				}else {
					this.mainMenu();
				}
			}

		}
		
		
		
		// ���˵�����¼��
		public void subMenu() {
			// TODO Auto-generated method stub
			System.out.println("=====����������ѡ��======");
			System.out.println("=====1����ѯ���   2:ת��  3:ȡ��  4:���  5:�������˵�======");
			System.out.println("======================================");
			while (true) {
				Scanner sc = new Scanner(System.in);
				String option = sc.next();
				Boolean isOk = false;
				if (option.equals("1") || option.equals("2") || option.equals("3") || option.equals("4") ||option.equals("5")) {
					isOk = true;
				}else {
					System.out.println("��������Ҫ�ľ����������Ӧ����ǣ�1��2��3");
				}
				
				if (option.equals("1")) {
					System.out.println("��ѯ���");
					new AccountManager().checkBalance();;
				} else if (option.equals("2")) {
					System.out.println("ת��");
					new AccountManager().transferBalance();
				} else if (option.equals("3")) {
					System.out.println("ȡ��");
					new AccountManager().getBalance();
				} else if (option.equals("4")) {
					System.out.println("���");
					new AccountManager().saveBalance();
				} else if (option.equals("5")) {
					MainUI mu= new MainUI();
					mu.mainMenu();
				}
			}

		}
	
	
	

}
