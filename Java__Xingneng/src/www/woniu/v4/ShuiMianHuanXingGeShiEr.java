package www.woniu.v4;

import java.util.Date;

public class ShuiMianHuanXingGeShiEr {
	private String[] flag= {"true"};


	public static void main(String[] args) {
		ShuiMianHuanXingGeShiEr sm= new ShuiMianHuanXingGeShiEr();
		NotifyThread nt= sm.new NotifyThread("通知线程---01");
		WaitThread wt1= sm.new WaitThread("等待线程----01");
		WaitThread wt2= sm.new WaitThread("等待线程----02");
		WaitThread wt3= sm.new WaitThread("等待线程----03");
		nt.start();
		wt1.start();
		wt2.start();
		wt3.start();

	}
	
	class NotifyThread extends Thread {
		public NotifyThread(String name) {
			// TODO Auto-generated constructor stub
			super(name);
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
			synchronized (flag) {
				flag[0]= "false";
				flag.notifyAll();
			}
		}
	} 
	
    class WaitThread extends Thread {
    	public WaitThread(String name) {
			// TODO Auto-generated constructor stub
    		super(name);
		}
    	@Override
    	public void run() {
    		// TODO Auto-generated method stub
    		String t= new Date().toString();
    		System.out.println(Thread.currentThread().getName()+t);
    		synchronized (flag) {
				while(flag[0]!="false") {
					long startTime= System.currentTimeMillis();
					try {flag.wait();} catch (InterruptedException e) {e.printStackTrace();}
					long endTime= System.currentTimeMillis();
					long waitTime= endTime - startTime;
					System.out.println("等待时间为："+waitTime);
					System.out.println(Thread.currentThread().getName()+"结束等待"+this.hashCode());
				}
			}
    	}
	} 

}

