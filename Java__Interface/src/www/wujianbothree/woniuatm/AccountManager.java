package www.wujianbothree.woniuatm;

import java.util.Scanner;

public class AccountManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	
	
	//查询余额
	public void checkBalance() {
		// TODO Auto-generated method stub
		System.out.println("查询余额操作");
		UserManager um= new UserManager();
		String username= UserManager.username;
		for(int i=0; i<um.uds.length; i++) {
			if(um.uds[i].getNamnes().equals(username)) {
				System.out.println(username+"您好！");
				System.out.println("您卡上的余额是：" + um.uds[i].getBalances());
			}
		}
		System.out.println("========================================================================");
		MainUI mu= new MainUI();
		mu.subMenu();

	}
	
	//转账
	public void transferMoney() {
		// TODO Auto-generated method stub
		// UserManager um2= new UserManager();
		// String username2= um2.username;
		// for(int i=0; i<um2.uds.length; i++){
		// if(um2.uds[i].getNamnes().equals(username2)){
		// System.out.println(um2.uds[i].getBalances());
		// }
		// }
		System.out.println("转账操作");
		Scanner sc = new Scanner(System.in);
		System.out.println("您好，请输入您要转账的用户");
		String tempname = sc.next();
		UserManager um = new UserManager();
		int otherindex = -1;
		for (int i = 0; i < um.uds.length; i++) {
			if (um.uds[i].getNamnes().equals(tempname)) {
				otherindex = i;

			}
		}
		double mybalanceOne = 0;
		double mybalance= 0;
		double otherbalance = 0;
		int myindex = -1;
		// int otherindex= -1;
		if (otherindex >= 0) {
			while(true) {
				System.out.println("请输入您要转账的金额！");
				double tranbalance = sc.nextDouble();
				String username = um.username;

				for (int i = 0; i < um.uds.length; i++) {
					if (um.uds[i].getNamnes().equals(username)) {
						mybalanceOne = um.uds[i].getBalances();
						myindex = i;
						// System.out.println(i);
					}
				}
				mybalance = mybalanceOne - tranbalance;
				otherbalance= um.uds[otherindex].getBalances();
				otherbalance = otherbalance + tranbalance;
				if (mybalance >= 0) {
					um.uds[myindex].setBalances(mybalance);
					um.uds[otherindex].setBalances(otherbalance);
					System.out.println("恭喜，转账成功！");
					System.out.println("您现在的金额是：" + (mybalance + tranbalance));
					System.out.println("您现在的金额是：" + mybalanceOne);
					System.out.println("转账金额是：" + tranbalance);
					// AccountManager am= new AccountManager();
					// am.transferMoney();
					MainUI mu = new MainUI();
					mu.subMenu();

				} else {
					System.out.println("您的余额不足，请充值");
					System.out.println("您的余额是：" + mybalanceOne);
					System.out.println("转账金额额 是：" + tranbalance);
					//AccountManager am = new AccountManager();
					//am.transferMoney();
				}

			}
			
		} else {
			System.out.println("您输入的用户不存在，请重新输入！");
			// MainUI mu= new MainUI();
			// mu.subMenu();
			AccountManager am = new AccountManager();
			am.transferMoney();
		}

	}
    
	//存款
	public void savaMoney() {
		// TODO Auto-generated method stub
    	System.out.println("存钱操作");
    	UserManager um= new UserManager();
		String username= UserManager.username;
		for(int i=0; i<um.uds.length; i++) {
			if(um.uds[i].getNamnes().equals(username)) {
				System.out.println(username+"您好！");
				System.out.println("请输入您要存钱的金额");
				Scanner sc= new Scanner(System.in);
				double money2= sc.nextDouble();
				double money1= um.uds[i].getBalances();
				double money3= money1 + money2;
				um.uds[i].setBalances(money3);
				if(money3 >= money1) {
					System.out.println("恭喜您，存钱成功");
				}
				System.out.println("原来余额是：" + money1);
				System.out.println("现在余额是：" + um.uds[i].getBalances());
				System.out.println("存款金额是：" + money2);
			}
		}
		System.out.println("========================================================================");
    	MainUI mu= new MainUI();
		mu.subMenu();

	}
    
	//取款
	public void drawMoney() {
		// TODO Auto-generated method stub
    	System.out.println("存钱操作");
    	UserManager um= new UserManager();
		String username= UserManager.username;
		for(int i=0; i<um.uds.length; i++) {
			if(um.uds[i].getNamnes().equals(username)) {
				System.out.println(username+"您好！");
				System.out.println("请输入您要取钱的金额");
				Scanner sc= new Scanner(System.in);
				double money2= sc.nextDouble();
				double money1= um.uds[i].getBalances();
				if(money1-money2 < 0 ){
					System.out.println("对不起！卡上余额不足，请充值！您卡上的余额是" + money1);
				}else {
					double money3= money1 - money2;
					um.uds[i].setBalances(money3);
					//if(money3 >= money1) {
						System.out.println("恭喜您，取钱钱成功");
					//}
					System.out.println("原来余额是：" + money1);
					System.out.println("现在余额是：" + um.uds[i].getBalances());
					System.out.println("取出金额是：" + money2);
				}
				
			}
		}
		System.out.println("========================================================================");
    	MainUI mu= new MainUI();
		mu.subMenu();
	}
	
	

}


