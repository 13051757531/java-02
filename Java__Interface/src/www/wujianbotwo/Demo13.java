package www.wujianbotwo;

public class Demo13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo13 demo13= new Demo13();
		//demo13.nullTest();
		demo13.nullTestFour();

	}

	private void nullTest() {
		// TODO Auto-generated method stub
		try {
			String s= null;
			System.out.println("����Ϊ��" + s.length());
		}
		catch(Exception e) {
			System.out.println("�����ַ���û�ж���ɣ���");
		}
	}
	
	private void nullTestTwo() {
		// TODO Auto-generated method stub
		//try {
			String s= null;
			System.out.println("����Ϊ��" + s.length());
		//}
		//catch(Exception e) {
		//	System.out.println("�����ַ���û�ж���ɣ���");
		//}
	}
	
	
	private void nullTestThree() {
		// TODO Auto-generated method stub
		try {
			String s= null;
			System.out.println("����Ϊ��" + s.length());
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private void nullTestFour() {
		// TODO Auto-generated method stub
		try {
			String s= null;
			System.out.println("����Ϊ��" + s.length());
		}
		catch(NullPointerException e) {
			System.out.println(e);
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
	}
}
