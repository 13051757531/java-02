package com.wujianbo;

import java.lang.reflect.Method;
import java.sql.Time;

public class Demo05 {
	int a=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s= 9;
//		Time.valueOf(s);
		              System.out.println("aa");
		        while (true) {
long micro = 24 * 24 * 60 * 1000 * 1000;
			long millis = 24 * 24 * 60 * 1000;
			
			         System.out.println(micro / millis);

			Demo05 demo05 = new Demo05();
			break;
			
		}
	}
		
	public void add() {
		System.out.println();
	}
		
	
		/*
		 * 
		 */
}
	
//	public static void main(String[] args) {
//		
//	}

//}


class Mode{
	int add=0;
	int sub=9;
	
	public void add(){
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + add;
		result = prime * result + sub;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mode other = (Mode) obj;
		if (add != other.add)
			return false;
		if (sub != other.sub)
			return false;
		return true;
	}

	public int getAdd() {
		return add;
	}

	public void setAdd(int add) {
		this.add = add;
	}

	public int getSub() {
		return sub;
	}

	public void setSub(int sub) {
		this.sub = sub;
	}

	public Mode(int add) {
		super();
		this.add = add;
	}

	public Mode(int add, int sub) {
		super();
		this.add = add;
		this.sub = sub;
	}

	public Mode() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
