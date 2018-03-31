package www.wujianbotwo;

public class Demo4 {
	public static void main(String[] args) {
		Demo4 demo4= new Demo4();
		Demo4 demo5= new Demo4();
		System.out.println(demo4);
		
	}
	
	static {
		System.out.println("static语句执行");
	}
	
	public Demo4() {
		// TODO Auto-generated constructor stub
		System.out.println("Demo4构造语句执行");
	}
}
