package www.woniu.v1;

public class BankV01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pay p= new Pay();
		ThreadA ta= new ThreadA(p);
		ThreadB tb= new ThreadB(p);
		
		
		tb.start();
		ta.start();
		

	}

}


class Pay {
	private int balance= 1000;
	public synchronized void doPay(int money) {
		// TODO Auto-generated method stub
		System.out.println("当前转账的线程是：" + Thread.currentThread().getName());
		if(balance - money < 0) {
			System.out.println("您的余额不足:" + balance);
		} else {
			balance= balance - money;
			System.out.println("转账后的余额是：" + balance);
		}
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}


class ThreadA extends Thread {
	private Pay p= null;
	public ThreadA(Pay p) {
		// TODO Auto-generated constructor stub
		this.p= p;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.p.doPay(600);
	}
	
}

class ThreadB extends Thread {
	private Pay p= null;
	public ThreadB(Pay p) {
		// TODO Auto-generated constructor stub
		this.p= p;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.p.doPay(600);
	}
}