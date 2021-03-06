package www.woniu.phpwind.teacher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhpWindOne {

	HttpRequestor hr = new HttpRequestor();
	
	public static void main(String[] args) {
		PhpWindOne pwt = new PhpWindOne();
		//pwt.doRegister();
		pwt.testLogin();
		pwt.testPost();
	}
	
	// 登录
	public void testLogin() {
		String postUrl = "http://localhost/phpwind/login.php?";
		                //http://localhost/upload/login.php?
		String postData = "forward=&jumpurl=http%3A%2F%2Flocalhost%2Fphpwind%2F&step=2"
				+ "&lgt=0&pwuser=admin&pwpwd=admin&hideid=0&cktime=31536000";
		String response = hr.sendPost(postUrl, postData);
		//System.out.println(response);
		if (response.contains("您已经顺利登录")) {
			System.out.println("登录的验证：成功.");
		}
		else {
			System.out.println("登录的验证：失败.");
		}
		System.out.println("=================");
	}
	
	public void testLogin_V2(String userName) {
		String user= userName;
		String password= "123456";
		String postUrl = "http://localhost/phpwind/login.php?";
		                //http://localhost/upload/login.php?
		String postData = "forward=&jumpurl=http%3A%2F%2Flocalhost%2Fphpwind%2F&step=2"
				+ "&lgt=0&pwuser="+userName+"&pwpwd="+password+"&hideid=0&cktime=31536000";
		String response = hr.sendPost(postUrl, postData);
		//System.out.println(response);
		if (response.contains("您已经顺利登录")) {
			System.out.println("登录的验证：成功.");
		}
		else {
			System.out.println("登录的验证：失败.");
		}
		System.out.println("=================");
	}
	
	// 查找验证码
	public String getVerifyCode(String response, String regex) {
		String verifyCode = "";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(response);
		if (m.find()) {
			verifyCode = m.group(2);
		}
		return verifyCode;
	}

	// 发帖
	public void testPost() {
		String getUrl = "http://localhost/phpwind/post.php?fid=2";
		                //http://localhost/upload/login.php?
		String response = hr.sendGet(getUrl);
		//System.out.println(response);
		// 利用左右边界的方式来定位这个动态验证码，与LR和JMeter的关联作用完全一致
		String regex = "(.*verify\" value=\")(.+)(\" />.*)";
		String verifyCode = this.getVerifyCode(response, regex);
		System.out.println(verifyCode);
		
		System.out.println("===============");
		
		
		String postUrl = "http://localhost/phpwind/post.php?";
		                //http://localhost/upload/login.php?
		//http://localhost/phpwind/post.php?
		String postData = "magicname=&magicid=&verify=" + verifyCode
				+ "&atc_title=这是帖子的标题-Java-1005&atc_iconid=0"
				+ "&atc_content=这是帖子的内容Java-1005&atc_autourl=1"
				+ "&atc_usesign=1&atc_convert=1&digest=0&topped=0"
				+ "&atc_rvrc=0&atc_enhidetype=rvrc&atc_money=0"
				+ "&atc_credittype=money&atc_desc1=&attachment_1="
				+ "&att_special1=0&att_ctype1=money&atc_needrvrc1=0"
				+ "&step=2&pid=&action=new&fid=2&tid=&article=0&special=0";
		String responsePost = hr.sendPost(postUrl, postData);
		
		System.out.println(responsePost);
		
		
		if (responsePost.contains("发帖完毕点击进入主题列表")) {
			System.out.println("发帖的验证：成功.");
		}
		else {
			System.out.println("发帖的验证：失败.");
		}
	}

	// 注册
	public void doRegister() {
		for (int i=7; i<=8; i++) {
			String postUrl = "http://localhost/upload/login.php?";
			                 //http://localhost/upload/login.php? 
			String postData = "forward=&step=2&regname=javauser" + i
					+ "&regpwd=123456&regpwdrepeat=123456"
					+ "&regemail=javauser"+ i +"%40woniuxy.com&rgpermit=1";
			hr.sendPost(postUrl, postData);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
	
}
