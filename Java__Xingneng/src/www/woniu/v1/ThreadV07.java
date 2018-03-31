package www.woniu.v1;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadV07  {
	public static void main(String[] args) {
		for(int i=0; i<=20; i++) {
			Threads ta= new Threads(i*100);
			ta.start();
		}

	}
}


class Threads extends Thread {
	Common cm= new Common();
	private int index;
	public Threads(int index) {
		this.index= index;
	}
	@Override
	public void run() {
		for(int j=1; j<=100; j++) {
			System.out.println("线程__"+ this.getName() +"；执行次数："+(this.index+j));
			long start= System.currentTimeMillis();
			this.driverReg_d1(this.index+j);
			long end= System.currentTimeMillis();
			float duration= (float)(end-start)/1000;
			System.out.println("注册响应时间为:"+duration);
		}
	}
	
	private void driverReg_d1() {
		// TODO Auto-generated method stub
		 
		String url = "http://localhost/phpwind/register.php?";
		String data = "forward=&step=2&regname=user1&regpwd=123456&regpwdrepeat=123456&regemail=1154632529@qq.com&regemailtoall=1&rgpermit=1";
		String response = this.cm.sendPost(url, data);
		// System.out.println(response);
		if (response.contains("请返回重试")) {
			System.out.println("注册成功");
		} else {
			System.out.println("注册失败");
		}
	}
	
	private void driverReg_d1(int i) {
		// TODO Auto-generated method stub
		 
		String url = "http://localhost/phpwind/register.php?";
		String data = "forward=&step=2&regname=user"+i+"&regpwd=123456&regpwdrepeat=123456&regemail=115463252"+i+"@qq.com&regemailtoall=1&rgpermit=1";
		String response = this.cm.sendPost(url, data);
		// System.out.println(response);
		if (response.contains("请返回重试")) {
			System.out.println("注册成功");
		} else {
			System.out.println("注册失败");
		}
	}
}

