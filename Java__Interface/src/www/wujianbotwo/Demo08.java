package www.wujianbotwo;

public class Demo08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String content= "wujianbo,wujianob,33333";
		String[] ud= content.split(",");//将字符串分段成一个数组
		for(int i=0; i<ud.length; i++) {
			System.out.println(ud[i]);
		}
		

	}

}
