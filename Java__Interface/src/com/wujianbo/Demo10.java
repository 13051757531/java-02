package com.wujianbo;

import java.util.Scanner;

public class Demo10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo10 demo10= new Demo10();
		//System.out.println(demo10.login("woniuxy", "123456"));
		demo10.processNumber();
		

	}
	
	public boolean login(String a, String b) {
			String acatualUsername= "woniuxy";
			String acatualPassword= "123456";
			//String acatualUsername= a;
			//String acatualPassword= b;
			boolean isok= false;
			//Scanner sc= new Scanner(System.in);
			//System.out.println("请输入用户名：");
			//String name= sc.nextLine();
			String name= a;
			//输入的用户名和系统中的用户名不同
			if(!name.equals(acatualUsername)) {
				System.out.println("用户名输入错误！");
				//this.login(a, b);
			//输入的用户名和系统中的用户名相同
		} else {
			while (true) {
				//System.out.println("请输入用密码：");
				//String password = sc.nextLine();
				String password = b;
				if (!password.equals(acatualPassword)) {
					System.out.println("密码输入错误");
				} else {
					System.out.println("恭喜，登录成功");
					isok= true;
					break;
				}
			}
		}
		return isok;
			
	}
	
	
	
	public void processNumber() {
		//3456
		Scanner sc= new Scanner(System.in);
		System.out.println("请输入您要判断的数字:");
		int b= sc.nextInt();
		int a= (int)b;
		//计算一个数字每一位之和
		this.caculateNumber(a);
		//计算数字有多少位
		this.countNumber(a);
		//将该数字倒序输出
		this.reverse(a);
	}
	
	
	//计算一个数字每一位之和
	private void caculateNumber(int a) {
		int sum= 0;
		int value= 1;
		int temp= a;
		while(value > 0) {
			 int b= a % 10;
			 //System.out.println(b);
			 a= a / 10;
			 value= a;
			sum +=b;
		}
		System.out.println("数字"+temp+"所有位相加为："+sum);
	}
	//计算数字有多少位
	private void countNumber(int a){
		String temp= String.valueOf(a);
		int number= temp.length();
		System.out.println("数字"+temp+"共有："+number+"位");
	}
	//将该数字倒序输出
	private void reverse(int a) {
		String temp= "";
		int judge=a;
		while(a > 0) {
			int b= a % 10;
			temp +=b;
			a= a / 10;
		}
		System.out.println("数字"+judge+"进行倒序后的结果是："+temp);
	}
	
	
}
