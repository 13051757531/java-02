package www.woniu.v5;

import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;

public class DriverTopicProcess {
	CommonHandler ch= new CommonHandler();
	
	public static void main(String[] args) throws Exception {
		DriverTopicProcess dtp= new DriverTopicProcess();
		//dtp.driverOpenHome();
		//dtp.driverLoginHome();
		//dtp.driverTopicAdd();
		//dtp.driverRegister();
		//dtp.driverTopicAdd__ByOneUserToRandomSchool__two();
		//dtp.driverTopicReply();
		//dtp.driverTestReply();
		//dtp.driverTopicAdd__ByOneUserToRandomSchool__One();
		dtp.driverTopicAdd__ByOneUserToOneSchool();
	}

	//驱动__贴__通过URL打开首页
	public void driverOpenHome() {
		// TODO Auto-generated method stub
	
		String homeUrl= "http://localhost/phpwind/login.php";
		//String homeUrl= "http://www.baidu.com";
		String responseHome= new CommonHandler().sendGet(homeUrl);
		//System.out.println(responseHome);
		if(responseHome.contains("首页")) {
			System.out.println("用户访问登录界面场景：成功");
		}else {
			System.out.println("用户访问登录界面场景：失败");
		}
	}

	//驱动__贴__登录首页
	public void driverLoginHome() throws Exception {
		// TODO Auto-generated method stub
		String loginUrl= "http://localhost/phpwind/login.php?";
		String postData= "forward=&jumpurl=http%3A%2F%2Flocalhost%2Fupload%2Fthread.php%3Ffid%3D10&step=2&lgt=0&pwuser=admin&pwpwd=admin&hideid=0&cktime=31536000";
		String ResponseByLogin= new CommonHandler().sendPost(loginUrl, postData);
		//System.out.println(ResponseByLogin);
		if(ResponseByLogin.contains("您已经顺利登录")) {
			System.out.println("用户登录网站场景：成功");
		}else {
			System.out.println("用户登录网站场景：失败");			
		}
	}
	
	//驱动__注册用户
	private void driverRegister() throws Exception{
		// TODO Auto-generated method stub
		String registerUrl= "http://localhost/upload/register.php?";
		for(int i=56; i<57; i++) {
			 String postData= "forward=&step=2&regname=user"+ i +"&regpwd=123456&regpwdrepeat=123456&regemail="+i+"457896@qq.com&rgpermit=1";
			 String responseRegister= new CommonHandler().sendPost(registerUrl, postData);
		   	 System.out.println("注册成功，第"+i+"个用户");
		}
       
		
	}
	
	// 驱动__贴__新增__固定用户对固定学校进行发帖
	public void driverTopicAdd__ByOneUserToOneSchool() throws Exception {
		// TODO Auto-generated method stub
		//获取请求头部信息
		String homeUrl= "http://localhost/phpwind/login.php";
		String loginUrl= "http://localhost/phpwind/login.php?";
		String postData= "forward=&jumpurl=http%3A%2F%2Flocalhost%2Fupload%2Fthread.php%3Ffid%3D10&step=2&lgt=0&pwuser=user1&pwpwd=123456&hideid=0&cktime=31536000";
		//ch.getSessionIdByOpenHome(homeUrl);
		//System.out.println("===========");
		ch.getSessionContentByloginHome(loginUrl, postData);
		String a= ch.sendPost(loginUrl, postData);
		//System.out.println(a);
		if(a.contains("您已经顺利登录")) {
			System.out.println("用户登录场景：登录成功");
		}else {
			System.out.println("用户登录场景：登录失败");
		}
		
		
		//获取verify的值
		String verify= "1";
		String fid= "2";
		String verifyGetUrl= "http://localhost/phpwind/post.php?fid="+fid;
		String regex= "(.*name=\"verify\" value=\")(.+)(\" \\/.*)";
		//<input type="hidden" name="verify" value="5eb39861" />
		//String responseVerifyHome= ch.sendGet(verifyGetUrl);
		//System.out.println("=======================");
		//System.out.println(verify);
		verify= ch.getVerifyValueByRegular(verifyGetUrl, regex);
		System.out.println(verify);
		//System.out.println("aaa");
		
		//System.out.println("===================================");
		//正常开始
		String topicAddUrl= "http://localhost/phpwind/post.php?";
		String postDataAdd= "magicname=&magicid=&verify="+verify+"&atc_title=帖子2&atc_iconid=0&atc_content=帖子2&atc_autourl=1&atc_usesign=1&atc_convert=1&digest=0&topped=0&atc_rvrc=0&atc_enhidetype=rvrc&atc_money=0&att_ctype1=money&atc_needrvrc1=0&step=2&pid=&action=new&fid="+fid+"&tid=&article=0&special=0";
		String responseByTopicAdd= new CommonHandler().sendPost(topicAddUrl, postDataAdd);
		System.out.println(responseByTopicAdd);
	}
	
	// 驱动__贴__新增__固定用户对随机学校进行发帖
	public void driverTopicAdd__ByOneUserToRandomSchool__One() throws Exception {
		// TODO Auto-generated method stub
		// 获取请求头部信息
		String homeUrl = "http://localhost/upload/login.php";
		String loginUrl = "http://localhost/upload/login.php?";
		String postData = "forward=&jumpurl=http%3A%2F%2Flocalhost%2Fupload%2Fthread.php%3Ffid%3D10&step=2&lgt=0&pwuser=admin&pwpwd=admin&hideid=0&cktime=31536000";
		// ch.getSessionIdByOpenHome(homeUrl);
		// System.out.println("===========");
		ch.getSessionContentByloginHome(loginUrl, postData);

		// fid取值实现随机 10 18
		// List<String> fids= new ArrayList<String>();
		String fid = "";
		String[] fids = { "10", "11", "12", "13", "14", "15", "16", "17", "18" };
		int tempNum = (int) (Math.random() * 9);
		fid = fids[tempNum];

		// 获取verify的值
		String verify = "";
		// String fid= "10";
		// fid= "10";
		String verifyGetUrl = "http://localhost/upload/post.php?fid=" + fid;
		String regex = "(.*name=\"verify\" value=\")(.+)(\" \\/.*)";
		// <input type="hidden" name="verify" value="5eb39861" />
		// String responseVerifyHome= ch.sendGet(verifyGetUrl);
		// System.out.println("=======================");
		// System.out.println(verify);
		verify = ch.getVerifyValueByRegular(verifyGetUrl, regex);
		// System.out.println(verify);

		// System.out.println("===================================");
		// 正常开始
		String topicAddUrl = "http://localhost/upload/post.php?";
		String postDataAdd = "magicname=&magicid=&verify=" + verify
				+ "&atc_title=帖子2&atc_iconid=0&atc_content=帖子2&atc_autourl=1&atc_usesign=1&atc_convert=1&digest=0&topped=0&atc_rvrc=0&atc_enhidetype=rvrc&atc_money=0&att_ctype1=money&atc_needrvrc1=0&step=2&pid=&action=new&fid="
				+ fid + "&tid=&article=0&special=0";
		String responseByTopicAdd = new CommonHandler().sendPost(topicAddUrl, postDataAdd);
		// System.out.println(responseByTopicAdd);
		System.out.println(fid);

	}
	// 驱动__贴__新增__固定用户对随机学校进行发帖
	public void driverTopicAdd__ByOneUserToRandomSchool__two() throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// 获取请求头部信息
		String homeUrl = "http://localhost/upload/login.php";
		String loginUrl = "http://localhost/upload/login.php?";
		String postData = "forward=&jumpurl=http%3A%2F%2Flocalhost%2Fupload%2Fthread.php%3Ffid%3D10&step=2&lgt=0&pwuser=admin&pwpwd=admin&hideid=0&cktime=31536000";
		// ch.getSessionIdByOpenHome(homeUrl);
		// System.out.println("===========");
		ch.getSessionContentByloginHome(loginUrl, postData);
		
		//获取页面所有fid
		String fidUrl= "http://localhost/upload/index.php";
		String responseFid= ch.sendGet(fidUrl);
		//System.out.println(responseFid);
		//<a href="thread.php?fid=18">成都理工大学</a>
		String regex= "(.*<a href=\"thread.php\\?fid=)(.+?)(\".*)";
		List<String> fidList = ch.getFidValueByRegular(fidUrl, regex);
		int sum= fidList.size();
		//System.err.println(sum);
		int fidSub= (int)(Math.random()*35);
		String fid= fidList.get(fidSub);
		
		// 获取verify的值
		String verify = "";
		// String fid= "10";
		// fid= "10";
		String verifyGetUrl = "http://localhost/upload/post.php?fid=" + fid;
		String regexTwo = "(.*name=\"verify\" value=\")(.+)(\" \\/.*)";
		// <input type="hidden" name="verify" value="5eb39861" />
		// String responseVerifyHome= ch.sendGet(verifyGetUrl);
		// System.out.println("=======================");
		// System.out.println(verify);
		verify = ch.getVerifyValueByRegular(verifyGetUrl, regexTwo);
		// System.out.println(verify);

		// System.out.println("===================================");
		// 正常开始
		String topicAddUrl = "http://localhost/upload/post.php?";
		String postDataAdd = "magicname=&magicid=&verify=" + verify
				+ "&atc_title=帖子4&atc_iconid=0&atc_content=帖子3&atc_autourl=1&atc_usesign=1&atc_convert=1&digest=0&topped=0&atc_rvrc=0&atc_enhidetype=rvrc&atc_money=0&att_ctype1=money&atc_needrvrc1=0&step=2&pid=&action=new&fid="
				+ fid + "&tid=&article=0&special=0";
		String responseByTopicAdd = new CommonHandler().sendPost(topicAddUrl, postDataAdd);
		// System.out.println(responseByTopicAdd);
		System.out.println(fid);

	}
	// 驱动__贴__新增__随机用户对随机学校进行发帖
	public void driverTopicAdd__ByRandomUserToRandomSchool__One() throws Exception {
		// TODO Auto-generated method stub
		//用户的随机选取
		String userName= "user";
		String passWord= "123456";
		int temp= (int)(Math.random()*54);
		userName= userName + temp;
		System.out.println(userName);
		// 获取请求头部信息
		String homeUrl = "http://localhost/upload/login.php";
		String loginUrl = "http://localhost/upload/login.php?";
		String postData = "forward=&jumpurl=http%3A%2F%2Flocalhost%2Fupload%2Fthread.php%3Ffid%3D10&step=2&lgt=0&pwuser="+userName+"&pwpwd="+passWord+"&hideid=0&cktime=31536000";
		//String postData= "forward=&jumpurl=http%3A%2F%2Flocalhost%2Fupload%2Fthread.php%3Ffid%3D10&step=2&lgt=0&pwuser=admin&pwpwd=admin&hideid=0&cktime=31536000";
		// ch.getSessionIdByOpenHome(homeUrl);
		// System.out.println("===========");
		ch.getSessionContentByloginHome(loginUrl, postData);

		// fid取值实现随机 10 18
		// List<String> fids= new ArrayList<String>();
		String fid = "";
		String[] fids = { "10", "11", "12", "13", "14", "15", "16", "17", "18" };
		int tempNum = (int) (Math.random() * 9);
		fid = fids[tempNum];

		// 获取verify的值
		String verify = "";
		// String fid= "10";
		// fid= "10";
		String verifyGetUrl = "http://localhost/upload/post.php?fid=" + fid;
		String regex = "(.*name=\"verify\" value=\")(.+)(\" \\/.*)";
		// <input type="hidden" name="verify" value="5eb39861" />
		// String responseVerifyHome= ch.sendGet(verifyGetUrl);
		// System.out.println("=======================");
		// System.out.println(verify);
		verify = ch.getVerifyValueByRegular(verifyGetUrl, regex);
		// System.out.println(verify);

		// System.out.println("===================================");
		// 正常开始
		String topicAddUrl = "http://localhost/upload/post.php?";
		String postDataAdd = "magicname=&magicid=&verify=" + verify
				+ "&atc_title=帖子2&atc_iconid=0&atc_content=帖子2&atc_autourl=1&atc_usesign=1&atc_convert=1&digest=0&topped=0&atc_rvrc=0&atc_enhidetype=rvrc&atc_money=0&att_ctype1=money&atc_needrvrc1=0&step=2&pid=&action=new&fid="
				+ fid + "&tid=&article=0&special=0";
		String responseByTopicAdd = new CommonHandler().sendPost(topicAddUrl, postDataAdd);
		// System.out.println(responseByTopicAdd);
		System.out.println(fid);

	}
	
	// 驱动__贴__新增__随机用户对随机学校进行发帖
		public void driverTopicAdd__ByRandomUserToRandomSchool__Two() throws Exception {
			// TODO Auto-generated method stub
			//用户的随机选取
			String userName= "user";
			String passWord= "123456";
			int temp= (int)(Math.random()*54);
			userName= userName + temp;
			System.out.println(userName);
			// 获取请求头部信息
			String homeUrl = "http://localhost/upload/login.php";
			String loginUrl = "http://localhost/upload/login.php?";
			String postData = "forward=&jumpurl=http%3A%2F%2Flocalhost%2Fupload%2Fthread.php%3Ffid%3D10&step=2&lgt=0&pwuser="+userName+"&pwpwd="+passWord+"&hideid=0&cktime=31536000";
			//String postData= "forward=&jumpurl=http%3A%2F%2Flocalhost%2Fupload%2Fthread.php%3Ffid%3D10&step=2&lgt=0&pwuser=admin&pwpwd=admin&hideid=0&cktime=31536000";
			// ch.getSessionIdByOpenHome(homeUrl);
			// System.out.println("===========");
			ch.getSessionContentByloginHome(loginUrl, postData);

			// fid取值实现随机 10 18
			// List<String> fids= new ArrayList<String>();
			//String fid = "";
			//String[] fids = { "10", "11", "12", "13", "14", "15", "16", "17", "18" };
			///int tempNum = (int) (Math.random() * 9);
			//fid = fids[tempNum];
			String fidUrl= "http://localhost/upload/index.php";
			String responseFid= ch.sendGet(fidUrl);
			//System.out.println(responseFid);
			//<a href="thread.php?fid=18">成都理工大学</a>
			String regex= "(.*<a href=\"thread.php\\?fid=)(.+?)(\".*)";
			List<String> fidList = ch.getFidValueByRegular(fidUrl, regex);
			int sum= fidList.size();
			//System.err.println(sum);
			int fidSub= (int)(Math.random()*35);
			String fid= fidList.get(fidSub);

			// 获取verify的值
			String verify = "";
			// String fid= "10";
			// fid= "10";
			String verifyGetUrl = "http://localhost/upload/post.php?fid=" + fid;
			String regexTwo = "(.*name=\"verify\" value=\")(.+)(\" \\/.*)";
			// <input type="hidden" name="verify" value="5eb39861" />
			// String responseVerifyHome= ch.sendGet(verifyGetUrl);
			// System.out.println("=======================");
			// System.out.println(verify);
			verify = ch.getVerifyValueByRegular(verifyGetUrl, regexTwo);
			// System.out.println(verify);

			// System.out.println("===================================");
			// 正常开始
			String topicAddUrl = "http://localhost/upload/post.php?";
			String postDataAdd = "magicname=&magicid=&verify=" + verify
					+ "&atc_title=帖子6&atc_iconid=0&atc_content=帖子2&atc_autourl=1&atc_usesign=1&atc_convert=1&digest=0&topped=0&atc_rvrc=0&atc_enhidetype=rvrc&atc_money=0&att_ctype1=money&atc_needrvrc1=0&step=2&pid=&action=new&fid="
					+ fid + "&tid=&article=0&special=0";
			String responseByTopicAdd = new CommonHandler().sendPost(topicAddUrl, postDataAdd);
			// System.out.println(responseByTopicAdd);
			System.out.println(fid);

		}
	
	// 驱动__贴__回复__固定用户对固定学校的固定贴进行回复
	public void driverTopicReply() throws Exception {
		// TODO Auto-generated method stub
		// 获取请求头部信息
		String homeUrl = "http://localhost/upload/login.php";
		String loginUrl = "http://localhost/upload/login.php?";
		String postData = "forward=&jumpurl=http%3A%2F%2Flocalhost%2Fupload%2Fthread.php%3Ffid%3D10&step=2&lgt=0&pwuser=admin&pwpwd=admin&hideid=0&cktime=31536000";
	    //ch.getSessionIdByOpenHome(homeUrl);
		// System.out.println("===========");
		
		//ch.getSessionContentByloginHome__Two(loginUrl, postData);
		ch.getSessionContentByloginHome(loginUrl, postData);

		// 获取verify的值
		String verify = "";
		// String fid= "10";
		String fid= "10";
		String verifyGetUrl = "http://localhost/upload/post.php?fid=" + fid;
		String regex = "(.*name=\"verify\" value=\")(.+)(\" \\/.*)";
		// <input type="hidden" name="verify" value="5eb39861" />
		// String responseVerifyHome= ch.sendGet(verifyGetUrl);
		// System.out.println("=======================");
		// System.out.println(verify);
		verify = ch.getVerifyValueByRegular(verifyGetUrl, regex);
		 System.out.println("========="+verify);
		// 获取verify的值
		//String verify = "";
		
		 //尝试获取其他的verify
		 String tempUrl= "http://localhost/upload/read.php?tid=112 ";
		 String responseArticle= ch.sendGet(tempUrl);
		 //System.out.println(responseArticle);
		 
		// 进行贴的回复
		ch.getSessionContentByloginHome(loginUrl, postData);
		String replyConten = "急急急";
		String tid= "112";
		//String replyUrl = "http://localhost/upload/post.php?"+tid;
		String replyUrl = "http://localhost/upload/post.php?";
		String postDataReply = "atc_usesign=1&atc_convert=1&atc_money=0&atc_rvrc=0&atc_title=帖子6&atc_autourl=1&atc_content="
				+ replyConten
				+ "&step=2&action=reply&fid="+fid+"&tid=112&verify="+verify+"&atc_desc1=&attachment_1=&att_special1=0&att_ctype1=money&atc_needrvrc1=0";
		
		System.out.println(postDataReply);
		String responseByTopicReply= ch.sendPost(replyUrl, postDataReply);
		
		System.err.println("回复成功");
		//System.out.println(responseByTopicReply);
	}
	
	// 回复__测试
	public void driverTestReply() throws Exception {
		// TODO Auto-generated method stub
		// 获取请求头部信息
		String homeUrl = "http://localhost/upload/login.php";
		String loginUrl = "http://localhost/upload/login.php?";
		String postData = "forward=&jumpurl=http%3A%2F%2Flocalhost%2Fupload%2Fthread.php%3Ffid%3D10&step=2&lgt=0&pwuser=admin&pwpwd=admin&hideid=0&cktime=31536000";
		// ch.getSessionIdByOpenHome(homeUrl);
		// System.out.println("===========");
		ch.getSessionContentByloginHome(loginUrl, postData);

		// 获取verify的值
		String verify = "";
		String fid = "10";
		String verifyGetUrl = "http://localhost/upload/post.php?fid=" + fid;
		String regex = "(.*name=\"verify\" value=\")(.+)(\" \\/.*)";
		// <input type="hidden" name="verify" value="5eb39861" />
		// String responseVerifyHome= ch.sendGet(verifyGetUrl);
		// System.out.println("=======================");
		// System.out.println(verify);
		verify = ch.getVerifyValueByRegular(verifyGetUrl, regex);
		// System.out.println(verify);
		String replyContent= "和客户";
		// System.out.println("===================================");
		// 正常开始
		String replyUrl = "http://localhost/upload/post.php?";
		String postDataReply = "atc_usesign=1&atc_convert=1&atc_money=0&atc_rvrc=0&atc_title=帖子6&atc_autourl=1&atc_content="
				+ replyContent
				+ "&step=2&action=reply&fid="+fid+"&tid=112&verify="+verify+"&atc_desc1=&attachment_1=&att_special1=0&att_ctype1=money&atc_needrvrc1=0";
		
		String responseByTopicAdd = new CommonHandler().sendPost(replyUrl, postDataReply);
		// System.out.println(responseByTopicAdd);
		System.out.println(responseByTopicAdd);
	}
	
}
