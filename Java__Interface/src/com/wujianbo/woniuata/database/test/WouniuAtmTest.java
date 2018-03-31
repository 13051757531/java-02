package com.wujianbo.woniuata.database.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wujianbo.woniuatm.database.CommonHandler;



public class WouniuAtmTest {
  CommonHandler ch= new CommonHandler();
  
  @DataProvider(name= "checkUserNameTest")//验证用户名是否存在__驱动程序_参数化
  public Object[][] users() {
	// TODO Auto-generated method stub
	  return new Object[][] {
		  {"wujianbo", true},
		  {"dd", false},
		  {"hujiandong", true}
	  };

  }
  @Test(dataProvider= "checkUserNameTest")//验证用户名是否存在__驱动程序
  public void checkUserNameTest(String name, Boolean except) throws Exception {
	  Boolean actual= ch.checkUserName(name);
	  Assert.assertEquals(except, actual);
  }
  
  
  
  @DataProvider(name= "displayBalanceTest")//显示用户余额__驱动程序_参数化
  public Object[][] usersTwo() {
	// TODO Auto-generated method stub
	  return new Object[][] {
		  {"wujianbo", "444443"},
		  {"吴建波", "55555"},
		  {"hujiandong", "44443"}
	  };

  }
  
  //@Test(dataProvider= "displayBalanceTest")
  @Ignore
  public void displayBalanceTest(String name, String Expect) throws Exception {//更新用户余额__驱动程序__参数
	  String actual= ch.displayBalance(name);
	  Assert.assertEquals(Expect, actual);
  }
  
  
  @DataProvider(name= "updateBalance")
  public Object[][] usersThree() {//更新用户余额__驱动程序
		// TODO Auto-generated method stub
		  return new Object[][] {
			  {"wujianbo", "44", "44"},
			  {"吴建波", "33", "33"},
			  {"hujiandong", "77", "77"}
		  };

	  }
  
  @Test(dataProvider= "updateBalance")
  public void updateBalance(String name, String balance,String except) throws Exception {
	  ch.updateBalance(name, balance);
	  String actual= ch.displayBalance(name);
	  Assert.assertEquals(actual, except);
  }
}







