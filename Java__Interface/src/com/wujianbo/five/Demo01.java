package com.wujianbo.five;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String phone= "13541433525";
		//String phoneEx= "^1[387]\\d{9}";
		
		//Pattern pattern= Pattern.compile(phoneEx);//编译正则表达式
		//Matcher matcherphone= pattern.matcher(phone);
		//System.out.println(matcherphone.matches());
		
		String telephone= "0512-85121234";
		String telephoneEx= "^0\\d{2,3}-[856]\\d{6,7}";
		System.out.println(Pattern.compile(telephoneEx).matcher(telephone).matches());
		

	}

}

























