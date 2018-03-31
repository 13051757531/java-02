package www.woniu.v4;

import java.util.Date;

public class ShuiMianHuanXingJingTai {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTest3 mt= new MyTest3();
		for(int i=0; i<3; i++) {
			SyncTest3 st= new SyncTest3(mt);
			st.start();
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mt.doNotify();

	}

}

class SyncTest3 extends Thread {
	MyTest3 mt= null;
	public SyncTest3(MyTest3 mt) {
		// TODO Auto-generated constructor stub
		this.mt= mt;
	}
	@Override
	public void run() {
		mt.doTest();
	}
}

class MyTest3 {
	public static synchronized void doTest() {
		String currentTime= new Date().toString();
		System.out.println(Thread.currentThread().getName()+":"+currentTime);
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			//this.wait();
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String currentTime2= new Date().toString();
		System.out.println("线程睡醒了："+Thread.currentThread().getName()+":"+currentTime2);
	}
	
	public synchronized void doNotify() {
		// TODO Auto-generated method stub
		//this.notifyAll();
		this.notify();
		this.notify();
	}
}