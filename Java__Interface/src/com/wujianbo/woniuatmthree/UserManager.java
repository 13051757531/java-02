package com.wujianbo.woniuatmthree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class UserManager {
	static String localUserName= "ROOT";
	static String localUserPassword;
	static String localUserAccountBalance;
	static String otherUserName;
	static String otherUserAccountBalance;
	static String allData;
	
	
	//注册操作
	public void register() {
		// TODO Auto-generated method stub
		Boolean isOk= false;
		System.out.println("您好，您已经进入注册页面");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String username = sc.next();
		new CommonHandler().ReadText(username, "1");
		if(username.equals(UserManager.localUserName)) {
			System.out.println("请重新输入用户名，该用户已经存在");
			new UserManager().register();
		}else {
			isOk= true;
		}
		while(true) {
			if(isOk) {
				System.out.println("请输入密码：");
				String password = sc.next();
				System.out.println("请输入账号余额：");
				double balance = sc.nextDouble();
				
				String content= username + "," + password + "," + balance + "\r\n";
				new CommonHandler().writeText(content, true);//追加写入数据，true关键字
				//new CommonHandler().writeText(content, isOk);
			}else {
				System.out.println("您好，密码输入错误，请重新输入密码！！");
			}
		}
		
		
        
	}
	
	//用户登录操作
	public void login() {
		// TODO Auto-generated method stub
		Boolean isOk= false;
		Scanner sc= new Scanner(System.in);
		System.out.println("请输入用户名：");
		String username= sc.next();
		
		new CommonHandler().ReadText(username, "1");//读取所有用户数据,1代表对当前用户数据获取
		System.out.println("当前用户"+UserManager.localUserName);
		if(username.equals(UserManager.localUserName)) {
			isOk= true;
		}else {
			System.out.println("您输入的用户名不存在，请重新输入");
			new UserManager().login();
		}
		if(isOk) {
			while(true) {
				System.out.println("请输入密码：");
				String password= sc.next();
				if(password.equals(UserManager.localUserPassword)) {
					System.out.println("登录成功");
					new MainUI().subMenu();
					break;
				}else{
					System.out.println("密码输入错误，请重新输入");
				}
			}
			
		}
		//new MainUI().
	}
	
	
}






























