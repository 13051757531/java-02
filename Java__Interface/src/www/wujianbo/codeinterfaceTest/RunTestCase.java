package www.wujianbo.codeinterfaceTest;

import javax.xml.crypto.Data;

import com.wujianbo.woniuatm.databasetwo.*;


public class RunTestCase {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		RunTestCase runTestCase= new RunTestCase();
		DataTest datatest= new DataTest();
		//datatest.dataCheckUserName();
		//datatest.dataGetUserBalance();
		datatest.dataUpdateBalance();
		

	}

}


class DataTest {
	//��������������ע��ʱ��֤�û����Ƿ����
	public void dataCheckUserName() throws Exception {
		// TODO Auto-generated method stub
		DriverTest driverCheck= new DriverTest();
		driverCheck.driverCheckUserName("abc", false, "1.1.1.��֤�û��Ƿ���� _����:");//����
		driverCheck.driverCheckUserName("abc", false, "1.1.2.��֤�û��Ƿ���� _����:");//����
		driverCheck.driverCheckUserName("wjb", true, "1.2.1.��֤�û��Ƿ���� _����:");//����
		driverCheck.driverCheckUserName("�⽨��", true, "1.2.2.��֤�û��Ƿ���� _����:");//����
		driverCheck.driverCheckUserName("hujiandong", true, "1.2.3.��֤�û��Ƿ���� _����:");//����

	}
	//��������������ͨ���û�����ȡ�û����
	public void dataGetUserBalance() throws Exception {
		// TODO Auto-generated method stub
		DriverTest driverTest= new DriverTest();
		//driverTest.driverGetBalance("�⽨��", 4D, "1.1.1.ͨ���û�����ȡ�û���� _����:");
		//driverTest.driverGetBalance("wjb", 4D, "1.1.1.ͨ���û�����ȡ�û���� _����:");
		driverTest.driverGetBalance("wjb", 98D, "2.1.1.ͨ���û�����ȡ�û���� _����:");
		driverTest.driverGetBalance("�⽨��", 55555D, "2.1.2.ͨ���û�����ȡ�û���� _����:");

	}
	
	//������������������û����
	public void dataUpdateBalance() throws Exception {
		// TODO Auto-generated method stub
		DriverTest driverTest= new DriverTest();
		driverTest.driverUpdateBalance("wjb", "999", "3.1.1.ͨ���û��������û���� _����:");
		driverTest.driverUpdateBalance("wjb", "44", "3.1.2.ͨ���û��������û���� _����:");
		driverTest.driverUpdateBalance("wjb", "99", "3.1.3.ͨ���û��������û���� _����:");

	}
	


}

class DriverTest {
	//ע��ʱ��֤�û����Ƿ����
	public void driverCheckUserName(String str, Boolean isOK, String conf) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("aa");
		Boolean isOkActual= new com.wujianbo.woniuatm.databasetwo.CommonHandler().checkUserName(str);
        //System.out.println(isOkActual);
		if(isOkActual == isOK ) {
			System.out.println(conf + "����ִ�гɹ�!Ԥ�ڽ����ʵ�ʽ���Ǻϣ���");
		}else {
			System.out.print(conf + "����ִ��ʧ�ܣ�");
			System.out.print("��Ҫ��ѯ���û����ǣ�" + str );
			System.out.print(" ;Ԥ�ڽ����" + isOK);
			System.out.print(" != ʵ�ʽ����" + isOkActual);
			System.out.println();
		}
	}
	//ͨ���û�����ȡ�û����
	public void driverGetBalance(String username, Double balance, String conf) throws Exception {
		// TODO Auto-generated method stub
		String balanceActual= new com.wujianbo.woniuatm.databasetwo.CommonHandler().displayBalance(username);
		Double balanceActualTwo= Double.parseDouble(balanceActual);
		if(balanceActualTwo.equals(balance)) {
			System.out.println(conf + "����ִ�гɹ���Ԥ�ڽ����ʵ�ʽ���Ǻϣ���");
		}else {
			System.out.print(conf + "����ִ��ʧ�ܣ�");
			System.out.print("��Ҫ��ѯ�����û��ǣ�" + username);
			System.out.print(" ;Ԥ�ڽ����" + balance);
			System.out.print(" != ʵ�ʽ����" + balanceActualTwo);
			System.out.println();
			
		}
	}
	//���û������и���
	public void driverUpdateBalance(String username, String Money, String conf) throws Exception {
		// TODO Auto-generated method stub
		new com.wujianbo.woniuatm.databasetwo.CommonHandler().updateBalance(username, Money);
		String balanceActual= new com.wujianbo.woniuatm.databasetwo.CommonHandler().displayBalance(username); 
		//balanceActual= "44";
		if(Money.equals(balanceActual)) {
			System.out.println(conf + "����ִ�гɹ���Ԥ�ڽ����ʵ�ʽ���Ǻϣ���");
		}else {
			System.out.print(conf + "����ִ��ʧ�ܣ�");
			System.out.print("��Ҫ���������û��ǣ�" + username);
			System.out.print(" ;Ԥ�ڽ����" + Money);
			System.out.print(" != ʵ�ʽ����" + balanceActual);
			System.out.println();
		}
		
	}
	
	//
	//
	
}