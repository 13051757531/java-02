package com.wujianbo.compare;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class StringHandle{
	
	// 从控制台输入字符串
	public Integer[] inputString() {
		Integer[] result;
		System.out.println("请输入一个字符串：");
		Scanner sc = new Scanner(System.in);
		String source = sc.nextLine();
        if (source.length() < 1) {
        	// 除了强制退出以外，有没有更好的解决办法？
        	System.out.println("你的输入不合法，将强制退出.");
        	System.exit(1);
        	result = null;
        	
        }
        else {
        	Integer[] array = this.splitString(source, ",");
        	if (Arrays.equals(array, null))
        		System.out.println("输入不合法");
        	result = array;
        }
        return result;
	}
	
	// 将字符串解析成数组
	// 模拟实现字符串处理方法split，为方便测试，自行实现 
	public Integer[] splitString(String source, String delimiter) {
		Vector<Integer> vector = new Vector<Integer>();
		int position = source.indexOf(delimiter);
		while (source.contains(delimiter)) {
			String value = source.substring(0, position);
			if (this.isNumber(value)) {
				vector.add(Integer.parseInt(value));
			}
			else {
				System.out.println("你的输入不合法，将强制退出.");
	        	System.exit(1);
	        	// 如果不想强制退出程序，也可以设置一个特别的值用以说明输入不合法
				// Integer[] result = {11111};
				// return result;
			}
			source = source.substring(position + 1, source.length());
			position = source.indexOf(delimiter);
		}
		vector.add(Integer.parseInt(source));
		Integer[] array = new Integer[vector.size()];
		vector.copyInto(array);
		return array;
	}
	
	// 检查字符串是否可正常转换为数字
	public boolean isNumber(String source) {
		int minus = 0;	// 统计负号的个数
		int point = 0;	// 统计小数点的个数
		if(source == ""){
			return false;
		}
		if(source == null) {
			return false;
		}else {
			for(int i=0; i<source.length(); i++){
				int code = source.charAt(i);	// 获取每个字符的ASCII码
				// 如果某个字符不属于0-9或负号或小数点，则可以判定为无效数字
				if (code<45 || code > 57 || code == 47) 
					return false;
				
				// 统计字符串中负号和小数点的个数
				if(code == 45) minus++;
				if(code == 46) point++;		
			}
		}
		
		// 如果字符串中的负号或小数点超过1个，则无效
		if(minus > 1 || point > 1) return false;
		// 如果有负号，但是负号不在第一位，则无效
		if(minus == 1 && source.charAt(0) != 45) return false;
		// 如果有小数点，但是小数点在最后一位，则无效
		if(point == 1 && source.charAt(source.length()-1) == '.') return false;
		
		// 如果以上情况都未出现，则说明是正确的数字
		return true;
	}
}