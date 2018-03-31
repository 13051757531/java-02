package com.wujianbo.woniuatm.databasetwo;

import java.util.Scanner;

import com.wujianbo.woniuatm.database.AccountManager;
import com.wujianbo.woniuatm.database.CommonHandler;
import com.wujianbo.woniuatm.database.MainUI;
import com.wujianbo.woniuatm.database.UserManager;

public class AccountManager {

	// ��ѯ�˻����
	public void checkBalance() throws Exception {
		String username= UserManager.localusername;
		String searchResult= new CommonHandler().displayBalance(username);
		System.out.println("��ǰ����ǣ�"+searchResult);
		new MainUI().subMenu();
	}

	// ת�˲���
	public void transferBalance() throws Exception {
		Boolean isOK= false;
		Boolean isOKTwo= false;
		System.out.println("��������Ҫת�˵��û���");
		Scanner sc= new Scanner(System.in);
		String toUsernName= sc.next();
		isOK= new CommonHandler().checkUserName(toUsernName);
		if(!isOK) {
			System.out.println("���ã��û�������,�����������û�������");
			new AccountManager().transferBalance();
			
		}else {
			System.out.println("���ã��û�����");
			while(true) {
				System.out.println("����������ת�˽�");
				Float tranBalance= sc.nextFloat();
				String username= UserManager.localusername;
				String oldBalance= new CommonHandler().displayBalance(username);
				Float oldBalanceTwo= Float.parseFloat(oldBalance);
				Float myNewBalance= oldBalanceTwo - tranBalance;
				String newBalanceTwo= myNewBalance + "";
				if(myNewBalance >= 0){
					new CommonHandler().updateBalance(username, newBalanceTwo);
					//new MainUI().subMenu();
					String oldTOBalance= new CommonHandler().displayBalance(toUsernName);
					Float oldTOBalanceTwo= Float.parseFloat(oldTOBalance);
					Float toNewBalance= oldTOBalanceTwo + tranBalance;
					String toNewBalanceTwo= toNewBalance + "";
					new CommonHandler().updateBalance(toUsernName, toNewBalanceTwo);
					new MainUI().subMenu();
					
				}else {
					System.out.println("�Բ�����������Ϊ��"+oldBalanceTwo);
					//new AccountManager().getBalance();
				}
			}
		
		}
		
	
	}

	// ȡ�����
	public void getBalance() throws Exception {
		String username= UserManager.localusername;
		String oldBalance= new CommonHandler().displayBalance(username);
		Float oldBalanceTwo= Float.parseFloat(oldBalance);
		
		System.out.println("������ȡ���");
		Scanner sc= new Scanner(System.in);
		Float balance= sc.nextFloat();
		Float newBalance= oldBalanceTwo - balance;
		String newBalanceTwo= newBalance + "";
		if(newBalance >= 0){
			new CommonHandler().updateBalance(username, newBalanceTwo);
			new MainUI().subMenu();
		}else {
			System.out.println("�Բ�����������Ϊ��"+oldBalanceTwo);
			new AccountManager().getBalance();
		}
	}

	// ������
	public void saveBalance() throws Exception {
		// TODO Auto-generated method stub
		String username= UserManager.localusername;
		System.out.println("���������");
		Scanner sc= new Scanner(System.in);
		String balance= sc.next();
		String oldBalance= new CommonHandler().displayBalance(username);
		Float oldBalanceTwo= Float.parseFloat(oldBalance);
		balance= Float.parseFloat(balance) + oldBalanceTwo+"";
		new CommonHandler().updateBalance(username, balance);
		new MainUI().subMenu();
	}

}
