package www.woniu.phpwind;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fid= "";
		String[] fids= {"10", "11", "12", "13", "14", "15", "16", "17", "18"};
		//int tempNum= (int)(Math.random()*9);
		//fid = fids[tempNum];
		for(int i=0; i<40; i++) {
			int tempNum= (int)(Math.random()*9);
			fid = fids[tempNum];
			//System.out.println(fid);
			System.out.println(tempNum);
		}
		
	}

}
