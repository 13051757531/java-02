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
	
	
	//ע�����
	public void register() {
		// TODO Auto-generated method stub
		Boolean isOk= false;
		System.out.println("���ã����Ѿ�����ע��ҳ��");
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û�����");
		String username = sc.next();
		new CommonHandler().ReadText(username, "1");
		if(username.equals(UserManager.localUserName)) {
			System.out.println("�����������û��������û��Ѿ�����");
			new UserManager().register();
		}else {
			isOk= true;
		}
		while(true) {
			if(isOk) {
				System.out.println("���������룺");
				String password = sc.next();
				System.out.println("�������˺���");
				double balance = sc.nextDouble();
				
				String content= username + "," + password + "," + balance + "\r\n";
				new CommonHandler().writeText(content, true);//׷��д�����ݣ�true�ؼ���
				//new CommonHandler().writeText(content, isOk);
			}else {
				System.out.println("���ã�������������������������룡��");
			}
		}
		
		
        
	}
	
	//�û���¼����
	public void login() {
		// TODO Auto-generated method stub
		Boolean isOk= false;
		Scanner sc= new Scanner(System.in);
		System.out.println("�������û�����");
		String username= sc.next();
		
		new CommonHandler().ReadText(username, "1");//��ȡ�����û�����,1����Ե�ǰ�û����ݻ�ȡ
		System.out.println("��ǰ�û�"+UserManager.localUserName);
		if(username.equals(UserManager.localUserName)) {
			isOk= true;
		}else {
			System.out.println("��������û��������ڣ�����������");
			new UserManager().login();
		}
		if(isOk) {
			while(true) {
				System.out.println("���������룺");
				String password= sc.next();
				if(password.equals(UserManager.localUserPassword)) {
					System.out.println("��¼�ɹ�");
					new MainUI().subMenu();
					break;
				}else{
					System.out.println("���������������������");
				}
			}
			
		}
		//new MainUI().
	}
	
	
}






























