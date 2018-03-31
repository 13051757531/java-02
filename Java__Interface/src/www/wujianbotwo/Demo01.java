package www.wujianbotwo;

public class Demo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		People p= new People();
		System.out.println(p.hashCode());
		System.out.println(p);
		People[] p2= new People[3];
		System.out.println(p2.length);
		System.out.println(p2.hashCode());
		
		
		String[] users= new String[3];
		System.out.println(users);
		String name1= new String("aaaa");
		String name2= new String("bbb");
		users[0]= name1;
		users[1]= name2;
		for(int i=0; i<users.length; i++) {
			System.out.println(users[i]);
		}
	}

}


class People{
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("³Ô·¹");
	}
}