package www.wujianbotwo;

public class Demo3 {
	int age;
	int height;
	int weight;
	private String name;
	static String nation;
	private double salary;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo3[] de= new Demo3[4];
		Demo3 demo1= new Demo3();
		Demo3 demo2= new Demo3(34, 44);
		Demo3 demo3= new Demo3(33, 22, 55);
		de[0]= demo1;
		de[1]= demo2;
		de[2]= demo3;
		for(int i=0; i<de.length; i++) {
			System.out.println(de[i]);
		}

		System.out.println(demo2.getAge());
	}
	
	public Demo3() {
		// TODO Auto-generated constructor stub
	}
	
	public Demo3(int age, int height) {
		// TODO Auto-generated constructor stub
		this.age= age;
		this.height= height;
	}
	
	public Demo3(int age, int height, double salary) {
		// TODO Auto-generated constructor stub
		this.age= age;
		this.height= height;
		this.salary= salary;
	}

	public int getAge() {
		return age;
	}
	
	

}
