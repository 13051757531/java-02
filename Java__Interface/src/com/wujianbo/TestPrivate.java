package com.wujianbo;

public class TestPrivate {
	int age;
	int height;
	int weight;
	String name;
	static String nation;
	double salary;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestPrivate testprivate= new TestPrivate();
		TestPrivate qiang= new TestPrivate();
		qiang.nation= "�й�";
		testprivate.nation= "����";
		System.out.println(qiang.nation);
		System.out.println(testprivate.nation);
		System.out.println(TestPrivate.nation);
		
		testprivate.eat();
		testprivate.sleep();
		TestPrivate.sleep();

	}
	
	private void eat() {
		// TODO Auto-generated method stub
		System.out.println("���ڳԷ�");

	}
	
	private static void sleep() {
		// TODO Auto-generated method stub
		//this.eat();
		System.out.println("����˯��");

	}

}
