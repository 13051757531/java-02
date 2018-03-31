package www.woniu.phpwind.teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhpWindByMe {
	HttpRequestor hr = new HttpRequestor();
	PhpWindOne po = new PhpWindOne();

	public static void main(String[] args) {
		PhpWindByMe pm = new PhpWindByMe();
		//pm.logout();
		//pm.driverTopicReply_OneUserToOneSchool();
		pm.inteface_runMore();
		//pm.testPost();
		//pm.driverTopicDelete_oneUserToOneSchoolToOneTopic();
		//pm.driverTopicDelete_oneUserToOneSchoolToRnadomTopic_V1();
		//pm.driverTopicDelete_oneUserToRandomSchoolToRnadomTopic_Two_V1();
		//pm.doRegister();
		//pm.randomTidGetted_OfRandomPage_V1();
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
	
	public List<String> getVerifyCode_V2(String response, String regex) {
		List<String> verifyCodes = new ArrayList<String>();
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(response);
		while (m.find()) {
			//verifyCode = m.group(2);
			verifyCodes.add(m.group(2));
		}
		return verifyCodes;
	}

	// 发帖
	public void testPost() {
		po.testLogin();
		String getUrl = "http://localhost/phpwind/post.php?fid=2";
		// http://localhost/upload/login.php?
		String response = hr.sendGet(getUrl);
		//System.out.println(response);
		// 利用左右边界的方式来定位这个动态验证码，与LR和JMeter的关联作用完全一致
		String regex = "(.*verify\" value=\")(.+)(\" />.*)";
		String verifyCode = this.getVerifyCode(response, regex);
		System.out.println(verifyCode);

		System.out.println("===============");

		String postUrl = "http://localhost/phpwind/post.php?";
		// http://localhost/upload/login.php?
		// http://localhost/phpwind/post.php?
		String postData = "magicname=&magicid=&verify=" + verifyCode + "&atc_title=这是帖子的标题-Java-1005&atc_iconid=0"
				+ "&atc_content=这是帖子的内容Java-1005&atc_autourl=1" + "&atc_usesign=1&atc_convert=1&digest=0&topped=0"
				+ "&atc_rvrc=0&atc_enhidetype=rvrc&atc_money=0" + "&atc_credittype=money&atc_desc1=&attachment_1="
				+ "&att_special1=0&att_ctype1=money&atc_needrvrc1=0"
				+ "&step=2&pid=&action=new&fid=2&tid=&article=0&special=0";
		String responsePost = hr.sendPost(postUrl, postData);

		// System.out.println(responsePost);

		if (responsePost.contains("发帖完毕点击进入主题列表")) {
			System.out.println("发帖的验证：成功.");
		} else {
			System.out.println("发帖的验证：失败.");
		}
	}

	// 模拟用户登录系统操作

	// 模拟用户退出系统操作
	public void logout() {
		// TODO Auto-generated method stub
		po.testLogin();//模拟用户登录和退出系统操作
		String verifyCode= "";
		String regex= "(.*action=quit&verify=)(.+)(\">)";//&nbsp;<a href="login.php?action=quit&verify=c9b65888">退出</a>
		String getVerifyUrl= "http://localhost/phpwind/";
		String reponseOfgetVerifyUrl= hr.sendGet(getVerifyUrl); 
		//System.out.println(reponseOfgetVerifyUrl);
	    verifyCode= po.getVerifyCode(reponseOfgetVerifyUrl, regex) ;//获取退出时获取验证码的操作
	    //System.out.println(verifyCode);
	    String logoutUrl= "http://localhost/phpwind/login.php?action=quit&verify=" + verifyCode;
	    String responseOfLogout= hr.sendGet(logoutUrl);
	    //System.out.println(responseOfLogout);
	    if(responseOfLogout.contains("您已经顺利退出网站")) {
	    	System.out.println("恭喜退出操作成功");
	    }  
	    hr.clearCookie();
	    System.out.println("====================");
	}
	public void logout_V2() {
		// TODO Auto-generated method stub
		//po.testLogin();//模拟用户登录和退出系统操作
		String verifyCode= "";
		String regex= "(.*action=quit&verify=)(.+)(\">)";//&nbsp;<a href="login.php?action=quit&verify=c9b65888">退出</a>
		String getVerifyUrl= "http://localhost/phpwind/";
		String reponseOfgetVerifyUrl= hr.sendGet(getVerifyUrl); 
		//System.out.println(reponseOfgetVerifyUrl);
	    verifyCode= po.getVerifyCode(reponseOfgetVerifyUrl, regex) ;//获取退出时获取验证码的操作
	    //System.out.println(verifyCode);
	    String logoutUrl= "http://localhost/phpwind/login.php?action=quit&verify=" + verifyCode;
	    String responseOfLogout= hr.sendGet(logoutUrl);
	    //System.out.println(responseOfLogout);
	    if(responseOfLogout.contains("您已经顺利退出网站")) {
	    	System.out.println("退出操作:成功");
	    }else {
	    	System.out.println("退出操作：失败");
	    }
	    hr.clearCookie();
	    System.out.println("====================");
	}
	//驱动__帖子删除__一个用户对固定学校的固定帖子
	private void driverTopicDelete_oneUserToOneSchoolToOneTopic_V1() {
		// TODO Auto-generated method stub
		po.testLogin();
		String fid= "2";
		String tid= "179";
		//String url__Of__TidGeted= "http://localhost/phpwind/thread.php?fid="+fid;
		String url__Of__VerifyValue= "http://localhost/phpwind/read.php?tid="+tid;
		String url__Of__TopicDeleted= "http://localhost/phpwind/mawhole.php?";
		String regex__Of__VerifyValue= "(.*verify\" value=\")(.+)(\".*)"; //<input type="hidden" name="verify" value="5bca5e4f" />
		String response__Of__VerifyUrl= hr.sendGet(url__Of__VerifyValue);
		//String regex__Of__TidValue= "()(.+)()";//
		String value__Of__Verify= this.getVerifyCode(response__Of__VerifyUrl, regex__Of__VerifyValue);
		//System.out.println(value__Of__Verify);
		
		String data__Of__TopicDeleted= "verify="+value__Of__Verify+"&action=del&fid="+fid+"&step=2&tidarray%5B%5D="+tid+"&ifdel=1&ifmsg=1&atc_content=%E5%98%8E%E5%98%8E%E5%98%8E&Submit=%E6%8F%90+%E4%BA%A4";
		String response__Of__TopicDeleted= hr.sendPost(url__Of__TopicDeleted, data__Of__TopicDeleted);
		//System.out.println(response__Of__TopicDeleted);
		if(response__Of__TopicDeleted.contains("")) {
			System.out.println("删除成功："+"tid="+tid+";fid="+fid);
		}else {
			System.out.println("删除失败："+"tid="+tid+";fid="+fid);
		}
	}
	
	private void driverTopicDelete_oneUserToOneSchoolToOneTopic_V2(String tidNew) {
		// TODO Auto-generated method stub
		//po.testLogin();
		String fid= "2";
		String tid= tidNew;
		//String url__Of__TidGeted= "http://localhost/phpwind/thread.php?fid="+fid;
		String url__Of__VerifyValue= "http://localhost/phpwind/read.php?tid="+tid;
		String url__Of__TopicDeleted= "http://localhost/phpwind/mawhole.php?";
		String regex__Of__VerifyValue= "(.*verify\" value=\")(.+)(\".*)"; //<input type="hidden" name="verify" value="5bca5e4f" />
		String response__Of__VerifyUrl= hr.sendGet(url__Of__VerifyValue);
		//String regex__Of__TidValue= "()(.+)()";//
		String value__Of__Verify= this.getVerifyCode(response__Of__VerifyUrl, regex__Of__VerifyValue);
		//System.out.println(value__Of__Verify);
		
		String data__Of__TopicDeleted= "verify="+value__Of__Verify+"&action=del&fid="+fid+"&step=2&tidarray%5B%5D="+tid+"&ifdel=1&ifmsg=1&atc_content=%E5%98%8E%E5%98%8E%E5%98%8E&Submit=%E6%8F%90+%E4%BA%A4";
		String response__Of__TopicDeleted= hr.sendPost(url__Of__TopicDeleted, data__Of__TopicDeleted);
		//System.out.println(response__Of__TopicDeleted);
		if(response__Of__TopicDeleted.contains("")) {
			System.out.println("删除成功："+"tid="+tid+";fid="+fid);
		}else {
			System.out.println("删除失败："+"tid="+tid+";fid="+fid);
		}
		this.logout_V2();
	}
	
	private void driverTopicDelete_oneUserToOneSchoolToOneTopic_V3(String tidTemp, String fidTemp) {
		// TODO Auto-generated method stub
		//po.testLogin();
		String fid= fidTemp;
		String tid= tidTemp;
		//String url__Of__TidGeted= "http://localhost/phpwind/thread.php?fid="+fid;
		String url__Of__VerifyValue= "http://localhost/phpwind/read.php?tid="+tid;
		String url__Of__TopicDeleted= "http://localhost/phpwind/mawhole.php?";
		String regex__Of__VerifyValue= "(.*verify\" value=\")(.+)(\".*)"; //<input type="hidden" name="verify" value="5bca5e4f" />
		String response__Of__VerifyUrl= hr.sendGet(url__Of__VerifyValue);
		//String regex__Of__TidValue= "()(.+)()";//
		String value__Of__Verify= this.getVerifyCode(response__Of__VerifyUrl, regex__Of__VerifyValue);
		//System.out.println(value__Of__Verify);
		
		String data__Of__TopicDeleted= "verify="+value__Of__Verify+"&action=del&fid="+fid+"&step=2&tidarray%5B%5D="+tid+"&ifdel=1&ifmsg=1&atc_content=%E5%98%8E%E5%98%8E%E5%98%8E&Submit=%E6%8F%90+%E4%BA%A4";
		String response__Of__TopicDeleted= hr.sendPost(url__Of__TopicDeleted, data__Of__TopicDeleted);
		//System.out.println(response__Of__TopicDeleted);
		if(response__Of__TopicDeleted.contains("您的等级不足,没有此管理权限")) {
			System.out.println("用户权限不够，删除失败："+"tid="+tid+";fid="+fid);
		}else {
			System.out.println("删除成功："+"tid="+tid+";fid="+fid);
		}
		//this.logout_V2();
	}
	
	//驱动__帖子删除__一个用户对固定学校的随机帖子
	private void driverTopicDelete_oneUserToOneSchoolToRnadomTopic_V1() {
		// TODO Auto-generated method stub
		//获取灰机的fid
		//po.testLogin();
		String fid= "2";
		String url__Of__TidGetted= "http://localhost/phpwind/thread.php?fid="+fid;
		String response__Of__TidGettedUrl= hr.sendGet(url__Of__TidGetted);
		String regex__Of__TidGetted= "(.*read.php\\?tid=)(.+)(\" id=\"a_ajax_.*)";//<a href="read.php?tid=153" id="a_ajax_153">这是帖子的标题-Java-1005</a></h3>&nbsp;  
		//System.out.println(response__Of__TidGettedUrl);
		//String tidValu= this.getVerifyCode(response__Of__TidGettedUrl, regex__Of__TidGetted);
		//System.out.println(tidValu);
		List<String> Tids= this.getVerifyCode_V2(response__Of__TidGettedUrl, regex__Of__TidGetted);
		//for(int i=0; i<Tids.size(); i++) {
		//	System.out.println(Tids.get(i));
		//}
		//System.out.println(Tids.size());
		if(Tids.size() == 0) {
			System.out.println("该学校的帖子__已经完全删除__学校fid为："+fid);
		}else {
			int num__Random= (int)(Math.random()*(Tids.size()));
			//System.out.println(num__Random);
			String tid= Tids.get(num__Random);
			this.driverTopicDelete_oneUserToOneSchoolToOneTopic_V2(tid);
		}
		
	}
	
	private void driverTopicDelete_oneUserToOneSchoolToRnadomTopic_V2(String fidTemp) {
		// TODO Auto-generated method stub
		//获取灰机的fid
		//po.testLogin();
		//String fid= "2";
		String fid= fidTemp;
		String url__Of__TidGetted= "http://localhost/phpwind/thread.php?fid="+fid;
		String response__Of__TidGettedUrl= hr.sendGet(url__Of__TidGetted);
		String regex__Of__TidGetted= "(.*read.php\\?tid=)(.+)(\" id=\"a_ajax_.*)";//<a href="read.php?tid=153" id="a_ajax_153">这是帖子的标题-Java-1005</a></h3>&nbsp;  
		//System.out.println(response__Of__TidGettedUrl);
		//String tidValu= this.getVerifyCode(response__Of__TidGettedUrl, regex__Of__TidGetted);
		//System.out.println(tidValu);
		List<String> Tids= this.getVerifyCode_V2(response__Of__TidGettedUrl, regex__Of__TidGetted);
		//for(int i=0; i<Tids.size(); i++) {
		//	System.out.println(Tids.get(i));
		//}
		//System.out.println(Tids.size());
		if(Tids.size() == 0) {
			System.out.println("该学校的帖子__已经完全删除__学校fid为："+fid);
		}else {
			int num__Random= (int)(Math.random()*(Tids.size()));
			//System.out.println(num__Random);
			String tid= Tids.get(num__Random);
			this.driverTopicDelete_oneUserToOneSchoolToOneTopic_V2(tid);
		}
		
	}
	
	//驱动__帖子删除__一个用户对随机学校的随机帖子
	private void driverTopicDelete_oneUserToRandomSchoolToRnadomTopic_One_V1() {
		// TODO Auto-generated method stub
		//学校随机
		String[] fids= {"2", "3", "4", "5", "6", "7", "8", "9"};
		int index_RandomFid= (int)(Math.random()*8);
		//System.out.println(index_RandomFid);
		String fid= fids[index_RandomFid];
		//帖子随机
		this.driverTopicDelete_oneUserToOneSchoolToRnadomTopic_V2(fid);
	}
	
	private void driverTopicDelete_oneUserToRandomSchoolToRnadomTopic_Two_V1() {
		// TODO Auto-generated method stub
		//学校随机
		po.testLogin();
		String url__Of__FidGetted= "http://localhost/phpwind/index.php";
		String response__Of__FidGettedUrl= hr.sendGet(url__Of__FidGetted);
		String regex__Of__Fid= "(.*php\\?fid=)(.+)(\" id=.*)";//<h3 class="b"><a href="thread.php?fid=2" id="fn_2">四川理工学院</a></h3>
		//System.out.println(response__Of__FidGettedUrl);
		//String fidValue= this.getVerifyCode(response__Of__FidGettedUrl, regex__Of__Fid);
		//System.out.println(fidValue);
		List<String> fids= this.getVerifyCode_V2(response__Of__FidGettedUrl, regex__Of__Fid);
		//for(int i=0; i<fids.size(); i++) {
		//	System.out.println(fids.get(i));
		//}
		//System.out.println(fids.size());
		int index__Of__RandomFidValue= (int)(Math.random()*fids.size());
		//System.out.println(index__Of__RandomFidValue);
		String fidValue= fids.get(index__Of__RandomFidValue);
		
		//帖子随机
		this.driverTopicDelete_oneUserToOneSchoolToRnadomTopic_V2(fidValue);
		//this.logout_V2();
	}
	
	//驱动__帖子删除__随机用户对随机学校的随机帖子
	private void driverTopicDelete_RandomUserToRandomSchoolToRnadomTopic_V1() {
		// TODO Auto-generated method stub
		// 用户随机
		String userName = this.randomUser();
		po.testLogin_V2(userName);
		// fid随机
		String fid = this.randomFidGetted_V3();
		// tid随机
		 String tid= this.randomTidGetted_V4(fid);
		// System.out.println(userName+";"+fid+";"+tid);
		this.driverTopicDelete_oneUserToOneSchoolToOneTopic_V3(tid, fid);
		this.logout_V2();
	}
	
	
	
	
	
	//驱动__帖子回复__一个用户对一个学校一个帖子
	private void driverTopicReply_OneUserToOneSchoolToOneTopic__V1() {
		// TODO Auto-generated method stub
		po.testLogin();
		String fid= "2";
		String tid= "1";
		//String urlOf_GetVerify= "http://localhost/phpwind/post.php?action=reply&fid=2"+fid+"&tid=1"+tid;
		String url_getVerify= "http://localhost/phpwind/post.php?action=reply&fid="+fid+"&tid="+tid;
		String url_reply= "http://localhost/phpwind/post.php?";
		String content_reply= "测试一";
		//System.out.println(urlOf_GetVerify);
		String response_getVerifyUrl= hr.sendGet(url_getVerify);
		//String regex= "(.*verify=)(.+)(\">退出.*)";//&nbsp;<a href="login.php?action=quit&verify=c9b65888">退出</a>
		String regex= "(.*verify\" value=\")(.+)(\" />)";//<input type="hidden" name="verify" value="f7a02405" />
		//System.out.println(response_getVerifyUrl);
		String verifyValue= po.getVerifyCode(response_getVerifyUrl, regex);
		System.out.println(verifyValue);
		System.out.println("============");
		//String data_reply= "magicname=&magicid=&verify=5bca5e4f&atc_title=阿凡达&atc_iconid=0&atc_content=吴建波&atc_autourl=1&atc_usesign=1&atc_convert=1&atc_rvrc=0&atc_enhidetype=rvrc&atc_money=0&atc_credittype=money&atc_desc1=&attachment_1=&att_special1=0&att_ctype1=money&atc_needrvrc1=0&step=2&pid=&action=reply&fid=2&tid=1&article=&special=0";
		String data_reply= "magicname=&magicid=&verify="+verifyValue+"&atc_title=阿凡达&atc_iconid=0&atc_content="+content_reply+"&atc_autourl=1&atc_usesign=1&atc_convert=1&atc_rvrc=0&atc_enhidetype=rvrc&atc_money=0&atc_credittype=money&atc_desc1=&attachment_1=&att_special1=0&att_ctype1=money&atc_needrvrc1=0&step=2&pid=&action=reply&fid="+fid+"&tid="+tid+"&article=&special=0";
		System.out.println(data_reply);
		System.out.println("====");
		String response__reply= hr.sendPost(url_reply, data_reply);
		//System.out.println(response__reply);
		if(response__reply.contains("发帖完毕点击进入主题列表")) {
			System.out.println("回帖成功");
		}else {
			System.out.println("回帖不成功");
		}
		this.logout();
	}
	
	private void driverTopicReply_OneUserToOneSchoolToOneTopic__V2(String tidTemp) {
		// TODO Auto-generated method stub
		//po.testLogin();
		String fid= "2";
		String tid= tidTemp;
		//String urlOf_GetVerify= "http://localhost/phpwind/post.php?action=reply&fid=2"+fid+"&tid=1"+tid;
		String url_getVerify= "http://localhost/phpwind/post.php?action=reply&fid="+fid+"&tid="+tid;
		String url_reply= "http://localhost/phpwind/post.php?";
		String content_reply= "测试一";
		//System.out.println(urlOf_GetVerify);
		String response_getVerifyUrl= hr.sendGet(url_getVerify);
		//String regex= "(.*verify=)(.+)(\">退出.*)";//&nbsp;<a href="login.php?action=quit&verify=c9b65888">退出</a>
		String regex= "(.*verify\" value=\")(.+)(\" />)";//<input type="hidden" name="verify" value="f7a02405" />
		//System.out.println(response_getVerifyUrl);
		String verifyValue= po.getVerifyCode(response_getVerifyUrl, regex);
		System.out.println(verifyValue);
		System.out.println("============");
		//String data_reply= "magicname=&magicid=&verify=5bca5e4f&atc_title=阿凡达&atc_iconid=0&atc_content=吴建波&atc_autourl=1&atc_usesign=1&atc_convert=1&atc_rvrc=0&atc_enhidetype=rvrc&atc_money=0&atc_credittype=money&atc_desc1=&attachment_1=&att_special1=0&att_ctype1=money&atc_needrvrc1=0&step=2&pid=&action=reply&fid=2&tid=1&article=&special=0";
		String data_reply= "magicname=&magicid=&verify="+verifyValue+"&atc_title=阿凡达&atc_iconid=0&atc_content="+content_reply+"&atc_autourl=1&atc_usesign=1&atc_convert=1&atc_rvrc=0&atc_enhidetype=rvrc&atc_money=0&atc_credittype=money&atc_desc1=&attachment_1=&att_special1=0&att_ctype1=money&atc_needrvrc1=0&step=2&pid=&action=reply&fid="+fid+"&tid="+tid+"&article=&special=0";
		//System.out.println(data_reply);
		System.out.println("====");
		String response__reply= hr.sendPost(url_reply, data_reply);
		//System.out.println(response__reply);
		if(response__reply.contains("发帖完毕点击进入主题列表")) {
			System.out.println("回帖成功:"+"fid="+fid+";tid="+tid);
		}else {
			System.out.println("回帖不成功");
		}
		//this.logout();
	}
	
	private void driverTopicReply_OneUserToOneSchoolToOneTopic__V3(String tidTemp, String fidTemp) {
		// TODO Auto-generated method stub
		//po.testLogin();
		//String fid= "2";
		String fid= fidTemp;
		String tid= tidTemp;
		//String urlOf_GetVerify= "http://localhost/phpwind/post.php?action=reply&fid=2"+fid+"&tid=1"+tid;
		String url_getVerify= "http://localhost/phpwind/post.php?action=reply&fid="+fid+"&tid="+tid;
		String url_reply= "http://localhost/phpwind/post.php?";
		String content_reply= "测试一";
		//System.out.println(urlOf_GetVerify);
		String response_getVerifyUrl= hr.sendGet(url_getVerify);
		//String regex= "(.*verify=)(.+)(\">退出.*)";//&nbsp;<a href="login.php?action=quit&verify=c9b65888">退出</a>
		String regex= "(.*verify\" value=\")(.+)(\" />)";//<input type="hidden" name="verify" value="f7a02405" />
		//System.out.println(response_getVerifyUrl);
		String verifyValue= po.getVerifyCode(response_getVerifyUrl, regex);
		System.out.println(verifyValue);
		System.out.println("============");
		//String data_reply= "magicname=&magicid=&verify=5bca5e4f&atc_title=阿凡达&atc_iconid=0&atc_content=吴建波&atc_autourl=1&atc_usesign=1&atc_convert=1&atc_rvrc=0&atc_enhidetype=rvrc&atc_money=0&atc_credittype=money&atc_desc1=&attachment_1=&att_special1=0&att_ctype1=money&atc_needrvrc1=0&step=2&pid=&action=reply&fid=2&tid=1&article=&special=0";
		String data_reply= "magicname=&magicid=&verify="+verifyValue+"&atc_title=阿凡达&atc_iconid=0&atc_content="+content_reply+"&atc_autourl=1&atc_usesign=1&atc_convert=1&atc_rvrc=0&atc_enhidetype=rvrc&atc_money=0&atc_credittype=money&atc_desc1=&attachment_1=&att_special1=0&att_ctype1=money&atc_needrvrc1=0&step=2&pid=&action=reply&fid="+fid+"&tid="+tid+"&article=&special=0";
		//System.out.println(data_reply);
		System.out.println("====");
		String response__reply= hr.sendPost(url_reply, data_reply);
		//System.out.println(response__reply);
		if(response__reply.contains("发帖完毕点击进入主题列表")) {
			System.out.println("回帖成功:"+"fid="+fid+";tid="+tid);
		}else {
			System.out.println("回帖不成功");
		}
		//this.logout();
	}
	
	//驱动__帖子回复__一个用户对一个学校随机帖子
	private void driverTopicReply_OneUserToOneSchoolToRandomTopic__V1() {
		// TODO Auto-generated method stub
		po.testLogin();
		//随机帖子tid获取
		String fid= "2";
		String url__Of__TidGetted= "http://localhost/phpwind/thread.php?fid="+fid;
		String response__Of__TidGettedUrl= hr.sendGet(url__Of__TidGetted);
		String regex__Of__TidGetted= "(.*read.php\\?tid=)(.+)(\" id=\"a_ajax_.*)";//<a href="read.php?tid=153" id="a_ajax_153">这是帖子的标题-Java-1005</a></h3>&nbsp;  
		//System.out.println(response__Of__TidGettedUrl);
		//String tidValu= this.getVerifyCode(response__Of__TidGettedUrl, regex__Of__TidGetted);
		//System.out.println(tidValu);
		List<String> Tids= this.getVerifyCode_V2(response__Of__TidGettedUrl, regex__Of__TidGetted);
		
		//进行回帖操作
		if(Tids.size() == 0) {
			System.out.println("该学校的帖子__还没有__学校fid为："+fid);
		}else {
			int num__Random= (int)(Math.random()*(Tids.size()));
			//System.out.println(num__Random);
			String tid= Tids.get(num__Random);
			this.driverTopicReply_OneUserToOneSchoolToOneTopic__V2(tid);
		}
		
		this.logout_V2();
	}
	
	//驱动__帖子回复__一个用户对随机学校随机帖子
	private void driverTopicReply_OneUserToRandomSchoolToRandomTopic__V1() {
		// TODO Auto-generated method stub
		po.testLogin();
		// 随机帖子tid获取
		//String fid = "2";
		String fidValue = this.randomFidGetted_V3();
		String tidvalue= this.randomTidGetted_V4(fidValue);
		// 进行回帖操作
		if (fidValue.equals("") || tidvalue.equals("")) {
			System.out.println("学校或帖子不存在：" +"fidValue="+ fidValue+";tidvalue="+tidvalue);
		} else {
			this.driverTopicReply_OneUserToOneSchoolToOneTopic__V3(tidvalue, fidValue);
		}

		this.logout_V2();
	}
		
	// 驱动__帖子回复__随机用户对随机学校随机帖子
	private void driverTopicReply_RandomUserToRandomSchoolToRandomTopic__V1() {
		// TODO Auto-generated method stub
		// 用户随机
		String userName = this.randomUser();
		po.testLogin_V2(userName);
		// fid随机
		String fid = this.randomFidGetted_V3();
		// tid随机
		String tid = this.randomTidGetted_V4(fid);
		// System.out.println(userName+";"+fid+";"+tid);

		this.driverTopicReply_OneUserToOneSchoolToOneTopic__V3(tid, fid);
		this.logout_V2();
	}
	
	private void driverTopicReply_RandomUserToRandomSchoolToRandomTopic__V2() {
		// TODO Auto-generated method stub
		// 用户随机
		String userName = this.randomUser();
		po.testLogin_V2(userName);
		// fid随机
		String fid = this.randomFidGetted_V3();
		// tid随机
		String tid = this.randomTidGetted_RandomSchooRandomPage_V2(fid);
		// System.out.println(userName+";"+fid+";"+tid);

		this.driverTopicReply_OneUserToOneSchoolToOneTopic__V3(tid, fid);
		this.logout_V2();
	}
	
	//驱动__发帖__固定户对固定学校  fid=2,9
	public void driverTopicAdd_OneUserToOneSchool_V1() {
		String getUrl = "http://localhost/phpwind/post.php?fid=2";
		// http://localhost/upload/login.php?
		String response = hr.sendGet(getUrl);
		// System.out.println(response);
		// 利用左右边界的方式来定位这个动态验证码，与LR和JMeter的关联作用完全一致
		String regex = "(.*verify\" value=\")(.+)(\" />.*)";
		String verifyCode = this.getVerifyCode(response, regex);
		System.out.println(verifyCode);

		System.out.println("===============");

		String postUrl = "http://localhost/phpwind/post.php?";
		// http://localhost/upload/login.php?
		// http://localhost/phpwind/post.php?
		String postData = "magicname=&magicid=&verify=" + verifyCode + "&atc_title=这是帖子的标题-Java-1005&atc_iconid=0"
				+ "&atc_content=这是帖子的内容Java-1005&atc_autourl=1" + "&atc_usesign=1&atc_convert=1&digest=0&topped=0"
				+ "&atc_rvrc=0&atc_enhidetype=rvrc&atc_money=0" + "&atc_credittype=money&atc_desc1=&attachment_1="
				+ "&att_special1=0&att_ctype1=money&atc_needrvrc1=0"
				+ "&step=2&pid=&action=new&fid=2&tid=&article=0&special=0";
		String responsePost = hr.sendPost(postUrl, postData);

		// System.out.println(responsePost);

		if (responsePost.contains("发帖完毕点击进入主题列表")) {
			System.out.println("发帖的验证：成功.");
		} else {
			System.out.println("发帖的验证：失败.");
		}
		this.logout();
	}
	
	public void driverTopicAdd_OneUserToOneSchool_V2(String fidValue) {
		
		String fid= fidValue;
		//po.testLogin();
		String getUrl = "http://localhost/phpwind/post.php?fid="+fid;
		// http://localhost/upload/login.php?
		String response = hr.sendGet(getUrl);
		// System.out.println(response);
		// 利用左右边界的方式来定位这个动态验证码，与LR和JMeter的关联作用完全一致
		String regex = "(.*verify\" value=\")(.+)(\" />.*)";
		String verifyCode = this.getVerifyCode(response, regex);
		System.out.println(verifyCode);

		System.out.println("===============");

		String postUrl = "http://localhost/phpwind/post.php?";
		// http://localhost/upload/login.php?
		// http://localhost/phpwind/post.php?
		String postData = "magicname=&magicid=&verify=" + verifyCode + "&atc_title=这是帖子的标题-Java-1005&atc_iconid=0"
				+ "&atc_content=这是帖子的内容Java-1005&atc_autourl=1" + "&atc_usesign=1&atc_convert=1&digest=0&topped=0"
				+ "&atc_rvrc=0&atc_enhidetype=rvrc&atc_money=0" + "&atc_credittype=money&atc_desc1=&attachment_1="
				+ "&att_special1=0&att_ctype1=money&atc_needrvrc1=0"
				+ "&step=2&pid=&action=new&fid="+fid+"&tid=&article=0&special=0";
		String responsePost = hr.sendPost(postUrl, postData);

		// System.out.println(responsePost);

		if (responsePost.contains("发帖完毕点击进入主题列表")) {
			System.out.println("发帖的验证：成功."+fid);
		} else {
			System.out.println("发帖的验证：失败.");
		}
		//this.logout();
	}


	
	//驱动__发帖__单用户对随机学校  fid=2,9
	private void driverTopicAdd_OneUserToRandomSchoo() {
		// TODO Auto-generated method stub
		String[] fids= {"2", "3", "4", "5", "6", "7", "8", "9"};
		int index_random= (int)(Math.random()*8);
		//System.out.println(index_random);
		String fid= fids[index_random];
		this.driverTopicAdd_OneUserToOneSchool_V2(fid);
		
	}
	//驱动__发帖__随机用户对随机学校  fid=2,9
	private void driverTopicAdd_RandomUserToRandomSchoo() {
		// TODO Auto-generated method stub
		//用户随机
		String userName= this.randomUser();
		po.testLogin_V2(userName);
		//fid随机
		String fid= this.randomFidGetted_V3();
		fid= "2";
		//tid随机
		//String tid= this.randomTidGetted_V4(fid);
		//System.out.println(userName+";"+fid+";"+tid);
		this.driverTopicAdd_OneUserToOneSchool_V2(fid);
		this.logout_V2();
	}
	
	//随机学校获取
	private void randomFidGetted_V1() {
		// TODO Auto-generated method stub
		po.testLogin();
		String url__Of__FidGetted= "http://localhost/phpwind/index.php";
		String response__Of__FidGettedUrl= hr.sendGet(url__Of__FidGetted);
		String regex__Of__Fid= "(.*php\\?fid=)(.+)(\" id=.*)";//<h3 class="b"><a href="thread.php?fid=2" id="fn_2">四川理工学院</a></h3>
		//System.out.println(response__Of__FidGettedUrl);
		//String fidValue= this.getVerifyCode(response__Of__FidGettedUrl, regex__Of__Fid);
		//System.out.println(fidValue);
		List<String> fids= this.getVerifyCode_V2(response__Of__FidGettedUrl, regex__Of__Fid);
		//for(int i=0; i<fids.size(); i++) {
		//	System.out.println(fids.get(i));
		//}
		//System.out.println(fids.size());
		int index__Of__RandomFidValue= (int)(Math.random()*fids.size());
		//System.out.println(index__Of__RandomFidValue);
		String fidValue= fids.get(index__Of__RandomFidValue);
		System.out.println(fidValue);
		this.logout_V2();
	}
	private String randomFidGetted_V2() {
		// TODO Auto-generated method stub
		//po.testLogin();
		String url__Of__FidGetted= "http://localhost/phpwind/index.php";
		String response__Of__FidGettedUrl= hr.sendGet(url__Of__FidGetted);
		String regex__Of__Fid= "(.*php\\?fid=)(.+)(\" id=.*)";//<h3 class="b"><a href="thread.php?fid=2" id="fn_2">四川理工学院</a></h3>
		//System.out.println(response__Of__FidGettedUrl);
		//String fidValue= this.getVerifyCode(response__Of__FidGettedUrl, regex__Of__Fid);
		//System.out.println(fidValue);
		List<String> fids= this.getVerifyCode_V2(response__Of__FidGettedUrl, regex__Of__Fid);
		//for(int i=0; i<fids.size(); i++) {
		//	System.out.println(fids.get(i));
		//}
		//System.out.println(fids.size());
		int index__Of__RandomFidValue= (int)(Math.random()*fids.size());
		//System.out.println(index__Of__RandomFidValue);
		String fidValue= fids.get(index__Of__RandomFidValue);
		//System.out.println(fidValue);
		//this.logout_V2();
		return fidValue;
	}
	
	private String randomFidGetted_V3() {
		// TODO Auto-generated method stub
		//po.testLogin();
		String url__Of__FidGetted= "http://localhost/phpwind/index.php";
		String response__Of__FidGettedUrl= hr.sendGet(url__Of__FidGetted);
		String regex__Of__Fid= "(.*php\\?fid=)(.+)(\" id=.*)";//<h3 class="b"><a href="thread.php?fid=2" id="fn_2">四川理工学院</a></h3>
		//System.out.println(response__Of__FidGettedUrl);
		//String fidValue= this.getVerifyCode(response__Of__FidGettedUrl, regex__Of__Fid);
		//System.out.println(fidValue);
		List<String> fids= this.getVerifyCode_V2(response__Of__FidGettedUrl, regex__Of__Fid);
		String fidValue= this.arrrayISNull(fids, "学校");
		return fidValue;
	}
	
	//随机帖子获取
	private void randomTidGetted_V1() {
		// TODO Auto-generated method stub
		po.testLogin();
		//随机帖子tid获取
		//String fid= "2";
		String fid= this.randomFidGetted_V2();
		String url__Of__TidGetted= "http://localhost/phpwind/thread.php?fid="+fid;
		String response__Of__TidGettedUrl= hr.sendGet(url__Of__TidGetted);
		String regex__Of__TidGetted= "(.*read.php\\?tid=)(.+)(\" id=\"a_ajax_.*)";//<a href="read.php?tid=153" id="a_ajax_153">这是帖子的标题-Java-1005</a></h3>&nbsp;  
		//System.out.println(response__Of__TidGettedUrl);
		//String tidValu= this.getVerifyCode(response__Of__TidGettedUrl, regex__Of__TidGetted);
		//System.out.println(tidValu);
		List<String> Tids= this.getVerifyCode_V2(response__Of__TidGettedUrl, regex__Of__TidGetted);
		//System.out.println(Tids.size());
		String tid= "";
		if(Tids.size() == 0) {
			System.out.println("该学校的帖子__还没有__学校fid为："+fid);
		}else {
			int num__Random= (int)(Math.random()*(Tids.size()));
			//System.out.println(num__Random);
			tid= Tids.get(num__Random);
			//this.driverTopicReply_OneUserToOneSchoolToOneTopic__V2(tid);
		}
		System.out.println(tid);
	}
	
	private String randomTidGetted_V2() {
		// TODO Auto-generated method stub
		po.testLogin();
		//随机帖子tid获取
		//String fid= "2";
		String fid= this.randomFidGetted_V2();
		String url__Of__TidGetted= "http://localhost/phpwind/thread.php?fid="+fid;
		String response__Of__TidGettedUrl= hr.sendGet(url__Of__TidGetted);
		String regex__Of__TidGetted= "(.*read.php\\?tid=)(.+)(\" id=\"a_ajax_.*)";//<a href="read.php?tid=153" id="a_ajax_153">这是帖子的标题-Java-1005</a></h3>&nbsp;  
		//System.out.println(response__Of__TidGettedUrl);
		//String tidValu= this.getVerifyCode(response__Of__TidGettedUrl, regex__Of__TidGetted);
		//System.out.println(tidValu);
		List<String> Tids= this.getVerifyCode_V2(response__Of__TidGettedUrl, regex__Of__TidGetted);
		//System.out.println(Tids.size());
		String tid= "";
		if(Tids.size() == 0) {
			System.out.println("该学校的帖子__还没有__学校fid为："+fid);
		}else {
			int num__Random= (int)(Math.random()*(Tids.size()));
			//System.out.println(num__Random);
			tid= Tids.get(num__Random);
			//this.driverTopicReply_OneUserToOneSchoolToOneTopic__V2(tid);
		}
		//System.out.println(tid);
		return tid;
	}
	private String randomTidGetted_V3(String fidValue) {
		// TODO Auto-generated method stub
		po.testLogin();
		//随机帖子tid获取
		//String fid= "2";
		//String fid= this.randomFidGetted_V2();
		String fid= fidValue;
		String url__Of__TidGetted= "http://localhost/phpwind/thread.php?fid="+fid;
		String response__Of__TidGettedUrl= hr.sendGet(url__Of__TidGetted);
		String regex__Of__TidGetted= "(.*read.php\\?tid=)(.+)(\" id=\"a_ajax_.*)";//<a href="read.php?tid=153" id="a_ajax_153">这是帖子的标题-Java-1005</a></h3>&nbsp;  
		//System.out.println(response__Of__TidGettedUrl);
		//String tidValu= this.getVerifyCode(response__Of__TidGettedUrl, regex__Of__TidGetted);
		//System.out.println(tidValu);
		List<String> Tids= this.getVerifyCode_V2(response__Of__TidGettedUrl, regex__Of__TidGetted);
		//System.out.println(Tids.size());
		String tid= "";
		if(Tids.size() == 0) {
			System.out.println("该学校的帖子__还没有__学校fid为："+fid);
		}else {
			int num__Random= (int)(Math.random()*(Tids.size()));
			//System.out.println(num__Random);
			tid= Tids.get(num__Random);
			//this.driverTopicReply_OneUserToOneSchoolToOneTopic__V2(tid);
		}
		//System.out.println(tid);
		return tid;
	}
	
	private String randomTidGetted_V4(String fidValue) {
		// TODO Auto-generated method stub
		//po.testLogin();
		//随机帖子tid获取
		//String fid= "2";
		//String fid= this.randomFidGetted_V2();
		String fid= fidValue;
		String url__Of__TidGetted= "http://localhost/phpwind/thread.php?fid="+fid;
		String response__Of__TidGettedUrl= hr.sendGet(url__Of__TidGetted);
		String regex__Of__TidGetted= "(.*read.php\\?tid=)(.+)(\" id=\"a_ajax_.*)";//<a href="read.php?tid=153" id="a_ajax_153">这是帖子的标题-Java-1005</a></h3>&nbsp;  
		//System.out.println(response__Of__TidGettedUrl);
		//String tidValu= this.getVerifyCode(response__Of__TidGettedUrl, regex__Of__TidGetted);
		//System.out.println(tidValu);
		List<String> Tids= this.getVerifyCode_V2(response__Of__TidGettedUrl, regex__Of__TidGetted);
		//System.out.println(Tids.size());
		String tid= this.arrrayISNull(Tids, "帖子");
		return tid;
	}
	
	//固定学校的随机页码
	private void randomTidGetted_oneSchoolRandomPage_V1() {
		// TODO Auto-generated method stub
		po.testLogin();
		//随机帖子tid获取
		//固定学校随机页的获取
		String fid= "2";
		//String fid= this.rand
		//String fid= this.randomFidGetted_V2();
		String url__Of__TidGetted= "http://localhost/phpwind/thread.php?fid="+fid;
		String response__Of__TidGettedUrl= hr.sendGet(url__Of__TidGetted);
		//System.out.println(response__Of__TidGettedUrl);
		//<span class="pagesone">Pages: 1/4&nbsp; &nbsp; &nbsp;Go 
		String regex__Page= "(.*Pages: 1/)(.+)(&nbsp; &nbsp; &nbsp.*)";//<a href="thread.php?fid=2&page=1" class="b">
		String result= this.getVerifyCode(response__Of__TidGettedUrl, regex__Page);
		//System.out.println(result);
		int pageCount= Integer.parseInt(result);
		List<String> listPage= new ArrayList<String>();
		for(int i=0; i<pageCount; i++) {
			listPage.add((i+1)+"");
		}
		//for(int i=0; i<listPage.size(); i++) {
		//	System.out.println(listPage.get(i));
		//}
		//int max= listPage.size()+1;
		int index__RandomPage= (int)(Math.random()*listPage.size());
		//System.out.println(index__RandomPage);
		String pageValue= listPage.get(index__RandomPage);
		//获取随机页的tid
		String url__getTid= "http://localhost/phpwind/thread.php?fid="+fid+"&page=" + pageValue;
		String response_GetTidByRandomPage= hr.sendGet(url__getTid);
		String taken= "&fpage="+pageValue; 
		String response_GetTid= response_GetTidByRandomPage.replace(taken, "");
		//System.out.println(response_GetTidByRandomPage);
		System.out.println("页码是："+pageValue+"；学校是："+fid);
		String regex__TidGetted= "(.*read.php\\?tid=)(.+?)(\" id=\"a_ajax_.*)";
		List<String> list= this.getVerifyCode_V2(response_GetTid, regex__TidGetted);
		//System.out.println(list.size());
		//for(int i=0; i<list.size(); i++) {
		//	System.out.println(list.get(i));
		//}
		int index__TidRandom= (int)(Math.random()*list.size());
		String tidValue= list.get(index__TidRandom);
		System.out.println(tidValue);
		this.logout_V2();
	}
	//随机学校的随机页码
	private void randomTidGetted_RandomSchooRandomPage_V1() {
		// TODO Auto-generated method stub
		po.testLogin();
		//随机帖子tid获取
		//固定学校随机页的获取
		//String fid= "2";
		String fid= this.randomFidGetted_V2();
		//String fid= this.randomFidGetted_V2();
		String url__Of__TidGetted= "http://localhost/phpwind/thread.php?fid="+fid;
		String response__Of__TidGettedUrl= hr.sendGet(url__Of__TidGetted);
		//System.out.println(response__Of__TidGettedUrl);
		//<span class="pagesone">Pages: 1/4&nbsp; &nbsp; &nbsp;Go 
		String regex__Page= "(.*Pages: 1/)(.+)(&nbsp; &nbsp; &nbsp.*)";//<a href="thread.php?fid=2&page=1" class="b">
		String result= this.getVerifyCode(response__Of__TidGettedUrl, regex__Page);
		//System.out.println(result);
		int pageCount= Integer.parseInt(result);
		List<String> listPage= new ArrayList<String>();
		for(int i=0; i<pageCount; i++) {
			listPage.add((i+1)+"");
		}
		//for(int i=0; i<listPage.size(); i++) {
		//	System.out.println(listPage.get(i));
		//}
		//int max= listPage.size()+1;
		int index__RandomPage= (int)(Math.random()*listPage.size());
		//System.out.println(index__RandomPage);
		String pageValue= listPage.get(index__RandomPage);
		//获取随机页的tid
		String url__getTid= "http://localhost/phpwind/thread.php?fid="+fid+"&page=" + pageValue;
		String response_GetTidByRandomPage= hr.sendGet(url__getTid);
		String taken= "&fpage="+pageValue; 
		String response_GetTid= response_GetTidByRandomPage.replace(taken, "");
		//System.out.println(response_GetTidByRandomPage);
		System.out.println("页码是："+pageValue+"；学校是："+fid);
		String regex__TidGetted= "(.*read.php\\?tid=)(.+?)(\" id=\"a_ajax_.*)";
		List<String> list= this.getVerifyCode_V2(response_GetTid, regex__TidGetted);
		//System.out.println(list.size());
		//for(int i=0; i<list.size(); i++) {
		//	System.out.println(list.get(i));
		//}
		int index__TidRandom= (int)(Math.random()*list.size());
		String tidValue= list.get(index__TidRandom);
		System.out.println(tidValue);
		this.logout_V2();
	}
	
	
	private String randomTidGetted_RandomSchooRandomPage_V2(String fidTemp) {
		// TODO Auto-generated method stub
		//po.testLogin();
		//随机帖子tid获取
		//固定学校随机页的获取
		//String fid= "2";
		String fid= fidTemp;
		//String fid= this.randomFidGetted_V2();
		String url__Of__TidGetted= "http://localhost/phpwind/thread.php?fid="+fid;
		String response__Of__TidGettedUrl= hr.sendGet(url__Of__TidGetted);
		//System.out.println(response__Of__TidGettedUrl);
		//<span class="pagesone">Pages: 1/4&nbsp; &nbsp; &nbsp;Go 
		String regex__Page= "(.*Pages: 1/)(.+)(&nbsp; &nbsp; &nbsp.*)";//<a href="thread.php?fid=2&page=1" class="b">
		String result= this.getVerifyCode(response__Of__TidGettedUrl, regex__Page);
		//System.out.println(result);
		int pageCount= Integer.parseInt(result);
		List<String> listPage= new ArrayList<String>();
		for(int i=0; i<pageCount; i++) {
			listPage.add((i+1)+"");
		}
		//for(int i=0; i<listPage.size(); i++) {
		//	System.out.println(listPage.get(i));
		//}
		//int max= listPage.size()+1;
		int index__RandomPage= (int)(Math.random()*listPage.size());
		//System.out.println(index__RandomPage);
		String pageValue= listPage.get(index__RandomPage);
		//获取随机页的tid
		String url__getTid= "http://localhost/phpwind/thread.php?fid="+fid+"&page=" + pageValue;
		String response_GetTidByRandomPage= hr.sendGet(url__getTid);
		String taken= "&fpage="+pageValue; 
		String response_GetTid= response_GetTidByRandomPage.replace(taken, "");
		//System.out.println(response_GetTidByRandomPage);
		System.out.println("页码是："+pageValue+"；学校是："+fid);
		String regex__TidGetted= "(.*read.php\\?tid=)(.+?)(\" id=\"a_ajax_.*)";
		List<String> list= this.getVerifyCode_V2(response_GetTid, regex__TidGetted);
		//System.out.println(list.size());
		//for(int i=0; i<list.size(); i++) {
		//	System.out.println(list.get(i));
		//}
		int index__TidRandom= (int)(Math.random()*list.size());
		String tidValue= list.get(index__TidRandom);
		//System.out.println(tidValue);
		//this.logout_V2();
		return tidValue;
	}
	
	//用户随机
	private String randomUser() {
		// TODO Auto-generated method stub
		int index= (int)(Math.random()*51);
		System.out.println(index);
		String userName= "user" + index;
		return userName;
	}
	//列表进行条件判断
	private String arrrayISNull(List<String> list, String notice) {
		// TODO Auto-generated method stub
		String result= "";
		List<String> tempArray= list;
		if(tempArray.size() == 0) {
			System.out.println("对不起！" + notice + "不存在");
		}else {
			System.out.println(notice + "：存在");
			int num__Random= (int)(Math.random()*(tempArray.size()));
			//System.out.println(num__Random);
			result= tempArray.get(num__Random);
			//this.driverTopicReply_OneUserToOneSchoolToOneTopic__V2(tid);
		}
		return result;
	}
	
	// 注册
	public void doRegister() {
		for (int i = 2; i <= 50; i++) {
			String postUrl = "http://localhost/phpwind/register.php?";
			// http://localhost/upload/login.php?
			//http://localhost/phpwind/register.php?
			String postData = "forward=&step=2&regname=user" + i + "&regpwd=123456&regpwdrepeat=123456"
					+ "&regemail=javauser" + i + "%40woniuxy.com&rgpermit=1";
			String response= hr.sendPost(postUrl, postData);
			//System.out.println(response);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
	
	//调试__循环调用接口
	private void inteface_runMore() {
		// TODO Auto-generated method stub
		//po.testLogin();
		for(int i=0; i<100; i++){
			//this.driverTopicAdd_OneUserToRandomSchoo();
			//this.driverTopicDelete_oneUserToOneSchoolToRnadomTopic_V1();
			//this.logout();
			//this.driverTopicDelete_oneUserToRandomSchoolToRnadomTopic_One_V1();
			//this.driverTopicDelete_oneUserToRandomSchoolToRnadomTopic_Two_V1();
			//this.driverTopicReply_OneUserToOneSchoolToRandomTopic__V1();
			//this.randomFidGetted_V1();
			//this.randomTidGetted_V2();
			//this.randomFidGetted_V3();
			//this.randomTidGetted_V4(this.randomFidGetted_V3());
			//this.driverTopicReply_OneUserToRandomSchoolToRandomTopic__V1();
			//this.randomUser();
			//this.driverTopicAdd_RandomUserToRandomSchoo();
			//this.driverTopicReply_RandomUserToRandomSchoolToRandomTopic__V1();
			//this.driverTopicDelete_RandomUserToRandomSchoolToRnadomTopic_V1();
			//this.randomTidGetted_OfRandomPage_V2();
			this.driverTopicReply_RandomUserToRandomSchoolToRandomTopic__V2();
		}
	}
	
	
}
