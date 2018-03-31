package com.wujianbo;

import java.util.Scanner;

public class Demo09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo09 demo09= new Demo09();
		demo09.login();

	}

	public void login() {
		String acatualUsername= "woniuxy";
		String acatualPassword= "123456";
		//Scanner sc= new Scanner(System.in);
		//System.out.println("请输入用户名：");
		//String name= sc.nextLine();
		//System.out.println("请输入用密码：");
		//String password= sc.nextLine();
		while(true) {
			Scanner sc= new Scanner(System.in);
			System.out.println("请输入用户名：");
			String name= sc.nextLine();
			if(!name.equals(acatualUsername)) {
				System.out.println("用户名输入错误！");
			}else {
				while(true) {
					System.out.println("请输入用密码：");
					String password= sc.nextLine();
					if(!password.equals(acatualPassword)) {
						System.out.println("密码输入错误");
					}else{
						System.out.println("恭喜，登录成功");
						break;
					}
				}
			}
		}
		
		
	}
}
