package com.wujianbo.woniuatmthree;

import java.util.Scanner;

public class AccountManager {

	// ��ѯ�˻����
	public void checkBalance() {
		// TODO Auto-generated method stub
		String username= UserManager.localUserName;
		new CommonHandler().ReadText(username, "1");
		System.out.println("�����˻�����ǣ�"+UserManager.localUserAccountBalance);
		new MainUI().subMenu();
	}

	// ת�˲���
	public void transferBalance() {
		// TODO Auto-generated method stub

	}

	// ȡ�����
	public void getBalance() {
		// TODO Auto-generated method stub
		Boolean isOk= false;
		String username= UserManager.localUserName;
		new CommonHandler().ReadText(username, "1");
		String oldBalance= UserManager.localUserAccountBalance;
		double oldBalanceTwo= Double.parseDouble(oldBalance);
	    //System.out.println(oldBalanceTwo);
		Scanner sc= new Scanner(System.in);
		System.out.println("����,����������ȡ���");
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
        	//new CommonHandler().writeText(content, false);//����ȫ����д
    		//System.out.println("���ã�ȡ��ɹ�");
    		new MainUI().subMenu();
        }else {
        	System.out.println("������Ľ��̫��");
        	System.out.println("���˻����Ϊ"+oldBalance+",������������");
        	new AccountManager().getBalance();
        }
	}

	// ������
	public void saveBalance() {
		// TODO Auto-generated method stub
		String username= UserManager.localUserName;
		new CommonHandler().ReadText(username, "3");
		String oldBalance= UserManager.localUserAccountBalance;
		double oldBalanceTwo= Double.parseDouble(oldBalance);
		//System.out.println(UserManager.allData);
		Scanner sc= new Scanner(System.in);
		System.out.println("���ã��ѽ���������������������Ľ�");
		String usernameF= new UserManager().localUserName;
		double Balance= sc.nextDouble();
		double newBalance= Balance + oldBalanceTwo;
		String data= UserManager.allData;
		
		String content= new CommonHandler().processData(usernameF, newBalance,  data);
		//System.err.println(content);
		new CommonHandler().writeText(content, false);//����ȫ����д
		System.out.println("���ã����ɹ�");
		new MainUI().subMenu();

	}

}
