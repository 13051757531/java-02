package www.woniu.https;

public class HttpsProcess {
	CommonHandler ch = new CommonHandler();
	HttpsCommonHandler hch = new HttpsCommonHandler();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HttpsProcess hp = new HttpsProcess();
		// hp.homeUrlVisited();
		// hp.homeLogion_wrongPWD();
		// hp.homeLogion_rightPWD();
		// hp.home_AgileOne_one();
		hp.home_AgileOne_two();
		hp.login_AgileOne_one();
	}

	// 首页的访问
	private void homeUrlVisited() {
		// TODO Auto-generated method stub
		String url_homeVisited = "https://www.oschina.net/home/login?";
		String response_homeVisited = ch.sendGet(url_homeVisited);
		// System.out.println(response_homeVisited);
		if (response_homeVisited.contains("开源中国社区")) {
			System.out.println("成功：首页面可以正常访问");
		} else {
			System.out.println("失败：首页面不可正常访问");
		}
	}

	// 首页的登录__密码错误
	private void homeLogion_wrongPWD() {
		// TODO Auto-generated method stub
		String url__login = "https://www.oschina.net/action/user/hash_login?from=";
		String data_login = "email=1154632528%40qq.com&pwd=70c881d4a26984ddce795f6f71817c9cf4480e79&verifyCode=&save_login=1";
		String response_login = "";
		try {
			response_login = ch.sendPost(url__login, data_login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(response_login);
	}

	// 首页的登录__密码正确
	private void homeLogion_rightPWD() {
		// TODO Auto-generated method stub
		String url__login = "https://www.oschina.net/action/user/hash_login?from=";
		// String data_login =
		// "email=1154632528%40qq.com&pwd=70c881d4a26984ddce795f6f71817c9cf4480e79&verifyCode=&save_login=1";
		// email=1154632528%40qq.com&pwd=1ff2ee41bf258f2beb6c137c1163ad442bcde25e&verifyCode=&save_login=1
		String data_login = "email=1154632528%40qq.com&pwd=1ff2ee41bf258f2beb6c137c1163ad442bcde25e&verifyCode=wkrc34&save_login=1";
		String response_login = "";
		try {
			response_login = ch.sendPost(url__login, data_login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(response_login);

	}

	private void home_AgileOne_one() {
		// TODO Auto-generated method stub
		String url_home = "https://localhost/Agileone/index.php";
		String response_homeBySendGet = ch.sendGet(url_home);
		System.out.println(response_homeBySendGet);

	}

	private void home_AgileOne_two() {
		// TODO Auto-generated method stub
		String url_home = "https://localhost/Agileone/index.php";
		String response_homeBySendGet = hch.sendHttpsGet(url_home);
		//System.out.println(response_homeBySendGet);
		if(response_homeBySendGet.contains("蜗牛学院")) {
			System.out.println("访问蜗牛学院首页成功");
		}

	}

	private void login_AgileOne_one() {
		// TODO Auto-generated method stub
		 String postUrl= "https://localhost/Agileone/index.php/common/login";
		                //https://localhost/Agileone/index.php/common/login
		 String postData= "username=admin&password=admin&savelogin=true";
		 				 //username=admin&password=admin&savelogin=true 	
		 String response_loginBySendPost= hch.sendHttpsPost(postUrl, postData);
		 System.out.println(response_loginBySendPost);
		
		
	}

}
