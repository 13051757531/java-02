package www.woniu.v1;

public class ThreadOne extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ThreadOne to= new ThreadOne();
		//to.start();
		//System.out.println(to.getName());
		//ThreadOne to1= new ThreadOne();
		//to1.start();
		for(int i=0; i<20; i++) {
			new ThreadOne().start();
		}

	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<100; i++) {
			System.out.println("这是个多线程" + this.getName() + "；运行第" + i + "次");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
