package www.woniu.v2;


import java.util.concurrent.atomic.AtomicInteger;

public class DengluDuoxh  {
	
	public static void main(String[] args) {
		for(int i=0; i<=21; i++) {
			Threads3 ta= new Threads3(i*100);
			ta.start();
		}

	}
}


class Threads3 extends Thread {
	Common cm= new Common();
	private int index;
	public Threads3(int index) {
		this.index= index;
	}
	@Override
	public void run() {
		for(int j=1; j<=100; j++) {
			//System.out.println("线程__"+ this.getName() +"；执行次数："+(this.index+j));
			String url_login= "http://localhost/phpwind/login.php?";
			String data_login= "forward=&jumpurl=http%3A%2F%2Flocalhost%2Fphpwind%2Findex.php&step=2&lgt=0&pwuser=user1&pwpwd=123456&hideid=0&cktime=31536000";
			String response= cm.sendPost(url_login, data_login);
	        if(response.contains("您已经顺利登录")) {
	        	System.out.println("线程"+this.getName()+";操作用户:1登录成功,总次数为："+(this.index+j));
	        }else {
	        	System.out.println("登录失败");
	        }
	        cm.clearCookie();
		}
	}
}
