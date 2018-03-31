package www.woniu.v4;

import java.util.Date;

public class ShuiMianHuanXingGeShiYi implements Runnable {
	private int num;
	private Object lock;
	public ShuiMianHuanXingGeShiYi(int num, Object lock) {
		// TODO Auto-generated constructor stub
		this.num= num;
		this.lock= lock;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object lock= new Object();
//		Thread thread1= new Thread(new ShuiMianHuanXingGeShiYi(1, lock));
//		thread1.start();
//		Thread thread2= new Thread(new ShuiMianHuanXingGeShiYi(2, lock));
//		thread2.start();
		for(int i=0; i<2; i++) {
			Thread thread= new Thread(new ShuiMianHuanXingGeShiYi(i, lock));
			thread.start();
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			synchronized (lock) {
				lock.notifyAll();
				try {lock.wait();} catch (InterruptedException e) {e.printStackTrace();}
				System.out.println(this.num);
				String currentTime= new Date().toString();
				System.out.println(Thread.currentThread().getName()+currentTime);
			}
		}
		
	}

}
