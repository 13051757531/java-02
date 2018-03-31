package com.wujianbo.woniuatmthree;

import java.util.Scanner;

public class AccountManager {

	// 查询账户余额
	public void checkBalance() {
		// TODO Auto-generated method stub
		String username= UserManager.localUserName;
		new CommonHandler().ReadText(username, "1");
		System.out.println("您的账户余额是："+UserManager.localUserAccountBalance);
		new MainUI().subMenu();
	}

	// 转账操作
	public void transferBalance() {
		// TODO Auto-generated method stub

	}

	// 取款操作
	public void getBalance() {
		// TODO Auto-generated method stub
		Boolean isOk= false;
		String username= UserManager.localUserName;
		new CommonHandler().ReadText(username, "1");
		String oldBalance= UserManager.localUserAccountBalance;
		double oldBalanceTwo= Double.parseDouble(oldBalance);
	    //System.out.println(oldBalanceTwo);
		Scanner sc= new Scanner(System.in);
		System.out.println("您好,请输入您的取款金额：");
		String usernameF= new UserManager().localUserName;
		double Balance= sc.nextDouble();
		double newBalance= oldBalanceTwo - Balance;
		System.out.println(newBalance);
		if(newBalance > 0) {
			isOk= true;	
		}
        if(isOk){
        	String data= UserManager.allData;
        	String content= new CommonHandler().processData(usernameF, newBalance,  data);
        	//new CommonHandler().writeText(content, false);//数据全部重写
    		//System.out.println("您好，取款成功");
    		new MainUI().subMenu();
        }else {
        	System.out.println("您输入的金额太大！");
        	System.out.println("您账户余额为"+oldBalance+",请重新输入金额");
        	new AccountManager().getBalance();
        }
	}

	// 存款操作
	public void saveBalance() {
		// TODO Auto-generated method stub
		String username= UserManager.localUserName;
		new CommonHandler().ReadText(username, "3");
		String oldBalance= UserManager.localUserAccountBalance;
		double oldBalanceTwo= Double.parseDouble(oldBalance);
		//System.out.println(UserManager.allData);
		Scanner sc= new Scanner(System.in);
		System.out.println("您好，已进入存款操作，请输入您存款的金额：");
		String usernameF= new UserManager().localUserName;
		double Balance= sc.nextDouble();
		double newBalance= Balance + oldBalanceTwo;
		String data= UserManager.allData;
		
		String content= new CommonHandler().processData(usernameF, newBalance,  data);
		//System.err.println(content);
		new CommonHandler().writeText(content, false);//数据全部重写
		System.out.println("您好，存款成功");
		new MainUI().subMenu();

	}

}
