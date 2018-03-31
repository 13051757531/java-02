package www.woniuone.http;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import www.woniu.phpwind.CommonHandler;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String value= "<input name=verify  value= f8c50838  type=hidden>";
//		String regex= "(.*name=)(.+)( value.*)";
//		Pattern p= Pattern.compile(regex);
//		Matcher m= p.matcher(value);
//		if(m.find()) {
//			System.out.println(m.group(0));			
//			System.out.println(m.group(1));			
//			System.out.println(m.group(2));			
//			System.out.println(m.group(3));			
//		}
		Test t= new Test();
		t.getVerify();
	}
	
	
	private void getVerify() {
		// TODO Auto-generated method stub
		String verifyGetUrl= "http://localhost/upload/post.php?fid="+10;
		String response= new CommonHandler().sendGet(verifyGetUrl);
		System.out.println(response);
	}
	

}
