package www.woniu.v2;

public class ThreadV02 {
	Common cm= new Common();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadV02 tv= new ThreadV02();
		//tv.doLogin();
		tv.doLogin2();

	}
	
	private void doLogin() {
		// TODO Auto-generated method stub
		for(int i=0; i<=2100; i++) {
			String url_login= "http://localhost/phpwind/login.php?";
			String data_login= "forward=&jumpurl=http%3A%2F%2Flocalhost%2Fphpwind%2Findex.php&step=2&lgt=0&pwuser=user1&pwpwd=123456&hideid=0&cktime=31536000";
			String response= cm.sendPost(url_login, data_login);
	        if(response.contains("您已经顺利登录")) {
	        	System.out.println("登录成功:"+i);
	        }else {
	        	System.out.println("登录失败");
	        }
	        cm.clearCookie();
		}
		
	}
	
	private void doLogin2() {
		// TODO Auto-generated method stub
		for(int i=1; i<2000; i++) {
			String url_login= "http://localhost/phpwind/login.php?";
			String data_login= "forward=&jumpurl=http%3A%2F%2Flocalhost%2Fphpwind%2Findex.php&step=2&lgt=0&pwuser=user"+i+"&pwpwd=123456&hideid=0&cktime=31536000";
			String response= cm.sendPost(url_login, data_login);
	        if(response.contains("您已经顺利登录")) {
	        	System.out.println("登录成功:"+i);
	        }else {
	        	System.out.println("登录失败");
	        }
	        cm.clearCookie();
		}
		
	}

}
