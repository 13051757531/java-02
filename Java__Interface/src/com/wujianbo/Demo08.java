package com.wujianbo;

import java.util.Random;
import java.util.Scanner;

     /*
	 * x的y次方
	 */

public class Demo08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo08 demo08= new Demo08();
		//demo08.powerOne();
		//System.out.println(demo08.powerTwo(2, 3));
		//demo08.exePower();
		//demo08.charStat();
		//demo08.guessPrice();
		int a= demo08.checkNumber();
		System.out.println(a);

	}
	
	public void powerOne() {
		// 2的3次方
		int a = 3;
		int b = 5;
		int result = 1;
		// 循环b次，基数为a
		for (int i = 1; i <= b; i++) {
			result *= a;
		}
		System.out.println(a + "的" + b + "次方是：" + result);
	}
	
	// 求a的b次方为：
	public double powerTwo(double a, double b) {
		// int a = a;
		// int b = b;
		int result = 1;
		// 循环b次，基数为a
		for (int i = 1; i <= b; i++) {
			result *= a;
		}
		//System.out.println(a + "的" + b + "次方是：" + result);
		return result;
	}
	
	public void exePower() {
		//输入基数、次方的数
		while(true) {
			Scanner sc= new Scanner(System.in);
			System.out.println("请输该冥次方函数的基数：");
			int a= sc.nextInt();
			System.out.println("请输入该冥次方行数的冥方数：");
			int b= sc.nextInt();
			//调用冥方函数进行运算
			double result= this.powerTwo(a, b);
			//输出返回的值
			System.out.println(a + "的" + b + "次方是：" + result);
			if(a == 2) {
				break;
			}
		}
		
	}
	/*
	 * 数字：48~57
	 * 大写字母：65~90
	 * 小写字母：97~122
	 */
	//统计字符，数字、大写字母、小写字母、特殊符号
	public void charStat() {
		int Upper= 0;
		int Lower= 0;
		int number= 0;
		int other= 0;
		//abc123jJJ*(
		//String str= "abc123jJJ*(";
		
		//字符串输入
		Scanner sc= new Scanner(System.in);
		System.out.println("请输入您要判断的字符串：");
		String str= sc.nextLine();
		
		// 循环遍历字符串，并进行类型判断
		for(int j=0; j<str.length()-1; j++) {
			//System.out.println(str.charAt(i));
			//System.out.println((int)str.charAt(i));
//			int i= (int)str.charAt(j);
			
			char i= str.charAt(j);
			//数字个数
			if(i>=48 && i<=57) {
				number++;
			//大写字母个数
			}else if(i>=65 && i<=90) {
				Upper++;
			//小写字母个数
			}else if(i>=97 && i<=122) {
				Lower++;
			//其他特殊字符个数
			}else {
				other++;
			}
		}
		//输出判断的结果
		System.out.println("数字个数有："+number);
		System.out.println("大写字母个数有："+Upper);
		System.out.println("小写字母个数有："+Lower);
		System.out.println("其他特殊字符个数有："+other);
		
	}

	public void guessPrice() {
		//int price1= 44;
		//int price2= 44;
		//输入玩具输入的数：
		//方法一
		//System.out.println((int)(Math.random()*200));
		//方法二
		Random random= new Random();
		int price1= random.nextInt(200);
		System.out.println(price1);
		int i=2;
		while(true) {
			Scanner sc= new Scanner(System.in);
			System.out.println("请输入您猜想的价格为：");
			int price2= sc.nextInt();
			if(price1 > price2) {
				System.out.println("猜的数小了");
			}else if(price1 < price2){
				System.out.println("猜的数大了");
			}else{
				System.out.println("猜的数对了为："+price2);
				break;
			}
		}
		
	}
	
	//检查字符串是否为有效的数字
	public int checkNumber() {
		//数字字符串为：333、-333、-45.4
		/*0~9: 48~57
		 * -:  45
		 * .:  46
		 * 特殊数字：0333
		 * 			333-333
		 *          888-
		 *          .333
		 *          88.-
		 */
		
		//获取字符串
		Scanner sc= new Scanner(System.in);
		System.out.println("请输入要判断的字符串：");
		String str= sc.nextLine();
		//String str= "abc33JJ*((";
		//对字符串进行判断
		int number= 0;
		int dot= 0;
		int sub= 0;
		int other= 0;
		int enable= 0;
		for(int i=0; i<str.length();i++) {
			//System.out.println(str.charAt(i));
			char cr= str.charAt(i);
			if(cr == 46) {
				dot++;
			}else if(cr == 45) {
				//System.out.println("-");
				sub++;
			}else if(cr>=48 && cr<=57) {
				number++;
			}else {
				other++;
			}
		}
		
		if(dot>=2 | sub>=2 |other>=1) {
			//System.out.println("该数字为非有效数字");
			enable++;
		}else {
			if(str.charAt(0) == 48){
				//System.out.println("该数字为非有效数字");
				enable++;
			}
			else if(sub==1 && str.charAt(0)!=45 ) {
				//System.out.println("该数字为非有效数字");
				enable++;
			}
			
		}
		//返回结果；输出该字符串
		if(enable != 0) {
			return -1;
		}else {
			return 1;
		}
	}
}
