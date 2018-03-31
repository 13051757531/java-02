package www.woniu.v1;

public class ThreadV03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubThread5 tv= new SubThread5();
		tv.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		tv.interrupt();
		tv.stop();
//		for(int i=0; i<10; i++) {
//			SubThread2 tv= new SubThread2();
//			tv.run();
//		}
		
		
//		for(int i=0; i<10; i++) {
//			SubThread5 tv= new SubThread5();
//			tv.start();
//		}
		
		System.out.println("当前运行线程的名称为：" + Thread.currentThread().getName());

	}
}



class SubThread5 extends Thread {
    public String threadName= "";
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		//try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
//		for(int i=0; i<100; i++) {
//			System.out.println("当前运行线程的名称为：" + this.getName() + "；运行第：" + i);
//		}
		int i= 1;
		while(!this.interrupted()) {
			System.out.println("当前运行线程的名称为：" + this.getName() + "；运行第：" + (i++));
		}
		
    }
}
















