package www.woniu.v4;

import java.util.Date;

public class DemoV01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<3; i++) {
			SyncTest st= new SyncTest();
			st.start();
		}

	}

}

class SyncTest extends Thread {
	MyTest mt= new MyTest();
	@Override
	public void run() {
		mt.doTest();
	}
}

class MyTest {
	public  void doTest() {
		synchronized (this) {
			String currentTime= new Date().toString();
			System.out.println(Thread.currentThread().getName()+":"+currentTime);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}