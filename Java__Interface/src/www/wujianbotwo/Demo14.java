package www.wujianbotwo;

public class Demo14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo14 demo14= new Demo14();
		demo14.nullTest();

	}
	
	private void nullTest() {
		// TODO Auto-generated method stub
		try {
			String s= null;
			//int x= 9 / 0;
			System.out.println(s.length());
			//System.out.println(x);
		} 
		catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NullPointerException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e);
			System.out.println("字符变量没有初始化");
		}
		finally {
			System.out.println("不管有没异常，我都会执行");
		}
	}

}
