package com.wujianbo.compare.test;

import java.util.ArrayList;
import java.util.List;

import com.wujianbo.compare.*;

public class ArrayCompareTest {
	ArrayHandle ah = null;
	CompareHandle ch = null;
	StringHandle sh = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayCompareTest arrayCompareTest = new ArrayCompareTest();
		arrayCompareTest.init();
		Integer[] source = { 3, 4, 5, 2, 7 };
		Integer[] expect = { 2, 3, 4, 5, 7 };
		 //arrayCompareTest.testArraySort(source, expect, "testArraySort");
		 //arrayCompareTest.testmainCheck(new Integer[]{3,4,5}, new Integer[]{3,4,5}, 1, "testmainCheck");
		 //arrayCompareTest.testmainCheck(new Integer[]{3,4,5}, new Integer[]{3,4,9}, 3, "testmainCheck");
		 //arrayCompareTest.testmainCheck(new Integer[]{4,3,5}, new Integer[]{3,4,5}, 2, "testmainCheck");
		 //arrayCompareTest.testSplitString("3,4,5,6,7", ",", new Integer[]{3,4,5,6,7}, "testSplitString");
		 //arrayCompareTest.testSplitString("3 4 5 6 7", " ", new Integer[]{3,4,5,6,7}, "testSplitString");
		 //arrayCompareTest.testSplitString("3=4=5=6=7", "=", new Integer[]{3,4,5,6,7}, "testSplitString");
		 
		// Object[][] object= {
		//		 	{"3,4,5,6,7", ",", new Integer[]{3,4,5,6,7}, "testSplitString"},
		//		 	{"3 4 5 6 7", " ", new Integer[]{3,4,5,6,7}, "testSplitString"},
		//		 	{"3=4=5=6=7", "=", new Integer[]{3,4,5,6,7}, "testSplitString"}
		//		 };
		 //int i=1;
		 //arrayCompareTest.testSplitString(object[i][0], object[i][1], object[i][2], object[i][3]);	
		 //for(int i=0; i<object.length; i++) {
		 //	 arrayCompareTest.testSplitString((String)object[i][0], (String)object[i][1], (Integer[])object[i][2], (String)object[i][3]);	
		 //}
		
		List<Object[]> testData= new ArrayList<Object[]>(); 
		Object[] objectOne= {"3,4,5,6,7", ",", new Integer[]{3,4,5,6,7}, "testSplitString"};
		testData.add(objectOne);
		Object[] objectTwo= {"3 4 5 6 7", " ", new Integer[]{3,4,5,6,7}, "testSplitString"};
		testData.add(objectTwo);
		for(int i=0; i< testData.size(); i++) {
			arrayCompareTest.testSplitString((String)testData.get(i)[0], (String)testData.get(i)[1], (Integer[])testData.get(i)[2], (String)testData.get(i)[3]);
		}
	}

	private void init() {
		// TODO Auto-generated method stub
		ah = new ArrayHandle();
		ch = new CompareHandle();
		sh = new StringHandle();
		System.out.println("初始化工作已经完成！！");

	}

	// 测试ArrayHandle类的arraySort方法
	private void testArraySort(Integer[] source, Integer[] expect, String caseName) {
		// TODO Auto-generated method stub
		Integer[] actual = ah.arraySort(source);
		this.assertArrayTest(actual, expect, caseName);
		// 判定2个数组是否相等
		//Boolean isOk = isArrayEqual(source, actual);
		//if (isOk) {
		//	System.out.println("成功");
		//} else {
		//	System.out.println("失败");
		//}
	}

	private Boolean isArrayEqual(Integer[] source, Integer[] actual) { // 判定2个数组是否完全相同
		// TODO Auto-generated method stub
		Boolean isOk = false;
		if (source.length == actual.length) {
			for (int i = 0; i < source.length; i++) {
				if (actual[i] == source[i]) {
					isOk = true;
				} else {
					isOk = false;
				}
			}
		} else {
			isOk = false;
		}
		return isOk;
	}

	// 测试CompareHandle的mainCheck方法
	private void testmainCheck(Integer[] a, Integer[] b, int expect, String caseName) {
		// TODO Auto-generated method stub
		int actual = ch.mainCheck(a, b);
		this.assertObjectTest(actual, expect, caseName);
		//if (actual == c) {
		//	System.out.println("成功");
		//} else {
		//	System.out.println("失败");
		//}

	}

	// 测试StringHandle的splitString方法
	private void testSplitString(String source, String delimiter, Integer[] expect, String caseName) {
		// TODO Auto-generated method stub
		Integer[] actual = sh.splitString(source, delimiter);
		this.assertArrayTest(actual, expect, caseName);
		// Boolean isOk= this.isArrayEqual(expect, actual);
		// if(isOk) {
		// System.out.println("成功");
		// }else {
		// System.out.println("失败");
		// }

	}

	private void assertObjectTest(Object actual, Object expect, String caseName) {// 封装的断言操作,比较2个字符串/数是否相同
		// TODO Auto-generated method stub
		Boolean isOk = false;
		if (actual == expect) {
			isOk = true;
		} else {
			if (actual.equals(expect)) {
				isOk = true;

			} else {
				if (actual.toString().equals(expect.toString())) {
					isOk = true;
				} else {
					isOk = false;
				}

			}
		}
		if (isOk) {
			System.out.println("用例：" + caseName + "，执行成功");
		} else {
			System.out.println("用例：" + caseName + "，执行失败");

		}

	}

	private void assertArrayTest(Integer[] actual, Integer[] expect, String caseName) {// 断言，比较2个数组是否相等
		// TODO Auto-generated method stub
		Boolean isOk = false;
		if (expect.length == actual.length) {
			for (int i = 0; i < expect.length; i++) {
				if (actual[i] == expect[i]) {
					isOk = true;
				} else {
					isOk = false;
				}
			}
		} else {
			isOk = false;
		}
		if (isOk) {
			System.out.println("用例：" + caseName + "，执行成功");
		} else {
			System.out.println("用例：" + caseName + "，执行失败");

		}

	}

}
