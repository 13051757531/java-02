package com.wujianbo.five;

import java.util.regex.Pattern;

public class Demo03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String email= "dengqiang@woniuxy.com.cn";
		String email= "dengqiang@woniuxy.com.cn";
        //String emailEx= "[a-zA-Z0-9{1,}@((a-zA-Z0-9-*){1,}\\.){1,3}[a-zA-Z\\-]{1,}";
		String emailEx= "[a-zA-Z0-9]{1,}@[a-zA-Z0-9]{1,}.[a-zA-Z0-9]{1,}.[a-zA-Z0-9]{1,}$";
		System.out.println(Pattern.compile(emailEx).matcher(email).matches());
	}

}
