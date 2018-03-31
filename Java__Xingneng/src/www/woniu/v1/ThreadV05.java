package www.woniu.v1;

//public class ThreadV05 {
//	ThreadV06 tv= new ThreadV06();
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		//ThreadV05 tr = new ThreadV05();
//		//tr.driverReg();
//		//tr.driverReg_V1();
//		new Thread(new Thread1()).start();
//
//	}
//
//}

public class ThreadV05 implements Runnable {
	static int i= 0;
	Common cm = new Common();
//	public ThreadV06(Common  cd) {
//		// TODO Auto-generated constructor stub
//		this.cm= cm;
//	}
//
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ThreadV05 tr = new ThreadV05();
		//tr.driverReg();
		//tr.driverReg_V1();
		//单用户单循环
//		new Thread(new ThreadV05()).start();
		//单用户多循环
		
		//多用户单循环
//		for(int i=0; i<1000; i++) {
//			ThreadV05 tv= new ThreadV05();
//			new Thread(tv).start();
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		//多用户多循环
		for(int i=0; i<1000; i++) {
			ThreadV05 tv= new ThreadV05();
			new Thread(tv).start();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// 单用户多循环
	private void driverReg_c1() {
		// TODO Auto-generated method stub
		for(int i=0; i<8000; i++) {
			String url = "http://localhost/phpwind/register.php?";
			String data = "forward=&step=2&regname=user"+i+"&regpwd=123456&regpwdrepeat=123456&regemail=1154632528"+i+"@qq.com&regemailtoall=1&rgpermit=1";
			String response = this.cm.sendPost(url, data);
			// System.out.println(response);
			if (response.contains("请返回重试")) {
				System.out.println("注册成功,第_" + i + "次");
			} else {
				System.out.println("注册失败");
			}
		}
		
	}
	
	private void driverReg_c2() {
		// TODO Auto-generated method stub
		int i= this.i;
		for(int j=0; j<2; j++) {
			String url = "http://localhost/phpwind/register.php?";
			String data = "forward=&step=2&regname=user"+j+i+"&regpwd=123456&regpwdrepeat=123456&regemail=1154632528"+j+i+"@qq.com&regemailtoall=1&rgpermit=1";
			String response = this.cm.sendPost(url, data);
			// System.out.println(response);
			if (response.contains("请返回重试")) {
				System.out.println("注册成功,第_" + j + "_" + this.i + "次");
			} else {
				System.out.println("注册失败,第_" + j + "_" + this.i + "次");
			}
		}
		i ++;
		this.i= i;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// 单用户单循环
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
	
	private synchronized void driverReg_d2() {
		// TODO Auto-generated method stub
	    int i= this.i;
		String url = "http://localhost/phpwind/register.php?";
		String data = "forward=&step=2&regname=user"+i+"&regpwd=123456&regpwdrepeat=123456&regemail=1154632528"+i+"@qq.com&regemailtoall=1&rgpermit=1";
		String response = this.cm.sendPost(url, data);
		// System.out.println(response);
		if (response.contains("请返回重试")) {
			System.out.println("注册成功");
		} else {
			System.out.println("注册失败");
		}
		i ++;
		this.i= i;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//this.driverReg_d2();
		this.driverReg_c2();
		
	}
}


