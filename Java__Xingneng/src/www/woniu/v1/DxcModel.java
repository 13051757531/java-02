package www.woniu.v1;

import java.util.concurrent.atomic.AtomicInteger;

public class DxcModel  {
	public static void main(String[] args) {
		for(int i=0; i<=99; i++) {
			Threads2 ta= new Threads2(i*100);
			ta.start();
		}

	}
}


class Threads2 extends Thread {
	private int index;
	public Threads2(int index) {
		this.index= index;
	}
	@Override
	public void run() {
		for(int j=1; j<=100; j++) {
			System.out.println("线程__"+ this.getName() +"；执行次数："+(this.index+j));
		}
	}
}
