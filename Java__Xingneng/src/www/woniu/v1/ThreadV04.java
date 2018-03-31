package www.woniu.v1;

public class ThreadV04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<20; i++) {
			Thread9 t= new Thread9();
			t.start();
			try {t.join();} catch (InterruptedException e) {e.printStackTrace();}
		}
		System.out.println("当前线程为：" + Thread.currentThread().getName());
	}

}


class Thread9 extends Thread {
	@Override
	public void run() {
		System.out.println("运行子线程为：" + this.getName());
	}
}