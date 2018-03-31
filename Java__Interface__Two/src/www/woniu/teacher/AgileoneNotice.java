package www.woniu.teacher;

public class AgileoneNotice {

	HttpRequestor hr = new HttpRequestor();
	
	public static void main(String[] args) {
		AgileoneNotice notice = new AgileoneNotice();
		notice.testHome();
		notice.testLogin();
		notice.testAdd();
	}
	
	public void testHome() {
		String getUrl = "http://localhost/agileone/";
		String respHome = hr.sendGet(getUrl);
	}
	
	public void testLogin() {
		String postUrl = "http://localhost/agileone/index.php/common/login";
		String postData = "username=admin&password=admin&savelogin=true";
		String respLogin = hr.sendPost(postUrl, postData);
		if (respLogin.contains("successful")) {
			System.out.println("登录的验证：成功.");
		}
		else {
			System.out.println("登录的验证：失败.");
		}
	}
	
	public void testAdd() {
		int noticeId = (int)(Math.random() * 10000);
		String postUrl = "http://localhost/agileone/index.php/notice/add";
		String postData = "headline=这是公告的标题-"+noticeId+"&content=这是公告的内容-1008"
				+ "&scope=1&expireddate=2017-7-30";
		String respAdd = hr.sendPost(postUrl, postData);
		System.out.println(respAdd);
		respAdd = respAdd.replace("\n", "");
		if (respAdd.matches("\\d{1,10}")) {
			System.out.println("新增的验证：成功.");
		}
		else {
			System.out.println("新增的验证：失败.");
		}
	}
}
