package www.wujianbothree.woniuatm;

import java.util.Scanner;

public class AccountManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	
	
	//��ѯ���
	public void checkBalance() {
		// TODO Auto-generated method stub
		System.out.println("��ѯ������");
		UserManager um= new UserManager();
		String username= UserManager.username;
		for(int i=0; i<um.uds.length; i++) {
			if(um.uds[i].getNamnes().equals(username)) {
				System.out.println(username+"���ã�");
				System.out.println("�����ϵ�����ǣ�" + um.uds[i].getBalances());
			}
		}
		System.out.println("========================================================================");
		MainUI mu= new MainUI();
		mu.subMenu();

	}
	
	//ת��
	public void transferMoney() {
		// TODO Auto-generated method stub
		// UserManager um2= new UserManager();
		// String username2= um2.username;
		// for(int i=0; i<um2.uds.length; i++){
		// if(um2.uds[i].getNamnes().equals(username2)){
		// System.out.println(um2.uds[i].getBalances());
		// }
		// }
		System.out.println("ת�˲���");
		Scanner sc = new Scanner(System.in);
		System.out.println("���ã���������Ҫת�˵��û�");
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
				System.out.println("��������Ҫת�˵Ľ�");
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
					System.out.println("��ϲ��ת�˳ɹ���");
					System.out.println("�����ڵĽ���ǣ�" + (mybalance + tranbalance));
					System.out.println("�����ڵĽ���ǣ�" + mybalanceOne);
					System.out.println("ת�˽���ǣ�" + tranbalance);
					// AccountManager am= new AccountManager();
					// am.transferMoney();
					MainUI mu = new MainUI();
					mu.subMenu();

				} else {
					System.out.println("�������㣬���ֵ");
					System.out.println("��������ǣ�" + mybalanceOne);
					System.out.println("ת�˽��� �ǣ�" + tranbalance);
					//AccountManager am = new AccountManager();
					//am.transferMoney();
				}

			}
			
		} else {
			System.out.println("��������û������ڣ����������룡");
			// MainUI mu= new MainUI();
			// mu.subMenu();
			AccountManager am = new AccountManager();
			am.transferMoney();
		}

	}
    
	//���
	public void savaMoney() {
		// TODO Auto-generated method stub
    	System.out.println("��Ǯ����");
    	UserManager um= new UserManager();
		String username= UserManager.username;
		for(int i=0; i<um.uds.length; i++) {
			if(um.uds[i].getNamnes().equals(username)) {
				System.out.println(username+"���ã�");
				System.out.println("��������Ҫ��Ǯ�Ľ��");
				Scanner sc= new Scanner(System.in);
				double money2= sc.nextDouble();
				double money1= um.uds[i].getBalances();
				double money3= money1 + money2;
				um.uds[i].setBalances(money3);
				if(money3 >= money1) {
					System.out.println("��ϲ������Ǯ�ɹ�");
				}
				System.out.println("ԭ������ǣ�" + money1);
				System.out.println("��������ǣ�" + um.uds[i].getBalances());
				System.out.println("������ǣ�" + money2);
			}
		}
		System.out.println("========================================================================");
    	MainUI mu= new MainUI();
		mu.subMenu();

	}
    
	//ȡ��
	public void drawMoney() {
		// TODO Auto-generated method stub
    	System.out.println("��Ǯ����");
    	UserManager um= new UserManager();
		String username= UserManager.username;
		for(int i=0; i<um.uds.length; i++) {
			if(um.uds[i].getNamnes().equals(username)) {
				System.out.println(username+"���ã�");
				System.out.println("��������ҪȡǮ�Ľ��");
				Scanner sc= new Scanner(System.in);
				double money2= sc.nextDouble();
				double money1= um.uds[i].getBalances();
				if(money1-money2 < 0 ){
					System.out.println("�Բ��𣡿������㣬���ֵ�������ϵ������" + money1);
				}else {
					double money3= money1 - money2;
					um.uds[i].setBalances(money3);
					//if(money3 >= money1) {
						System.out.println("��ϲ����ȡǮǮ�ɹ�");
					//}
					System.out.println("ԭ������ǣ�" + money1);
					System.out.println("��������ǣ�" + um.uds[i].getBalances());
					System.out.println("ȡ������ǣ�" + money2);
				}
				
			}
		}
		System.out.println("========================================================================");
    	MainUI mu= new MainUI();
		mu.subMenu();
	}
	
	

}


