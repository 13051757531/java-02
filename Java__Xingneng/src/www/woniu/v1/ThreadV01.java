package www.woniu.v1;

public class ThreadV01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SubThread tv= new SubThread();
		//tv.start();
		for(int i=0; i<10; i++) {
			SubThread2 tv= new SubThread2();
			tv.run();
		}
		
		
		for(int i=0; i<10; i++) {
			SubThread tv= new SubThread();
			tv.start();
		}
		
		System.out.println("当前运行线程的名称为：" + Thread.currentThread().getName());

	}
}



class SubThread extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		//try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		System.out.println("当前运行线程的名称为：" + Thread.currentThread().getName());
    }
}


class SubThread2 {
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		System.out.println("当前运行线程的名称为：" + Thread.currentThread().getName());
		//try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
    }
}















