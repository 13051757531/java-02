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
	
	// 主菜单：登录前
		public void mainMenu() {
			System.out.println("=====欢迎使用蜗牛ATM无限制取款系统======");
			System.out.println("=====请选择您操作，1：登录  2：注册 3：退出======");
			System.out.println("======================================");

			//UserManager um1 = new UserManager();
			//for (int i = 0; i < um1.uds.length; i++) {
			//	System.out.println("用户是：" + um1.uds[i].getNamnes());
			//}

			while (true) {
				Scanner sc = new Scanner(System.in);
				String option = sc.next();
				Boolean isOk = false;
				if (option.equals("1") || option.equals("2") || option.equals("3")) {
					isOk = true;
				}else {
					System.out.println("请输入您要的具体操作，对应编号是：1或2或3");
				}
				if (isOk) {
					if (option.equals("1")) {                     
					    new UserManager().login("1"); //进入登录界面
						
					} else if (option.equals("2")) {             
						new UserManager().register();// 进入注册界面
						
					} else if (option.equals("3")) {              // 退出当前ATM系统            
						System.out.println("恭喜您已经退出当前系统！！");
						 break;
						// return 0;
						//System.exit(0);
					}
				}else {
					this.mainMenu();
				}
			}

		}
		
		
		
		// 主菜单：登录后
		public void subMenu() {
			// TODO Auto-generated method stub
			System.out.println("=====请输入您的选项======");
			System.out.println("=====1：查询余额   2:转账  3:取款  4:存款  5:返回主菜单======");
			System.out.println("======================================");
			while (true) {
				Scanner sc = new Scanner(System.in);
				String option = sc.next();
				Boolean isOk = false;
				if (option.equals("1") || option.equals("2") || option.equals("3") || option.equals("4") ||option.equals("5")) {
					isOk = true;
				}else {
					System.out.println("请输入您要的具体操作，对应编号是：1或2或3");
				}
				
				if (option.equals("1")) {
					System.out.println("查询余额");
					new AccountManager().checkBalance();;
				} else if (option.equals("2")) {
					System.out.println("转账");
					new AccountManager().transferBalance();
				} else if (option.equals("3")) {
					System.out.println("取款");
					new AccountManager().getBalance();
				} else if (option.equals("4")) {
					System.out.println("存款");
					new AccountManager().saveBalance();
				} else if (option.equals("5")) {
					MainUI mu= new MainUI();
					mu.mainMenu();
				}
			}

		}
	
	
	

}
