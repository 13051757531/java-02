package www.woniu.v3;



public class ThreadV01 {
	CommonHandler ch= new CommonHandler();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ThreadV01 tv= new ThreadV01();
		tv.driverTopicAdd__ByOneUserToOneSchool();

	}
	
	public void driverTopicAdd__ByOneUserToOneSchool() throws Exception {
		// TODO Auto-generated method stub
		//获取请求头部信息
		String homeUrl= "http://localhost/phpwind/login.php";
		String loginUrl= "http://localhost/phpwind/login.php?";
		String postData= "forward=&jumpurl=http%3A%2F%2Flocalhost%2Fphpwind%2Findex.php&step=2&lgt=0&pwuser=user1&pwpwd=123456&hideid=0&cktime=31536000";
		//forward=&jumpurl=http%3A%2F%2Flocalhost%2Fphpwind%2Findex.php&step=2&lgt=0&pwuser=user1&pwpwd=123456&hideid=0&cktime=31536000
		//ch.getSessionIdByOpenHome(homeUrl);
		//System.out.println("===========");
		ch.getSessionContentByloginHome(loginUrl, postData);
		//String a= ch.sendPost(loginUrl, postData);
		//System.out.println(a);
		
		
		//获取verify的值
		String verify= "1";
		String fid= "2";
		String verifyGetUrl= "http://localhost/phpwind/post.php?fid="+fid;
		String regex= "(.*name=\"verify\" value=\")(.+)(\" \\/.*)";
		//<input type="hidden" name="verify" value="5eb39861" />
		//String responseVerifyHome= ch.sendGet(verifyGetUrl);
		//System.out.println("=======================");
		verify= ch.getVerifyValueByRegular(verifyGetUrl, regex);
		System.out.println(verify);
		
		//System.out.println("===================================");
		//正常开始
		String topicAddUrl= "http://localhost/phpwind/post.php?";
		String postDataAdd= "magicname=&magicid=&verify="+verify+"&atc_title=帖子2&atc_iconid=0&atc_content=帖子2&atc_autourl=1&atc_usesign=1&atc_convert=1&digest=0&topped=0&atc_rvrc=0&atc_enhidetype=rvrc&atc_money=0&att_ctype1=money&atc_needrvrc1=0&step=2&pid=&action=new&fid="+fid+"&tid=&article=0&special=0";
		String responseByTopicAdd= new CommonHandler().sendPost(topicAddUrl, postDataAdd);
//		System.out.println(responseByTopicAdd);
	}

}
