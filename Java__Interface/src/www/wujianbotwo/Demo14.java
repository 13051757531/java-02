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
			System.out.println("�ַ�����û�г�ʼ��");
		}
		finally {
			System.out.println("������û�쳣���Ҷ���ִ��");
		}
	}

}
