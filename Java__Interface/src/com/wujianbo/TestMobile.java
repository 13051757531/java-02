package com.wujianbo;

public class TestMobile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mobile01 mobile01= new Mobile01();
		mobile01.name= "����";
		mobile01.size= "23";
		mobile01.surface();
		mobile01.Call();
		System.out.println("�ڴ��ַΪ��"+mobile01.hashCode());
		System.out.println("�ֻ�������"+mobile01.name);
		int i= 0;
//		System.out.println(getType(i));
		
	}

}


class Mobile01 {
	String color= "";
	int price= 0;
	String name="";
	String versoin="";
	String size="";
	
	public void Call(){
		int a= 1;
		String name= "wujianbo";
		System.out.println("��绰");
	}
	
	public void surface(){
		System.out.println("����");
	}
}