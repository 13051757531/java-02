package www.wujianbotwo;

import java.util.*;

public class Demo07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List mylist= new List();

		String[] names= {"woniuxy", "admin", "qiang"};
		Object name= "woniuxy";
		Object age= 40;
		Object  demo= new Demo07();
		
		Object[] objs= {"name", 50, 123.45, true, demo};
		
		List<Object> mylist= new ArrayList<Object>();
		
		List<String> list= new ArrayList<String>();
		//Demo07 demo07= (Demo07)new Object();
		
		list.add("aaa");
		list.add("wujianbo");
		list.add("wudongmei");
		list.add("wujiamin");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		list.remove("wujianbo");//删除字符串数组列表中的元素
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		list.remove(0);//删除字符串数组列表中的第1个元素
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		list.set(1, "wujianbo");//更改列表数组中的第1个元素
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
		System.out.println(list.indexOf("wujianbo"));//输出列表数组中wujianbo元素所在数组中的下标
		
		
	}

}
