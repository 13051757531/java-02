package www.woniu.v1;

public class ThreadTwo implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTwo tt= new ThreadTwo();
		//tt.run();
		System.out.println(Thread.currentThread().getName());

		for(int i=0; i<20; i++){
			Thread t= new Thread(tt);
			t.start();
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<100; i++) {
			System.out.println("这是个多线程" + Thread.currentThread().getName() + "；运行第" + i + "次");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	     }

    }
}
