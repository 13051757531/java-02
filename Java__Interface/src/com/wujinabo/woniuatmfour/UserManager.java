package com.wujinabo.woniuatmfour;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserManager {
	static String localUserName;
	static String localUserPassword;
	static String localUserBalance;
	static String tryUser;

	// 注册操作
	public void register() {
		// TODO Auto-generated method stub
		Boolean isOk= false;
		System.out.println("======正在进行写操作");// 获取用户信息
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String username = sc.next();
		new CommonHandler().readText();
		//System.out.println(CommonHandler.udl.size());
		
		if(CommonHandler.index.equals("1")) {
			for(int i=0; i<CommonHandler.udl.size(); i++) {//判断该用户是否存在
				if(CommonHandler.udl.get(i).contains(username)) {
					String[] str= CommonHandler.udl.get(i).split(",");
					if(str[0].equals(username)) {
						System.out.println("您好，您输入的用户名已经存在，请重新输入：");
						new UserManager().register();
					}
				}else {
					isOk= true;
				}
			}
		}else {
			isOk= true;
		}
		
		
		if(isOk) {//该用户不存在时，进行下面的写入
			System.out.println("请输入您账号密码：");
			String password = sc.next();
			System.out.println("请输入账户余额：");
			String balance = sc.next();
	        
			String rootDir = System.getProperty("user.dir");// 获取存储用户信息的文本文件
			String dataDir = rootDir + "\\data\\userdata.txt";
			// System.out.println(dataDir);
			try {
				File file = new File(dataDir); // 写入数据操作
				OutputStream in = new FileOutputStream(file, true);
				OutputStreamWriter writer = new OutputStreamWriter(in, "GBK");
				BufferedWriter bw = new BufferedWriter(writer);
				// String content="这是缓冲区写入的内容！！\r\n";
				String contentUpdate = "\n"+username + "," + password + "," + balance + "\r\n";// 插入数据格式化操作
				bw.write(contentUpdate, 0, contentUpdate.length());
				bw.flush();
				bw.close();
				writer.close();
				in.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("======成功完成写操作");
			new MainUI().mainMenu();
		}
		
	

	}

	// 登录操作
	public void login(String option) {
		// TODO Auto-generated method stub
		System.out.println("======您好，欢迎进行登录操作");
		System.out.println("请输入您的用户名：");
		Scanner sc = new Scanner(System.in);
		String username = sc.next();
		UserManager.tryUser= username;
		
		Boolean isOk = false;
		List<String> udl = new ArrayList<String>();// 存放行字符串的列表数组
		String rootDir = System.getProperty("user.dir");// 存放数据的文本文件
		String dataDir = rootDir + "\\data\\userdata.txt";
		// System.out.println("卡");
		try {
			File file = new File(dataDir);
			InputStream in = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(in, "GBK");
			//BufferedReader br = new BufferedReader(reader);
			String line= null;
			int temp;
			while ((temp=reader.read()) != -1) {
				if((char)temp != '\r') {
					//System.out.print((char)temp);
					line += (char)temp;
				}
				//line = (String) br.readLine();
				//System.out.println(line);
				//udl.add(line);
			}
			//br.close();
			reader.close();
			in.close();
			//System.out.println(line);
			String[] uds= line.split("\n");
			for(int i=0; i<uds.length; i++) {
				if(uds[i].contains(",")) {
					udl.add(uds[i]);
					//System.out.println(uds[i]);
				}	
			}
			// System.out.println(line+"取值");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i<udl.size(); i++) {
			if(udl.get(i).contains(username)){
				isOk= true;
			}
		}
		
		String[] temp= new String[3];
		if(option.equals("1")) { //获取当前用户名，账户余额
			for(int i=0; i<udl.size(); i++) {
				temp= udl.get(i).split(",");
				if(temp[0].equals(UserManager.tryUser)) {
					isOk= true;
					UserManager.localUserName= temp[0];
					UserManager.localUserBalance= temp[2];
					UserManager.localUserPassword= temp[1];
				}
			}
			
		}else if(option.equals("2")) { //获取转账用户名，账户余额
			for(int i=0; i<udl.size(); i++) {
				temp= udl.get(i).split(",");
			}
		}else if (option.equals("3")) { //获取所有用户信息
			
		}
		
		if(isOk) {//进行用户名判断，当前用户登录判断
			while(true) {
				System.out.println("请输入您的密码：");
				String password= sc.next();
				if(password.equals(UserManager.localUserPassword)) {
					System.out.println("恭喜，登录成功");
					new MainUI().subMenu();
				}else {
					System.out.println("密码错误，请重新输入密码！！");
				}
			}
		
		}else {
			System.out.println("对不起，您的用户名输入错误，请重新输入：");
			this.login("1");
		}
		
		
		//System.out.println(isOk);
	}
	// 记事本写入操作
	// 记事本读取操作

}
