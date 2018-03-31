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

	// 注册
	public void register() throws Exception {
		// TODO Auto-generated method stub
		// String users[] = new String[5];
		// String passes[] = new String[5];
		// double balances[] = new double[5];
		// 用户名、密码、余额、电话、email
		Boolean isOk= false;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String username = sc.next();
	    isOk= new CommonHandler().checkUserName(username);
	    if(!isOk) {
	    	System.out.println("请输入密码：");
			String password = sc.next();
			System.out.println("请输入账号余额：");
			String balance = sc.next();
			String[] str = { username, password, balance};
			new CommonHandler().insertData(str);
			new MainUI().mainMenu();
	    }else {
	    	System.out.println("您好，该用户名已经存在，请重新输入用户名！！");
	    	new UserManager().register();
	    }
		

	}

	// 登录
	public void login() throws Exception {
		// TODO Auto-generated method stub
		// System.out.println("aaaa");
		Boolean isOk = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String username = sc.next();
		System.out.println("请输入用户密码：");
		String password = sc.next();
		String[] str = { username, password };
		isOk = new CommonHandler().checkLoginUser(str);
		if (isOk) {
			System.out.println("用户名和密码输入正确！！");
			UserManager.localusername = username;
			new MainUI().subMenu();
		} else {
			System.out.println("您好，您输入的用户名或密码错误，请重新输入操作");
			new UserManager().login();
		}

	}

}
