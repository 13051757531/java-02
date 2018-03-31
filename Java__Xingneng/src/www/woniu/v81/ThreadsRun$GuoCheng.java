package www.woniu.v81;

public class ThreadsRun$GuoCheng {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<20; i++) {
			Threads$ControlNum t= new Threads$ControlNum();
			t.start();
		}

	}

}




class Threads$ControlNum extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
}



class PhpWind$BusinessLogic {
	
}























