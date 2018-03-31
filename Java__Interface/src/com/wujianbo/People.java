package com.wujianbo;

public class People {
	int age;
	int height;
	int weight;
	String name;
	static String nation;
	double salary;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		People people= new People();
		People peopleTwo= new People(34);
		People peopleTher= new People("吴建波", 333);
		

	}
     
	public People() {
		System.out.println("正在调用构造方法");
	}
	
	public People(int age) {
		this.age= age;
		System.out.println(this.age);
		//System.out.println("正在调用构造方法");
	}
	
	public People(String name, double salary) {
		this.name= name;
		this.salary= salary;
		//System.out.println("正在调用构造方法");
		System.out.println(this.name+ " "+ this.salary);
	}
}
