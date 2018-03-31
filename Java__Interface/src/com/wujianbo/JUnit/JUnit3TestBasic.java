package com.wujianbo.JUnit;
import com.wujianbo.compare.*;

import static org.junit.Assert.assertArrayEquals;

import org.junit.experimental.categories.IncludeCategories;

import junit.framework.Assert;
import junit.framework.TestCase;
//import junit.framework.Assert;

public class JUnit3TestBasic extends TestCase {
	
	public void test_ArraySort() {
		// TODO Auto-generated method stub
		Integer[] source= {3, 2, 4};
		Integer[] expect= {2, 3, 4};
		Integer[] actual= new ArrayHandle().arraySort(source);
		assertArrayEquals(expect, actual);
	}
	
	public void test_isNumber() {
		// TODO Auto-generated method stub
		boolean actual= new StringHandle().isNumber("12345");
		assertTrue(actual);

	}
	
	public void test_mainCheck() {
		// TODO Auto-generated method stub
		int actual= new CompareHandle().mainCheck(new Integer[]{3,4,5}, new Integer[]{3,4,5});
		Assert.assertEquals(1, actual);

	}
	
}
