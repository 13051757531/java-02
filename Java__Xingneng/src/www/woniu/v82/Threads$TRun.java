package www.woniu.v82;

public class Threads$TRun {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<20; i++) {
			Threads$Born t= new Threads$Born();
			t.start();
		}

	}
	
	

}


class Threads$Born extends Thread {
	Test$Process tp= new Test$Process();
	@Override
	public void run() {
		for(int i=0; i<20;i++) {
			tp.doOut();
			System.out.println(i+1);
		}
		
	}
}

class Test$Process {
	CommonProcess cp= new CommonProcess();
	public void doOut() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + ":"+cp.a);
		cp.ziZeng();
		
	}
}