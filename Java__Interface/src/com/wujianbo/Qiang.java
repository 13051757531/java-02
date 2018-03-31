package com.wujianbo;
import www.wujianbotwo.*;

public class Qiang {
	String name= "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Qiang qiangone= new Qiang();
		Qiang qiangtwo= new Qiang();
		qiangone.name= "deng";
		System.out.println(qiangone);
		System.out.println(qiangone.hashCode());
		System.out.println(qiangtwo);
		System.out.println(qiangtwo.hashCode());
		
		System.out.println(qiangone.name);
		
		//System.out.println(Qiang);
		MainUI ui= new MainUI();
		ui.login();

	}

}
