package www.wujianbotwo;

public class Demo15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String temp= "wjb,wjb,33333.0";
		String[] arr= temp.split(",");
		//String[] str= convertStrToArray(temp);
		System.out.println(arr);
	    for(int i=0; i<arr.length; i++) {
	    	System.out.println(arr[i]);
	    }
	}

}
