package com.wujianbo.five;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String source= "<input name='verify' value='3334dfafaddfa' type='hidden'/>";
		String regEx= "(value=')(.+)(' type)";
		String tmp= "";
		Pattern p= Pattern.compile(regEx);
		Matcher m= p.matcher(source);
		//System.out.println(m.find());
		if(m.find()) {
			tmp= m.group(2);
			System.out.println(tmp);
		}
		
	}

}
