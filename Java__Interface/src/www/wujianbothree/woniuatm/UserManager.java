package www.wujianbothree.woniuatm;

import java.util.Scanner;

public class UserManager {
	 //static String[] users = new String[0];
	 //static String[] passes = new String[0];
	 //static double[] balances = new double[0];
	static UserData[] uds= new UserData [3];
	static int regesterIndex = 3;
	static String username;
	
	static {
		UserData ud1= new UserData("wjb", "wjb", 3000.0);
		UserData ud2= new UserData("lb", "lb", 4000.0);
		UserData ud3= new UserData("wdm", "wdm", 5000.0);
		uds[0]= ud1;
		uds[1]= ud2;
		uds[2]= ud3;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

	// ע��
	public void register() {
		// TODO Auto-generated method stub
		// String users[] = new String[5];
		// String passes[] = new String[5];
		// double balances[] = new double[5];
		// �û��������롢���
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û�����");
		String username = sc.next();
		System.out.println("���������룺");
		String password = sc.next();
		System.out.println("�������˺���");
		double balance = sc.nextDouble();

		// �����Զ�����һ������
		//this.users = this.extendStrig(this.users);
		//this.passes = this.extendStrig(this.passes);
		//this.balances = this.extendDouble(this.balances);
		this.uds= this.extendArray(this.uds);

		// �����ݷ���������,�û����ݴ��
		//this.users[this.regesterxIndex] = username;
		//this.passes[this.regesterxIndex] = password;
		//this.balances[this.regesterxIndex] = balance;
		
		
		//UserData ud= new UserData();
		//ud.setNamnes(username);
		//ud.setPasses(password);
		//ud.setBalances(balance);
		//System.out.println("ע��ɹ�");
		
		UserData ud= new UserData(username, password, balance);
		uds[regesterIndex]= ud;
		
		this.regesterIndex++;
        MainUI mu= new MainUI();
		mu.mainMenu();
	}
	
	

	// ��չ����
	private String[] extendStrig(String[] str) {
		String[] temp = new String[str.length + 1];
		for (int i = 0; i < str.length; i++) {
			temp[i] = str[i];
		}
		return temp;

	}

	private double[] extendDouble(double[] str) {
		double[] temp = new double[str.length + 1];
		for (int i = 0; i < str.length; i++) {
			temp[i] = str[i];
		}
		return temp;
	}
	
	private UserData[] extendArray(UserData[] str) {
		// TODO Auto-generated method stub
		UserData[] temp = new UserData[str.length + 1];
		for (int i = 0; i < str.length; i++) {
			temp[i] = str[i];
		}
		return temp;
	}
		
		
		//��¼
		public void login() {
			// TODO Auto-generated method stub
			System.out.println("aaaa");
			Scanner sc= new Scanner(System.in);
			System.out.println("�������û�����");
			String username= sc.next();
			//System.out.println("���������룺");
			//String password= sc.next();
			
			Boolean isOk= false;
			//�û���ƥ���ж�
			int index= -1;
		    //UserManager um= new UserManager();
			for(int i=0; i<this.uds.length; i++) {
				if(username.equals(this.uds[i].getNamnes())) {
					isOk= true;
					index= i;
				}
			}
			//����ƥ���ж�
			if(isOk) {
				while(true) {
					System.out.println("���������룺");
					String password= sc.next();
					if(password.equals(this.uds[index].getPasses())) {
						UserManager.username= username;
						MainUI mu= new MainUI();
						mu.subMenu();
						break;
					}else {
						System.out.println("������������²���");
					}
				}
				
			}else {
				System.out.println("�Բ����û������벻���ڣ������²���");
				UserManager um= new UserManager();
				um.login();
			}

		}

}

