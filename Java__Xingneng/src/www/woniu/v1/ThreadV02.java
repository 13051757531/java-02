package www.woniu.v1;

public class ThreadV02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SubThread tv= new SubThread();
		//tv.start();
//		for(int i=0; i<10; i++) {
//			SubThread2 tv= new SubThread2();
//			tv.run();
//		}
		
		
		for(int i=0; i<10; i++) {
			SubThread3 tv= new SubThread3(String.valueOf(i+1));
			tv.start();
		}
		
		System.out.println("当前运行线程的名称为：" + Thread.currentThread().getName());

	}
}



class SubThread3 extends Thread {
    public String threadName= "";
    public SubThread3(String threadName) {
		// TODO Auto-generated constructor stub
    	this.threadName= threadName;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		//try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		System.out.println("当前运行线程的名称为：" + this.threadName);
    }
}


class SubThread4 {
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		System.out.println("当前运行线程的名称为：" + Thread.currentThread().getName());
		//try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
    }
}















