package com.wujianbo.woniuatm.databasetwo;

import java.util.Scanner;

import com.wujianbo.woniuatm.database.CommonHandler;
import com.wujianbo.woniuatm.database.MainUI;
import com.wujianbo.woniuatm.database.UserManager;

public class UserManager {
	static String localusername;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// ע��
	public void register() throws Exception {
		// TODO Auto-generated method stub
		// String users[] = new String[5];
		// String passes[] = new String[5];
		// double balances[] = new double[5];
		// �û��������롢���绰��email
		Boolean isOk= false;
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û�����");
		String username = sc.next();
	    isOk= new CommonHandler().checkUserName(username);
	    if(!isOk) {
	    	System.out.println("���������룺");
			String password = sc.next();
			System.out.println("�������˺���");
			String balance = sc.next();
			String[] str = { username, password, balance};
			new CommonHandler().insertData(str);
			new MainUI().mainMenu();
	    }else {
	    	System.out.println("���ã����û����Ѿ����ڣ������������û�������");
	    	new UserManager().register();
	    }
		

	}

	// ��¼
	public void login() throws Exception {
		// TODO Auto-generated method stub
		// System.out.println("aaaa");
		Boolean isOk = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û�����");
		String username = sc.next();
		System.out.println("�������û����룺");
		String password = sc.next();
		String[] str = { username, password };
		isOk = new CommonHandler().checkLoginUser(str);
		if (isOk) {
			System.out.println("�û���������������ȷ����");
			UserManager.localusername = username;
			new MainUI().subMenu();
		} else {
			System.out.println("���ã���������û�������������������������");
			new UserManager().login();
		}

	}

}
