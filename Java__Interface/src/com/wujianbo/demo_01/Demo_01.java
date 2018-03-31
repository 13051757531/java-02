package com.wujianbo.demo_01;

public class Demo_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime= System.currentTimeMillis();
		//System.out.println(startTime);
		double result= 1.0;
		for(int i=0; i<999999999; i++) {
			result= i*result + result + result/2;
		}
		long endTime= System.currentTimeMillis();
		long totalTime= endTime - startTime;
		System.out.println(totalTime);

	}

}
