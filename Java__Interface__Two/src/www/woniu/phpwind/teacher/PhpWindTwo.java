package www.woniu.phpwind.teacher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class PhpWindTwo {

	HttpRequestor hr = new HttpRequestor();
	
	public static void main(String[] args) {
		PhpWindTwo pwt = new PhpWindTwo();
//		pwt.randomPostMany();
//		pwt.randomPostThree();
		//pwt.randomReply();
		pwt.randomPostOne();
	}
	
	public void randomPostMany() {
		long start = System.currentTimeMillis();
		for (int i=0; i<10; i++) {
			hr.clearCookie();
			this.randomPostOne();
		}
		long end = System.currentTimeMillis();
		System.out.println("所有时间为：" + (end - start));
	}
	
	// 使用相对简单的方式完成
	public void randomPostOne() {
		// 首先实现随机登录: javauser1 ~ javauser50
		int uid = (int)(Math.random() * 50) + 1;  // 1-50的范围
		this.doLogin("javauser" + uid, "123456");
		
		// 查找注销的验证码
		String response = hr.sendGet("http://localhost/phpwind/");
		String verifyLogout = this.getItem(response, "(quit&verify=)(.+)(\">)");
		
		// 构建随机的版块
		int fid = (int)(Math.random()*8) + 2;	// 2-9的范围
		
		// 构建随机的标题和内容
		int sequence = (int)(Math.random() * 1000000);
		String headline = "这是帖子的标题-Java发送-" + sequence;
		String content = "这是帖子的内容-Java发送-" + sequence;
		
		this.doPost(headline, content, fid);
		
		// 注销用户
		hr.sendGet("http://localhost/phpwind/login.php?action=quit&verify=" + verifyLogout);
	}
	
	// 使用数据源的方式
	public void randomPostTwo() {
		// 首先实现随机登录
		String[][] userpass = {{"denny","123456"}, {"javauser1","123456"}, {"woniuxy","654321"}};
		int upIndex = (int)(Math.random() * 3);
		this.doLogin(userpass[upIndex][0], userpass[upIndex][1]);
		
		// 查找注销的验证码
		String response = hr.sendGet("http://localhost/phpwind/");
		String verifyLogout = this.getItem(response, "(quit&verify=)(.+)(\">)");
		
		// 构建随机的版块
		int[] forum = {2,3,4,5,6,7,8,9};
		int fIndex = (int)(Math.random() * 8);
		int fid = forum[fIndex];
		
		// 构建随机的标题和内容
		int sequence = (int)(Math.random() * 1000000);
		String headline = "这是帖子的标题-Java发送-" + sequence;
		String content = "这是帖子的内容-Java发送-" + sequence;
		
		this.doPost(headline, content, fid);
		
		// 注销用户
		hr.sendGet("http://localhost/phpwind/login.php?action=quit&verify=" + verifyLogout);
	}
	
	// 使用左右边界关联多条记录
	public void randomPostThree() {
		// 首先实现随机登录: javauser1 ~ javauser50
 		int uid = (int)(Math.random() * 50) + 1;
		this.doLogin("javauser" + uid, "123456");
		
		// 构建随机的版块(利用左右边界的方式完成)
		// 1. 获取到首页的响应的源代码
		String response = hr.sendGet("http://localhost/phpwind/");		
		// 2. 设定左右边界来查找所有的版块编号
		List<String> items = this.getItems(response, "(thread.php\\?fid=)(.+)(\" target=\"_blank)");
		// 3. 生成一个随机数从List对象中取值
		int index = (int)(Math.random() * items.size());
		int fid = Integer.parseInt(items.get(index));
		
		// 构建随机的标题和内容
		int sequence = (int)(Math.random() * 1000000);
		String headline = "这是帖子的标题-Java发送-" + sequence;
		String content = "这是帖子的内容-Java发送-" + sequence;
		
		this.doPost(headline, content, fid);
	}
	
	// 随机回复帖子
	public void randomReply() {
		// 首先实现随机登录: javauser1 ~ javauser50
		int uid = (int)(Math.random() * 50) + 1;  // 1-50的范围
		this.doLogin("javauser" + uid, "123456");
		
		// 查找注销的验证码
		String response = hr.sendGet("http://localhost/phpwind/");
		String verifyLogout = this.getItem(response, "(quit&verify=)(.+)(\">)");
		
		// 构建随机的版块(利用左右边界的方式完成)
		List<String> items = this.getItems(response, "(thread.php\\?fid=)(.+)(\" target=\"_blank)");
		int index = (int)(Math.random() * items.size());
		int fid = Integer.parseInt(items.get(index));
		
		// 查找随机页面
		String pageUrl = "http://localhost/phpwind/thread.php?fid=" + fid;
		String response2 = hr.sendGet(pageUrl);
		String pageCount = this.getItem(response2, "(Pages: 1/)(.+)(&nbsp; &nbsp; &nbsp;)");
		Random myRandom = new Random();
		int page = myRandom.nextInt(Integer.parseInt(pageCount));
		
		// 进入到随机版块的随机页面当中，进而查找到随机的帖子的编号
		String threadUrl = "http://localhost/phpwind/thread.php?fid="+fid+"&page=" + page;
		String response3 = hr.sendGet(threadUrl);
		List<String> itemsID = this.getItems(response3, "(id=\"a_ajax_)(.+)(\">)");
		index = (int)(Math.random() * itemsID.size());
		int tid = Integer.parseInt(itemsID.get(index));
		
		// 构建随机的标题和内容
		int sequence = (int)(Math.random() * 1000000);
		String headline = "这是帖子的回复标题-Java发送-" + sequence;
		String content = "这是帖子的回复内容-Java发送-" + sequence;
		
		this.doReply(headline, content, fid, tid);
	}

	
	
	
	public void doLogin(String username, String password) {
		String postUrl = "http://localhost/phpwind/login.php?";
		String postData = "forward=&jumpurl=http%3A%2F%2Flocalhost%2Fphpwind%2F&step=2"
				+ "&lgt=0&pwuser="+ username +"&pwpwd="+ password +"&hideid=0&cktime=31536000";
		String response = hr.sendPost(postUrl, postData);
		if (response.contains("您已经顺利登录")) {
			System.out.println("登录的验证：成功 - 用户名: " + username);
		}
		else {
			System.out.println("登录的验证：失败- 用户名: " + username);
		}
	}
	
	public void doPost(String headline, String content, int fid) {
		String getUrl = "http://localhost/phpwind/post.php?fid=" + fid;
		String response = hr.sendGet(getUrl);
		// 利用左右边界的方式来定位这个动态验证码，与LR和JMeter的关联作用完全一致
		String regex = "(.*verify\" value=\")(.+)(\" />.*)";
		String verifyCode = this.getItem(response, regex);
		
		String postUrl = "http://localhost/phpwind/post.php?";
		String postData = "magicname=&magicid=&verify=" + verifyCode
				+ "&atc_title="+ headline +"&atc_iconid=0"
				+ "&atc_content="+ content +"&atc_autourl=1"
				+ "&atc_usesign=1&atc_convert=1&digest=0&topped=0"
				+ "&atc_rvrc=0&atc_enhidetype=rvrc&atc_money=0"
				+ "&atc_credittype=money&atc_desc1=&attachment_1="
				+ "&att_special1=0&att_ctype1=money&atc_needrvrc1=0"
				+ "&step=2&pid=&action=new&fid="+ fid +"&tid=&article=0&special=0";
		System.out.println(postData);
		
		String responsePost = hr.sendPost(postUrl, postData);
		if (responsePost.contains("发帖完毕点击进入主题列表")) {
			System.out.println("发帖的验证：成功 - 版块编号: " + fid);
		}
		else {
			System.out.println("发帖的验证：失败 - 版块编号: " + fid);
		}
	}
	
	public void doReply(String headline, String content, int fid, int tid) {
		String getUrl = "http://localhost/phpwind/post.php?fid=" + fid;
		String response = hr.sendGet(getUrl);
		// 利用左右边界的方式来定位这个动态验证码，与LR和JMeter的关联作用完全一致
		String regex = "(.*verify\" value=\")(.+)(\" />.*)";
		String verifyCode = this.getItem(response, regex);
		
		String postUrl = "http://localhost/phpwind/post.php?";
		String postData = "magicname=&magicid=&verify=" + verifyCode
				+ "&atc_title="+ headline +"&atc_iconid=0"
				+ "&atc_content="+ content +"&atc_autourl=1"
				+ "&atc_usesign=1&atc_convert=1&digest=0&topped=0"
				+ "&atc_rvrc=0&atc_enhidetype=rvrc&atc_money=0"
				+ "&atc_credittype=money&atc_desc1=&attachment_1="
				+ "&att_special1=0&att_ctype1=money&atc_needrvrc1=0"
				+ "&step=2&pid=&action=reply&fid="+ fid +"&tid=" + tid +"&article=0&special=0";
		
		String responsePost = hr.sendPost(postUrl, postData);
		if (responsePost.contains("发帖完毕点击进入主题列表")) {
			System.out.println("回帖的验证：成功 - 帖子编号: " + tid);
		}
		else {
			System.out.println("回帖的验证：失败 - 帖子编号: " + tid);
		}
	}
	
	// 查找验证码
	private String getItem(String response, String regex) {
		String verifyCode = "";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(response);
		if (m.find()) {
			verifyCode = m.group(2);
		}
		return verifyCode;
	}
	
	// 通过左右边界把多条记录查找出来
	private List<String> getItems(String response, String regex) {
		List<String> items = new ArrayList<String>();
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(response);
		while (m.find()) {
			items.add(m.group(2));
		}
		return items;
	}
	
}
