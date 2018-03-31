package com.wujianbo.woniuatm.databasetwo;

import java.util.Scanner;

import com.wujianbo.woniuatm.database.AccountManager;
import com.wujianbo.woniuatm.database.CommonHandler;
import com.wujianbo.woniuatm.database.MainUI;
import com.wujianbo.woniuatm.database.UserManager;

public class AccountManager {

	// 查询账户余额
	public void checkBalance() throws Exception {
		String username= UserManager.localusername;
		String searchResult= new CommonHandler().displayBalance(username);
		System.out.println("当前余额是："+searchResult);
		new MainUI().subMenu();
	}

	// 转账操作
	public void transferBalance() throws Exception {
		Boolean isOK= false;
		Boolean isOKTwo= false;
		System.out.println("请输入您要转账的用户：");
		Scanner sc= new Scanner(System.in);
		String toUsernName= sc.next();
		isOK= new CommonHandler().checkUserName(toUsernName);
		if(!isOK) {
			System.out.println("您好，用户不存在,请重新输入用户名！！");
			new AccountManager().transferBalance();
			
		}else {
			System.out.println("您好，用户存在");
			while(true) {
				System.out.println("请输入您的转账金额：");
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
					System.out.println("对不起您的余额不足为："+oldBalanceTwo);
					//new AccountManager().getBalance();
				}
			}
		
		}
		
	
	}

	// 取款操作
	public void getBalance() throws Exception {
		String username= UserManager.localusername;
		String oldBalance= new CommonHandler().displayBalance(username);
		Float oldBalanceTwo= Float.parseFloat(oldBalance);
		
		System.out.println("请输入取款金额：");
		Scanner sc= new Scanner(System.in);
		Float balance= sc.nextFloat();
		Float newBalance= oldBalanceTwo - balance;
		String newBalanceTwo= newBalance + "";
		if(newBalance >= 0){
			new CommonHandler().updateBalance(username, newBalanceTwo);
			new MainUI().subMenu();
		}else {
			System.out.println("对不起您的余额不足为："+oldBalanceTwo);
			new AccountManager().getBalance();
		}
	}

	// 存款操作
	public void saveBalance() throws Exception {
		// TODO Auto-generated method stub
		String username= UserManager.localusername;
		System.out.println("请输入存款金额：");
		Scanner sc= new Scanner(System.in);
		String balance= sc.next();
		String oldBalance= new CommonHandler().displayBalance(username);
		Float oldBalanceTwo= Float.parseFloat(oldBalance);
		balance= Float.parseFloat(balance) + oldBalanceTwo+"";
		new CommonHandler().updateBalance(username, balance);
		new MainUI().subMenu();
	}

}
