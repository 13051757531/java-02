package com.wujianbo;
import www.wujianbotwo.MainUI;;

public class Demo13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test= {11, 22, 33, 44, 55};
		System.out.println(test);
		System.out.println(test.hashCode());
		System.out.println(test.length);
		
		Demo13 demo13= new Demo13();
		test= demo13.extendStrig(test);
		System.out.println(test);
		System.out.println(test.hashCode());
		System.out.println(test.length);
		
		int[] testTwo;
		testTwo= new int[4];
		System.out.println(testTwo.hashCode());
		
	}
	
	
	public int[] extendStrig(int[] str) {
		int[] temp= new int[str.length+1];
		for(int i=0; i<str.length; i++) {
			temp[i]= str[i]; 
		}
		return temp;

	}

}
