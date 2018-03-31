package www.woniu.gui.one;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflection {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		TestReflection tr= new TestReflection();
		tr.reflection();
		

	}
	
	private void reflection() throws Exception {
		// TODO Auto-generated method stub
		Class<?> clazz= Class.forName("www.woniu.gui.one.Test");
		Object obj= clazz.newInstance();
		Method method1= clazz.getDeclaredMethod("setAge", int.class);
		method1.invoke(obj, 500);
		
		Method method2= clazz.getDeclaredMethod("getAge");
		int age= (int)method2.invoke(obj);
		System.out.println(age);
		
		
		Field field1= clazz.getDeclaredField("name");
		field1.setAccessible(true);
		field1.set(obj, "李四");
		System.out.println(field1.get(obj));
		
		Field field2= clazz.getDeclaredField("age");
		field2.setAccessible(true);
		field2.set(obj, 33);
		System.out.println(field2.get(obj));
		
		Method method3= clazz.getDeclaredMethod("getName");
		method3.setAccessible(true);
		String name= (String)method3.invoke(obj);
		System.out.println(name);
		
	}

}
