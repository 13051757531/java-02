package www.woniu.v1;

public class ThreadThree implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadThree tt= new ThreadThree();
		//tt.run();
		System.out.println(Thread.currentThread().getName());

		for(int i=0; i<20; i++){
			Thread t= new Thread(tt);
			if(i%3 == 0) {
				t.setPriority(10);
			}
			t.start();
			
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("这是个多线程" + Thread.currentThread().getName());
//		for(int i=0; i<100; i++) {
//			System.out.println("这是个多线程" + Thread.currentThread().getName() + "；运行第" + i + "次");
//	     }

    }
}
