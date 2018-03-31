package www.woniuone.http;



public class HttpRequstNotice {
	public static void main(String[] args) throws Exception {
		HttpRequstNotice hr= new HttpRequstNotice();
		//获取服务器分配给浏览器的cookie
		hr.testHome();
		//获取可以登录服务器的完整cookie
		hr.testLogin();
		//公告管理模块__新增操作
		//hr.testAdd();
		hr.testAddMany(10);
		
	}
	
	//公告管理模块生成多个记录
	private void testAddMany(int j) throws Exception {
		// TODO Auto-generated method stub
		for(int i=0; i<j; i++) {
			this.testAdd();
		}
	}
	// 获取服务器分配给浏览器的cookie
	public void testHome() throws Exception {
		// TODO Auto-generated method stub
		String getUrl= "http://localhost/Agileone/";
		String respHome= new HttpRequest().sendGet(getUrl);
		//System.out.println(respHome);
		
	}
	
	// 获取可以登录服务器的完整cookie
	public void testLogin() throws Exception {
		// TODO Auto-generated method stub
		String postUrl = "http://localhost/Agileone/index.php/common/login";
		String postData = "username=admin&password=admin&savelogin=true";
		String respResult = new HttpRequest().sendPost(postUrl, postData);
		if (respResult.contains("successful")) {
			System.out.println("登录验证：成功");
		} else {
			System.out.println("登录验证：失败");
		}

	}
	// 公告管理模块__新增操作
	public void testAdd() throws Exception {
		// TODO Auto-generated method stub
		Double titleId= Math.random()*10000;
		String postUrl = "http://localhost/Agileone/index.php/notice/add";
		String postData = "headline=公告4"+titleId+"&content=公告"+titleId+"&scope=1&expireddate=2017-10-28";
		String respAdd = new HttpRequest().sendPost(postUrl, postData);

		respAdd = respAdd.replaceAll("\n", "");
		System.out.println(respAdd);
		if (respAdd.matches("\\d{1,100}")) {
			System.out.println("公告发布：成功");
		} else {
			System.out.println("公告发布：失败");
		}
	}

}
