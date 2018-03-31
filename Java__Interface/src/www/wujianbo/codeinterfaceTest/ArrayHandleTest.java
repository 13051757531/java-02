package www.wujianbo.codeinterfaceTest;



import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.wujianbo.compare.ArrayHandle;

public class ArrayHandleTest {
	ArrayHandle arrayHandle= new ArrayHandle();
	
	@BeforeMethod
	private void setUp() {
		// TODO Auto-generated method stub
		System.out.println("测试用例开始执行");

	}
	@AfterMethod
	private void tearDown() {
		// TODO Auto-generated method stub
		System.out.println("测试用例开始执行");

	}
	
	@Test(groups= {"group1", "group2"})
	private void arraySortTest() {
		// TODO Auto-generated method stub
		Integer[] source= new Integer[]{1, 2, 3, 4, 6, 5};
		Integer[] expect= {1, 2, 3, 4, 5, 6};
		//assert.assertFalse(arrayHandle.arrayCompare(source, expect));
		Integer[] actual= arrayHandle.arraySort(source);
		//assert.assertEquals(actual, expect);
		Assert.assertEquals(actual, expect);
	}
	
	@Test(groups= {"group2", "group3"})
	private void arrayCompareTest() {
		// TODO Auto-generated method stub
		Integer[] source= new Integer[]{1, 2, 3, 4, 6, 5};
		Integer[] expect= {1, 2, 3, 4, 5, 6};
		Assert.assertFalse(arrayHandle.arrayCompare(source, expect));

	}

}
