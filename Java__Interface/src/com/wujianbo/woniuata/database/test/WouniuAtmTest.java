package com.wujianbo.woniuata.database.test;

import org.junit.Assert;
import org.junit.Ignore;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wujianbo.woniuatm.database.CommonHandler;



public class WouniuAtmTest {
  CommonHandler ch= new CommonHandler();
  
  @DataProvider(name= "checkUserNameTest")//��֤�û����Ƿ����__��������_������
  public Object[][] users() {
	// TODO Auto-generated method stub
	  return new Object[][] {
		  {"wujianbo", true},
		  {"dd", false},
		  {"hujiandong", true}
	  };

  }
  @Test(dataProvider= "checkUserNameTest")//��֤�û����Ƿ����__��������
  public void checkUserNameTest(String name, Boolean except) throws Exception {
	  Boolean actual= ch.checkUserName(name);
	  Assert.assertEquals(except, actual);
  }
  
  
  
  @DataProvider(name= "displayBalanceTest")//��ʾ�û����__��������_������
  public Object[][] usersTwo() {
	// TODO Auto-generated method stub
	  return new Object[][] {
		  {"wujianbo", "444443"},
		  {"�⽨��", "55555"},
		  {"hujiandong", "44443"}
	  };

  }
  
  //@Test(dataProvider= "displayBalanceTest")
  @Ignore
  public void displayBalanceTest(String name, String Expect) throws Exception {//�����û����__��������__����
	  String actual= ch.displayBalance(name);
	  Assert.assertEquals(Expect, actual);
  }
  
  
  @DataProvider(name= "updateBalance")
  public Object[][] usersThree() {//�����û����__��������
		// TODO Auto-generated method stub
		  return new Object[][] {
			  {"wujianbo", "44", "44"},
			  {"�⽨��", "33", "33"},
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







