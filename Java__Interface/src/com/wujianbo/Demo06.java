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
		//�ַ�����:Hello, nice to meet you!
		Scanner sc= new Scanner(System.in);
		System.out.println("������һ���ַ���һ��");
		String value= sc.nextLine();
		System.out.println("������һ���ַ�������");
		String value2= sc.next();
		System.out.println("������һ�����֣�");
		int value3= sc.nextInt();
		System.out.println("nextLine��������"+value);
		System.out.println("next��������"+value2);
		System.out.println("netInt��������"+value3);
	}
	
	public void execif(){
		Scanner sc= new Scanner(System.in);
		System.out.println("���������䣺");
		int age= sc.nextInt();
		if (age <= 20) {
			System.out.println("���ã�ɧ�꣡");
		}
		else if (age <= 40) {
			System.out.println("���ã���磡");
		}
		else if (age <= 60) {
			System.out.println("���ã����壡");
		}
		else {
			System.out.println("���ã���ү��");
		}
		if (age == 45) {
			System.out.println("���ã�ǿ�磡");	
		}
		
	}

	public void execcase(){
		String x="";
		int d= new Date().getDate();
		System.out.println(d+"a");
		switch (d) {
			case 0:
				x = "����������һ";
				break;
			case 1:
				x = "����������һ";
				break;
			case 2:
				x = "����������һ";
				break;
			case 3:
				x = "����������һ";
				break;
			case 4:
				x = "����������һ";
				break;
			case 5:
				x = "����������һ";
				break;
			case 6:
				x = "����������һ";
				break;
			case 25:
				x = "������������";
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





























