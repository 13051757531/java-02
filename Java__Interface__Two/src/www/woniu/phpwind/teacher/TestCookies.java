package www.woniu.phpwind.teacher;

import www.woniu.phpwind.CommonHandler;

public class TestCookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String homeUrl= "http://localhost/upload/login.php";
		String loginUrl= "http://localhost/upload/login.php?";
		String postData= "forward=&jumpurl=http%3A%2F%2Flocalhost%2Fupload%2Fthread.php%3Ffid%3D10&step=2&lgt=0&pwuser=admin&pwpwd=admin&hideid=0&cktime=31536000";
		//String ResponseByLogin= new CommonHandler().sendPost(loginUrl, postData);
		new HttpRequestor().sendGet(homeUrl);
		System.out.println(new HttpRequestor().mycookie);
		new HttpRequestor().sendPost(loginUrl, postData);
		System.out.println("==============================");
		System.out.println(new HttpRequestor().mycookie);
		

	}

}
