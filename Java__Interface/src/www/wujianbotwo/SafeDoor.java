package www.wujianbotwo;

import java.util.concurrent.locks.Lock;

public class SafeDoor extends Door {
	@Override
	//public void close() {
		// TODO Auto-generated method stub
		//super.close();
	//}
	
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("子类关闭");
	}
	
	public void closeTwo() {
		// TODO Auto-generated method stub
		super.close();
	}
	
	
	public void closeThre() {
		// TODO Auto-generated method stub
		this.close();
	}
	
	public  void lock() {
		// TODO Auto-generated method stub
		System.out.println("子类锁门");
	}
	
	public  void lock(int i) {
		// TODO Auto-generated method stub
		System.out.println("子类锁门:" + i);
	}
	
}
