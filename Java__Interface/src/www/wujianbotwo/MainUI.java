package www.wujianbotwo;

import java.util.Scanner;

public class MainUI {
	String[] users = new String[0];
	String[] passes = new String[0];
	double[] balances = new double[0];
	int regesterxIndex= 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainUI  ui= new MainUI();
		ui.mainMenu();

	}
	
	//���˵�����¼ǰ
	public void mainMenu() {
		System.out.println("=====��ӭʹ����ţATM������ȡ��ϵͳ======");
		System.out.println("=====��ѡ����������1����¼  2��ע�� 3���˳�======");
		System.out.println("======================================");
		while(true) {
			Scanner sc= new Scanner(System.in);
			String option= sc.next();
			//��¼����
			if(option.equals("1")) {
				System.out.println("��¼����");
				this.login();
			//ע�����
			}else if(option.equals("2")) {
				//System.out.println("ע�����");
				this.register();
			//�˳���ǰATMϵͳ
			}else if(option.equals("3")) {
				//break;
				//return 0;
				System.exit(0);
			}
		}
	
			
			
	}
	
	//���˵�����¼��
	private void subMenu() {
		// TODO Auto-generated method stub
		System.out.println("=====����������ѡ��======");
		System.out.println("=====1����ѯ���   2:ת��  3:ȡ��  4:���  5:�������˵�======");
		System.out.println("======================================");
		while(true) {
			Scanner sc= new Scanner(System.in);
			String option= sc.next();
			if(option.equals("1")) {
				System.out.println("��ѯ���");
			}else if(option.equals("2")) {
				System.out.println("ת��");
			}else if(option.equals("3")) {
				System.out.println("ȡ��");
			}else if(option.equals("4")) {
				System.out.println("���");
			}else if(option.equals("5")) {
				this.mainMenu();
			}
		}
		

	}
	
	
	//ע��
	private void register() {
		// TODO Auto-generated method stub
		//String users[] = new String[5];
		//String passes[] = new String[5];
		//double balances[] = new double[5];
		//�û��������롢���
		Scanner sc= new Scanner(System.in);
		System.out.println("�������û�����");
		String username= sc.next();
		System.out.println("���������룺");
		String password= sc.next();
		System.out.println("�������˺���");
		double balance= sc.nextDouble();
		
		//�����Զ�����һ������
		this.users=this.extendStrig(this.users);
		this.passes=this.extendStrig(this.passes);
		this.balances=this.extendDouble(this.balances);
		
		//�����ݷ���������
		this.users[this.regesterxIndex]= username;
		this.passes[this.regesterxIndex]= password;
		this.balances[this.regesterxIndex]= balance;
		System.out.println("ע��ɹ�");
		this.regesterxIndex++;
		this.mainMenu();

	}
	//��չ����
	private String[] extendStrig(String[] str) {
		String[] temp= new String[str.length+1];
		for(int i=0; i<str.length; i++) {
			temp[i]= str[i]; 
		}
		return temp;

	}
	private double[] extendDouble(double[] str) {
		double[] temp= new double[str.length+1];
		for(int i=0; i<str.length; i++) {
			temp[i]= str[i]; 
		}
		return temp;
	}
	
	
	//��¼
	public void login() {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("�������û�����");
		String username= sc.next();
		//System.out.println("���������룺");
		//String password= sc.next();
		
		Boolean isOk= false;
		//�û���ƥ���ж�
		int index= -1;
		for(int i=0; i<this.users.length; i++) {
			if(username.equals(this.users[i])) {
				isOk= true;
				index= i;
			}
		}
		//����ƥ���ж�
		if(isOk) {
			while(true) {
				System.out.println("���������룺");
				String password= sc.next();
				if(password.equals(passes[index])) {
					this.subMenu();
					break;
				}else {
					System.out.println("������������²���");
				}
			}
			
		}else {
			System.out.println("�Բ����û������벻���ڣ������²���");
			this.login();
		}

	}

}
