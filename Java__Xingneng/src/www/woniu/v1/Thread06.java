package www.woniu.v1;

public class Thread06 {

	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			Increment in= new Increment(i*100);
			in.start();
		}

	}

}



class Increment extends Thread {
	private int index= 0;
	public Increment(int index) {
		this.index= index;
	}
	@Override
	public void run() {
		for(int i=0; i<20; i++) {
			this.index++;
			System.out.println("线程名称_"+this.getName() +"；运行次数："+ this.index);
		}
	}
}
