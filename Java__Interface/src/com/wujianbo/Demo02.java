package com.wujianbo;

/**
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args){
		System.out.println(args);
		Demo02 demo02= new Demo02();
		System.out.println(demo02);
		System.out.println("对象在堆栈中的内存首地址："+demo02.hashCode());
		demo02.dataTye();
		int age=34;
		System.out.println(age);
		
	}
	
	public void dataTye(){
		int i= (int)1000.1;
		char[] s= {'w', 'o', 'n', 'i', 'u'};
		System.out.println(s);
		System.out.println("字符数组在对象栈区的首地址："+s.hashCode());
		String b= "蜗牛学院";
		System.out.println("字符串在对象栈区的首地址："+b.hashCode());
		float f= 9999.82F;
	}

}
