package com.wujianbo.JUnit;

import static org.junit.Assert.assertArrayEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.wujianbo.compare.ArrayHandle;
import com.wujianbo.compare.CompareHandle;
import com.wujianbo.compare.StringHandle;

import junit.framework.Assert;

//@FixMethodOrder(MethodSorters.JVM)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JUnit4TestBasic {
	@BeforeClass
	static public void initClass() {
		// TODO Auto-generated method stub
		System.out.println("测试类正在被初始化....");
	}
	@AfterClass
	static public void endClass() {
		// TODO Auto-generated method stub
		System.out.println("测试类正在被释放.....");
	}
	@Before
	public void initTest() {
		// TODO Auto-generated method stub
		System.out.println("测试驱动驱动程序正在被初始。。。。。");
	}
	@After
	public void endTest() {
		// TODO Auto-generated method stub
		System.out.println("测试驱动驱动程序正在被释放。。。。。");

	}
	
	@Test
	public void test_ArraySort() {
		// TODO Auto-generated method stub
		Integer[] source= {3, 2, 4};
		Integer[] expect= {2, 3, 4};
		Integer[] actual= new ArrayHandle().arraySort(source);
		assertArrayEquals(expect, actual);
	}
	@Test
	public void test_isNumber() {
		// TODO Auto-generated method stub
		boolean actual= new StringHandle().isNumber("12345");
		//assertTrue(actual);
		Assert.assertTrue(actual);

	}
	
	@Ignore
	public void test_mainCheck() {
		// TODO Auto-generated method stub
		int actual= new CompareHandle().mainCheck(new Integer[]{3,4,5}, new Integer[]{3,4,5});
		Assert.assertEquals(1, actual);

	}
	
	@Test(timeout= 9000)
	public void TimeOut() throws InterruptedException {
		// TODO Auto-generated method stub
		long statTime= System.currentTimeMillis();
		Thread.sleep(4000);
		long endTime= System.currentTimeMillis();
		if((endTime-statTime) <= 3000) {
			System.out.println("测试成功");
		}else {
			System.out.println("测试失败");	
		}
		//Assert.assertTrue(true);
	}
	@Test(expected= ArithmeticException.class)
	public void testException() {
		// TODO Auto-generated method stub
		int i= 8;
		i= i / 0;
		System.out.println(i);

	}
	
}
