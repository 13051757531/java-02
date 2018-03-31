package www.woniu.v4;

import java.util.Date;

public class ShuiMianHuanXingGeShiSi  {


	public static void main(String[] args) {
		ThreadClass tc= new ThreadClass();
		for(int i=0; i<10; i++) {
			Thread t= new Thread(tc);
			t.start();
		}
	}


}

class ThreadClass implements Runnable {
	WaitNotifyClass wc= new WaitNotifyClass();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//System.out.println(Thread.currentThread().getName());
		if(Thread.currentThread().getName().equals("Thread-8")) {
			wc.doNotify();
	    }else {
	    	wc.doWait();
    }

}

class WaitNotifyClass {
	public synchronized void doWait() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+":开始执行");
		try {this.wait();} catch (InterruptedException e) {e.printStackTrace();}
		System.out.println(Thread.currentThread().getName()+":执行结束");
	}
	
	public synchronized void doNotify() {
		// TODO Auto-generated method stub
		try {Thread.sleep(9000);} catch (InterruptedException e) {e.printStackTrace();}
		this.notify();
		this.notify();
		this.notify();

	}
}

}
	
	


