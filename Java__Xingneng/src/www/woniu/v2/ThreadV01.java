package www.woniu.v2;

public class ThreadV01 {
	Common cm= new Common();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadV01 tv= new ThreadV01();
		tv.doLogin();

	}
	
	private void doLogin() {
		String url_login= "http://localhost/phpwind/login.php?";
		String data_login= "forward=&jumpurl=http%3A%2F%2Flocalhost%2Fphpwind%2Findex.php&step=2&lgt=0&pwuser=user1&pwpwd=123456&hideid=0&cktime=31536000";
		String response= cm.sendPost(url_login, data_login);
        if(response.contains("您已经顺利登录")) {
        	System.out.println("登录成功");
        }else {
        	System.out.println("登录失败");
        }
	}

}
