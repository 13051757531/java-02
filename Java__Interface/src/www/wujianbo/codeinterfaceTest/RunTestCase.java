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
	//参数化驱动程序注册时验证用户名是否存在
	public void dataCheckUserName() throws Exception {
		// TODO Auto-generated method stub
		DriverTest driverCheck= new DriverTest();
		driverCheck.driverCheckUserName("abc", false, "1.1.1.验证用户是否存在 _反向:");//反向
		driverCheck.driverCheckUserName("abc", false, "1.1.2.验证用户是否存在 _反向:");//反向
		driverCheck.driverCheckUserName("wjb", true, "1.2.1.验证用户是否存在 _正向:");//正向
		driverCheck.driverCheckUserName("吴建波", true, "1.2.2.验证用户是否存在 _正向:");//正向
		driverCheck.driverCheckUserName("hujiandong", true, "1.2.3.验证用户是否存在 _正向:");//正向

	}
	//参数化驱动程序通过用户名获取用户余额
	public void dataGetUserBalance() throws Exception {
		// TODO Auto-generated method stub
		DriverTest driverTest= new DriverTest();
		//driverTest.driverGetBalance("吴建波", 4D, "1.1.1.通过用户名获取用户余额 _反向:");
		//driverTest.driverGetBalance("wjb", 4D, "1.1.1.通过用户名获取用户余额 _反向:");
		driverTest.driverGetBalance("wjb", 98D, "2.1.1.通过用户名获取用户余额 _正向:");
		driverTest.driverGetBalance("吴建波", 55555D, "2.1.2.通过用户名获取用户余额 _正向:");

	}
	
	//参数化驱动程序更新用户余额
	public void dataUpdateBalance() throws Exception {
		// TODO Auto-generated method stub
		DriverTest driverTest= new DriverTest();
		driverTest.driverUpdateBalance("wjb", "999", "3.1.1.通过用户名更新用户余额 _正向:");
		driverTest.driverUpdateBalance("wjb", "44", "3.1.2.通过用户名更新用户余额 _正向:");
		driverTest.driverUpdateBalance("wjb", "99", "3.1.3.通过用户名更新用户余额 _正向:");

	}
	


}

class DriverTest {
	//注册时验证用户名是否存在
	public void driverCheckUserName(String str, Boolean isOK, String conf) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("aa");
		Boolean isOkActual= new com.wujianbo.woniuatm.databasetwo.CommonHandler().checkUserName(str);
        //System.out.println(isOkActual);
		if(isOkActual == isOK ) {
			System.out.println(conf + "用例执行成功!预期结果和实际结果吻合！！");
		}else {
			System.out.print(conf + "用例执行失败！");
			System.out.print("您要查询的用户名是：" + str );
			System.out.print(" ;预期结果：" + isOK);
			System.out.print(" != 实际结果：" + isOkActual);
			System.out.println();
		}
	}
	//通过用户名获取用户余额
	public void driverGetBalance(String username, Double balance, String conf) throws Exception {
		// TODO Auto-generated method stub
		String balanceActual= new com.wujianbo.woniuatm.databasetwo.CommonHandler().displayBalance(username);
		Double balanceActualTwo= Double.parseDouble(balanceActual);
		if(balanceActualTwo.equals(balance)) {
			System.out.println(conf + "用例执行成功！预期结果和实际结果吻合！！");
		}else {
			System.out.print(conf + "用例执行失败！");
			System.out.print("您要查询余额的用户是：" + username);
			System.out.print(" ;预期结果：" + balance);
			System.out.print(" != 实际结果：" + balanceActualTwo);
			System.out.println();
			
		}
	}
	//将用户余额进行更新
	public void driverUpdateBalance(String username, String Money, String conf) throws Exception {
		// TODO Auto-generated method stub
		new com.wujianbo.woniuatm.databasetwo.CommonHandler().updateBalance(username, Money);
		String balanceActual= new com.wujianbo.woniuatm.databasetwo.CommonHandler().displayBalance(username); 
		//balanceActual= "44";
		if(Money.equals(balanceActual)) {
			System.out.println(conf + "用例执行成功！预期结果和实际结果吻合！！");
		}else {
			System.out.print(conf + "用例执行失败！");
			System.out.print("您要更新余额的用户是：" + username);
			System.out.print(" ;预期结果：" + Money);
			System.out.print(" != 实际结果：" + balanceActual);
			System.out.println();
		}
		
	}
	
	//
	//
	
}