package com.wujianbo.compare;

public class CompareHandle {
	
	// 输入按一定规律分隔的字符串并将其转换成数组
	public String mainCompare(Integer[] a, Integer[] b) {
		String result = "";
		int alength = a.length;
		int blength = b.length;
		if (alength == 0 || blength == 0)
			result = "结果: 数组长度为零.";
		else if (alength != blength)
			result = "结果: 数组长度不一致.";
		else {
			int compareResult = this.mainCheck(a, b);
			if (compareResult == 1)
				result = "结果: 数组相同.";
			else if (compareResult == 2)
				result = "结果: 数组排序后相同.";
			else
				result = "结果: 数组不同.";
		}
		return result;
	}
	
	// 比较两个数组是否相同
	public int mainCheck(Integer[] a, Integer[] b) {
		int flag = 0;
		ArrayHandle ah = new ArrayHandle();
		if (ah.arrayCompare(a, b))
			flag = 1;	// 不用排序，自然相同
		else {
			Integer[] arraya = ah.arraySort(a);
			Integer[] arrayb = ah.arraySort(b);
			if (ah.arrayCompare(arraya, arrayb))
				flag = 2;	// 排好序后相同
			else
				flag = 3;	// 排序后也不同
		}
		return flag;
	}
}