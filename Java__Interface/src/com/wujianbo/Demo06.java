package com.wujianbo;
import java.util.Date;
import java.util.Scanner;

public class Demo06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo06 demo06= new Demo06();
		//demo06.branch();
		//demo06.execif();
		//demo06.execcase();
		//demo06.exeFor();
		//demo06.exeWhile();
		demo06.exeDowhile();
	}
	
	public void branch(){
		//字符串是:Hello, nice to meet you!
		Scanner sc= new Scanner(System.in);
		System.out.println("请输入一个字符串一！");
		String value= sc.nextLine();
		System.out.println("请输入一个字符串二！");
		String value2= sc.next();
		System.out.println("请输入一个数字！");
		int value3= sc.nextInt();
		System.out.println("nextLine函数处理："+value);
		System.out.println("next函数处理："+value2);
		System.out.println("netInt函数处理："+value3);
	}
	
	public void execif(){
		Scanner sc= new Scanner(System.in);
		System.out.println("请输入年龄：");
		int age= sc.nextInt();
		if (age <= 20) {
			System.out.println("您好，骚年！");
		}
		else if (age <= 40) {
			System.out.println("您好，大哥！");
		}
		else if (age <= 60) {
			System.out.println("您好，大叔！");
		}
		else {
			System.out.println("您好，大爷！");
		}
		if (age == 45) {
			System.out.println("您好，强哥！");	
		}
		
	}

	public void execcase(){
		String x="";
		int d= new Date().getDate();
		System.out.println(d+"a");
		switch (d) {
			case 0:
				x = "今天是星期一";
				break;
			case 1:
				x = "今天是星期一";
				break;
			case 2:
				x = "今天是星期一";
				break;
			case 3:
				x = "今天是星期一";
				break;
			case 4:
				x = "今天是星期一";
				break;
			case 5:
				x = "今天是星期一";
				break;
			case 6:
				x = "今天是星期一";
				break;
			case 25:
				x = "今天是星期七";
				break;
		}
		System.out.println(x);
	}

	public void exeFor(){
		int result= 0;
		//for (int i=1; i<=100; i++) {
		//	result += i;
		//}
		int i= 1;
		for (; i<=100 ;) {
			result += i;
			i++;
		}
		System.out.println(result);
	}
	
	public void exeWhile() {
		int i= 1;
		int result= 0;
		while (i<101) {
			result += i;
			i++;
		}
		System.out.println(result);
	}
	
	public void exeDowhile() {
		int i= 1;
		int result= 0;
		do {
			result += i;
			i++;
		}while (i<101);
		System.out.println(result);
	}
}





























