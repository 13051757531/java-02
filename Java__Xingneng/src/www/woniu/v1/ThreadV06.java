package www.woniu.v1;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadV06 extends Thread {
	static AtomicInteger  ai= ai= new AtomicInteger(100);;
	public static void main(String[] args) {
		for(int i=0; i<1; i++) {
			ThreadV06 in= new ThreadV06();
			in.start();
		}

	}
	
	@Override
	public void run() {
		for(int i=0; i<1; i++) {
			System.out.println("线程名称_"+this.getName() +"；运行次数："+ this.ai.incrementAndGet());
		}
		this.doit();
	}
	
	private synchronized void doit() {
		// TODO Auto-generated method stub
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("aa");

	}

}


