package www.woniu.v4;

import java.util.Date;

public class DemoV02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTest2 mt= new MyTest2();
		for(int i=0; i<3; i++) {
			SyncTest2 st= new SyncTest2(mt);
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

class SyncTest2 extends Thread {
	MyTest2 mt= null;
	public SyncTest2(MyTest2 mt) {
		// TODO Auto-generated constructor stub
		this.mt= mt;
	}
	@Override
	public void run() {
		mt.doTest();
	}
}

class MyTest2 {
	public synchronized void doTest() {
		String currentTime= new Date().toString();
		System.out.println(Thread.currentThread().getName()+":"+currentTime);
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String currentTime2= new Date().toString();
		System.out.println("线程睡醒了："+Thread.currentThread().getName()+":"+currentTime2+this.hashCode());
	}
	
	public synchronized void doNotify() {
		// TODO Auto-generated method stub
		//this.notifyAll();
		this.notify();
		this.notify();
	}
}





