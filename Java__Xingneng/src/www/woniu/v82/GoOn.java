package www.woniu.v82;
/**
 * 
 */

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



class Pick {
	
}
public class GoOn {
	public static final int NUM = 9;
	int a=0;
	String myStringes= "";
	int myIes= 4;
	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Messages.getString("GoOn.0")); //$NON-NLS-1$
		List<String> list= new ArrayList<String>();
		list.add("aaa");
		for (int i = 0; i < args.length; i++) {
			
		}
		System.out.println();
		int j = NUM;
		int ddddd= j;
		ddddd= ddddd+8;
		System.out.println();
		for(int i=0; i<j; i++){
			System.out.println(i);
		}

	}


	public static void test() {
		System.out.println();
		int j = NUM;
		int ddddd= j;
		ddddd= ddddd+8;
		System.out.println();
		for(int i=0; i<j; i++){
			System.out.println(i);
		}
	}


	public static void test(int a) {
		//TODO 待完成
		//FIXME 待修复
		test();
	}


	public static GoOn createGoOn() {
		
		return new GoOn();
	}


	public int getA() {
		return a;
		/**
		 * 
		 */
	}


	public void setA(int a) {
		for(int i=0; i<j; i++){
			System.out.println(i);
		}
		this.a = a;
	}


	@Override
	public String toString() {
		return "GoOn [a=" + a + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
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
		GoOn other = (GoOn) obj;
		if (a != other.a)
			return false;
		return true;
	}


	public GoOn(int a) {
		super();
		this.a = a;
		String b= "//Java__Xingneng//src//www//woniu//v82//Message.java";
		String cString= "sun.awt.HKSCS.class";
	}


	private GoOn() {
		super();
		// TODO Auto-generated constructor stub
	}

}
