package com.wujinabo.woniuatmfour;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class AccountManager {
	
	//查询余额
	public void checkBalance() {
		// TODO Auto-generated method stub
		new CommonHandler().readText();
		for(int i=0; i<CommonHandler.udl.size(); i++) {
			if(CommonHandler.udl.get(i).contains(UserManager.localUserName)) {
				String[] str= CommonHandler.udl.get(i).split(",");
				if(str[0].equals(UserManager.localUserName)) {
					System.out.println("您好，您的余额是："+str[2]);
				}
			}
		}
		
		new MainUI().subMenu();
	}
	
	// 转账
	public void transferBalance() {
		// TODO Auto-generated method stub
		System.out.println("请输入您的要转账的对方账户：");
		Scanner sc = new Scanner(System.in);
		new CommonHandler().readText();
		String username = sc.next();
		Boolean isOk = false;
		String isNumber = "0";
		Boolean isOkTwo = false;
		double tempThree = 0;
		double tempFour = 0;
		double herMoney = 0;
		double myMoney = 0;
		String herName = username;
		String myName = UserManager.localUserName;
		List<String> OtherList = new ArrayList<String>();
		OtherList = CommonHandler.udl;
		for (int i = 0; i < CommonHandler.udl.size(); i++) {// 判断该用户是否存在,确定他的余额
			// System.out.println("这");
			if (CommonHandler.udl.get(i).contains(username)) {
				String[] str = CommonHandler.udl.get(i).split(",");
				if (str[0].equals(username)) {
					tempFour = Double.parseDouble(str[2]);
					isNumber = "1";
					herMoney = Double.parseDouble(str[2]);
					// System.out.println("这二");
					isOk = true;
					break;
					// System.out.println(isOk);
				}
			} else {
				isOk = false;
				;
				isNumber = "0";
			}
		}

		for (int i = 0; i < CommonHandler.udl.size(); i++) {// 确定我的余额
			// System.out.println("这");
			if (CommonHandler.udl.get(i).contains(myName)) {
				String[] str = CommonHandler.udl.get(i).split(",");
				if (str[0].equals(myName)) {
					myMoney = Double.parseDouble(str[2]);
				}
			}
		}

		if (isNumber.equals("1")) {
			while (true) {
				new CommonHandler().readText();
				// Scanner sc=new Scanner(System.in);
				System.out.println("请输入您的转账金额：");
				double tempOne = sc.nextDouble();
				Double tempTwo = Double.parseDouble(UserManager.localUserBalance);
				herMoney = herMoney + tempOne;
				myMoney = myMoney - tempOne;
				if (myMoney >= 0) {
					isOkTwo = true;
					break;
				} else {
					System.out.println("您的存款总共：" + UserManager.localUserBalance + ",余额不足！！");
					System.out.println("请重新输入取款金额");
				}
			}
		} else {
			System.out.println("您好，您输入的用户不存在，请重新输入！！");
			new AccountManager().transferBalance();
		}

		if (isOkTwo) {
			// double myMoney= tempThree;
			// double herMoney= tempFour;
			new CommonHandler().readText();

			String totalcontentTemp = "\r\n"; // 更改她的账户余额
			if (tempThree >= 0) {
				for (int i = 0; i < CommonHandler.udl.size(); i++) { // 改行值
					// System.out.println(CommonHandler.udl.get(i) + "+");
					if (CommonHandler.udl.get(i).contains(herName)) {
						String[] str = CommonHandler.udl.get(i).split(",");
						if (str[0].equals(herName)) {
							str[2] = "," + herMoney;
							String strTwo = str[0] + "," + str[1] + str[2];
							// System.out.println(strTwo + "==");
							CommonHandler.udl.set(i, strTwo);
							// System.out.println(CommonHandler.udl.get(i));
						}

					}

					if (CommonHandler.udl.get(i).contains(myName)) {
						String[] str = CommonHandler.udl.get(i).split(",");
						if (str[0].equals(myName)) {
							str[2] = "," + myMoney;
							String strTwo = str[0] + "," + str[1] + str[2];
							// System.out.println(strTwo + "==");
							CommonHandler.udl.set(i, strTwo);
							// System.out.println(CommonHandler.udl.get(i));
						}

					}

				}
				for (int i = 0; i < CommonHandler.udl.size(); i++) {// 将各行字符串进行连接
					if (i == 0) {
						String contentTemp = ("\n" + CommonHandler.udl.get(i) + "\r\n");
						totalcontentTemp += contentTemp;
					} else {
						String contentTemp = (CommonHandler.udl.get(i) + "\r\n");
						totalcontentTemp += contentTemp;
					}
					// totalcontentTemp += contentTemp;
				}
				// System.out.println(totalcontentTemp);
				new CommonHandler().writeText(totalcontentTemp);
				new CommonHandler().readText();
				new MainUI().subMenu();

			}
		}

	}
		
		
	

	
	
	
	//取款
	public void getBalance() {
		// TODO Auto-generated method stub
		new CommonHandler().readText();
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入您的取款金额：");
		double tempOne= sc.nextDouble();
		Double tempTwo= Double.parseDouble(UserManager.localUserBalance);
		for(int j=0; j<CommonHandler.udl.size(); j++) { //获取当前用户账户余额
			//System.out.println(CommonHandler.udl.get(i) + "+");
			if(CommonHandler.udl.get(j).contains(UserManager.localUserName)) {
				String[] str= CommonHandler.udl.get(j).split(",");
				if(str[0].equals(UserManager.localUserName)) {
					tempTwo= Double.parseDouble(str[2]);
				}
				
			}
		}
		
		//Double tempTwo= Double.parseDouble(UserManager.localUserBalance);
		double tempThree= tempTwo - tempOne;
		String totalcontentTemp= "\r\n";
		if(tempThree >= 0) {
			for(int i=0; i<CommonHandler.udl.size(); i++) { //改行值
				//System.out.println(CommonHandler.udl.get(i) + "+");
				if(CommonHandler.udl.get(i).contains(UserManager.localUserName)) {
					String[] str= CommonHandler.udl.get(i).split(",");
					if(str[0].equals(UserManager.localUserName)) {
						str[2]= "," + tempThree;
						String strTwo= str[0] +","+ str[1] + str[2];
						//System.out.println(strTwo + "==");
						CommonHandler.udl.set(i, strTwo);
						//System.out.println(CommonHandler.udl.get(i));
					}
					
				}
				 
			}
			for(int i=0; i<CommonHandler.udl.size(); i++) {//将各行字符串进行连接
				if(i == 0) {
					String contentTemp = ("\n" + CommonHandler.udl.get(i)+"\r\n");
					totalcontentTemp += contentTemp;
				}else {
					String contentTemp = (CommonHandler.udl.get(i)+"\r\n");
					totalcontentTemp += contentTemp;
				}
			    //totalcontentTemp += contentTemp;
			}
			//System.out.println(totalcontentTemp);
			new CommonHandler().writeText(totalcontentTemp);
			new CommonHandler().readText();
			
			new MainUI().subMenu();
		}else {
			System.out.println("您的存款总共：" + UserManager.localUserBalance + ",余额不足！！");
			System.out.println("请重新输入取款金额");
			new AccountManager().getBalance();
		}
	}
	
	//存款
	public void saveBalance() {
		// TODO Auto-generated method stub
		new CommonHandler().readText();
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入您的存款金额：");
		double tempOne= sc.nextDouble();
		
		Double tempTwo= Double.parseDouble(UserManager.localUserBalance);
		for(int j=0; j<CommonHandler.udl.size(); j++) { //获取当前用户账户余额
			//System.out.println(CommonHandler.udl.get(i) + "+");
			if(CommonHandler.udl.get(j).contains(UserManager.localUserName)) {
				String[] str= CommonHandler.udl.get(j).split(",");
				if(str[0].equals(UserManager.localUserName)) {
					tempTwo= Double.parseDouble(str[2]);
				}
				
			}
		}
		
		//Double tempTwo= Double.parseDouble(UserManager.localUserBalance);
		double tempThree= tempTwo + tempOne;
		String totalcontentTemp= "\r\n";
		if(tempThree >= 0) {
			for(int i=0; i<CommonHandler.udl.size(); i++) { //改行值
				//System.out.println(CommonHandler.udl.get(i) + "+");
				if(CommonHandler.udl.get(i).contains(UserManager.localUserName)) {
					String[] str= CommonHandler.udl.get(i).split(",");
					if(str[0].equals(UserManager.localUserName)) {
						str[2]= "," + tempThree;
						String strTwo= str[0] +","+ str[1] + str[2];
						//System.out.println(strTwo + "==");
						CommonHandler.udl.set(i, strTwo);
						//System.out.println(CommonHandler.udl.get(i));
					}
					
				}
				 
			}
			for(int i=0; i<CommonHandler.udl.size(); i++) {//将各行字符串进行连接
				if(i == 0) {
					String contentTemp = ("\n" + CommonHandler.udl.get(i)+"\r\n");
					totalcontentTemp += contentTemp;
				}else {
					String contentTemp = (CommonHandler.udl.get(i)+"\r\n");
					totalcontentTemp += contentTemp;
				}
			    //totalcontentTemp += contentTemp;
			}
			//System.out.println(totalcontentTemp);
			new CommonHandler().writeText(totalcontentTemp);
			new CommonHandler().readText();
			new MainUI().subMenu();
		}else {
			System.out.println("您的存款总共：" + UserManager.localUserBalance + ",余额不足！！");
			System.out.println("请重新输入取款金额");
			new AccountManager().getBalance();
		}

	}
	
	
	

}
