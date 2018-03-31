package www.woniu.v4;

public class Home$Open extends Thread {
	HttpRequest hr= new HttpRequest();
	static private float totalTime= 0; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Home$Open ho= new Home$Open();
//		ho.start();
		for(int i=0; i<1; i++) {
			Home$Open ho= new Home$Open();
			ho.start();
			try {ho.join();} catch (InterruptedException e) {e.printStackTrace();}
		}
		
		System.out.println("平均时间："+totalTime/20);
	}
	
	@Override
	public void run() {
		String home$url= "http://localhost/phpwind/index.php";
		String response$home= null;
		long startTime= System.currentTimeMillis();
		try {response$home= this.hr.sendGet(home$url);} catch (Exception e) {e.printStackTrace();}
		long endTime= System.currentTimeMillis();
		float durationTime= (float)(endTime-startTime)/1000;
		System.out.println(response$home);
		if(response$home.contains("四川理工")) {
			System.out.println("访问页面成功;"+Thread.currentThread().getName()+";消耗时间："+durationTime+";"+this.hashCode());
		}else {
			System.out.println("访问页面失败");
		}
		
		this.totalTime+= durationTime;
	}

}
