package com.wujianbo.compare;

public class MainRun {
	public static void main(String[] args) {
		StringHandle sh = new StringHandle();
		CompareHandle ch = new CompareHandle();
		// 提示用户输入字符串
		Integer[] a = sh.inputString();
		Integer[] b = sh.inputString();

		// 对用户输入的内容进行比较
		String result = ch.mainCompare(a, b);
		System.out.println(result);
	}
}