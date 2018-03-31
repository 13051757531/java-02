package www.woniu.v4;

public class ShouYe {
	HttpRequest hr= new HttpRequest();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("http.proxyHost", "localhost");
//		//System.setProperty("http.proxyHost", "192.168.0.101");
		System.setProperty("http.proxyPort", "8888");
		ShouYe sy= new ShouYe();
		for(int i=0; i<1; i++) {
			sy.home$Visit();
		}
		
		

	}
	private void home$Visit() {
		// TODO Auto-generated method stub
		String home$url= "http://192.168.0.101/phpwind/index.php";
		String response$home= "";
		try {response$home= hr.sendGet(home$url);} catch (Exception e) {e.printStackTrace();}
		System.out.println(response$home);
		if(response$home.contains("四川理工学院")) {
			System.out.println("首页访问成功");
		}else {
			System.out.println("首页访问失败");
		}
	}
	

}
