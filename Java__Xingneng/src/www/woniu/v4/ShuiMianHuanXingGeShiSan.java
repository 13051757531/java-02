package www.woniu.v4;

import java.util.Date;

public class ShuiMianHuanXingGeShiSan implements Runnable {
	private WNClass wn = new WNClass();


	public static void main(String[] args) {
		ShuiMianHuanXingGeShiSan sm= new ShuiMianHuanXingGeShiSan();
        Thread t1= new Thread(sm);
        t1.start();
        Thread t2= new Thread(sm);
        t2.start();
        Thread t3= new Thread(sm);
        t3.start();
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		wn.doWaitNotify();
	}
}

class WNClass {
	public void doWaitNotify() {
		// TODO Auto-generated method stub
		
		synchronized (this) {
			try {Thread.sleep(4000);} catch (InterruptedException e1) {e1.printStackTrace();}
			String t= new Date().toString();
			System.out.println(Thread.currentThread().getName()+t+this.hashCode());
			System.out.println(Thread.currentThread().getName()+"：开始执行");
			this.notify();
			try {this.wait();} catch (InterruptedException e) {e.printStackTrace();}
			System.out.println(Thread.currentThread().getName()+"：结束执行");
		}

	}
}