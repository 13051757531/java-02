package www.woniu.v8;

public class Join$test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Join$test j= new Join$test();
		//float start= System.currentTimeMillis();
		for(int i=0; i<800; i++) {
			Threads$control t= new Threads$control();
			t.start();
			
//			try {
//				t.join();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		//float end= System.currentTimeMillis();
		//float dur= end - start;
		//System.out.println(dur);
		//System.out.println("a");

	}
}



class Threads$control extends Thread {
	PhpWind$Process pw= new  PhpWind$Process();
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i<2; i++) {
			pw.doLogin();
			
		}
	}

}

class PhpWind$Process {
	HttpRequestor hr= new HttpRequestor();
	public void doLogin() {
		// TODO Auto-generated method stub
		String response$Home= this.hr.sendGet("http://localhost/phpwind/index.php");
		//System.out.println(response$Home);
		if(response$Home.contains("四川理工")) {
			System.out.println(Thread.currentThread().getName()+":打开首页成功");
		}else {
			System.out.println(response$Home);
			System.out.println(Thread.currentThread().getName()+":打开首页失败");		
			
		}
	}
}
