package www.wujianbothree.woniuatm;
import java.util.Scanner;



public class MainUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainUI mu = new MainUI();
		UserManager um= new UserManager();
		UserData UD= new UserData();
		mu.mainMenu();
		
	

	}

	// ���˵�����¼ǰ
	public void mainMenu() {
		System.out.println("=====��ӭʹ����ţATM������ȡ��ϵͳ======");
		System.out.println("=====��ѡ����������1����¼  2��ע�� 3���˳�======");
		System.out.println("======================================");

		UserManager um1 = new UserManager();
		for (int i = 0; i < um1.uds.length; i++) {
			System.out.println("�û��ǣ�" + um1.uds[i].getNamnes());
		}

		while (true) {
			Scanner sc = new Scanner(System.in);
			String option = sc.next();
			Boolean isOk = false;
			if (option.equals("1") || option.equals("2") || option.equals("3")) {
				isOk = true;
			}else {
				System.out.println("��������Ҫ�ľ����������Ӧ����ǣ�1��2��3");
			}
			if (isOk) {
				// ��¼����
				if (option.equals("1")) {
					System.out.println("��¼����");
					UserManager um = new UserManager();
					um.login();
					// ע�����
				} else if (option.equals("2")) {
					// System.out.println("ע�����");
					UserManager um = new UserManager();
					um.register();
					// �˳���ǰATMϵͳ
				} else if (option.equals("3")) {
					 break;
					// return 0;
					//System.exit(0);
				}
			}else {
				this.mainMenu();
			}
		}

	}

	// ���˵�����¼��
	public void subMenu() {
		// TODO Auto-generated method stub
		System.out.println("=====����������ѡ��======");
		System.out.println("=====1����ѯ���   2:ת��  3:ȡ��  4:���  5:�������˵�======");
		System.out.println("======================================");
		while (true) {
			Scanner sc = new Scanner(System.in);
			String option = sc.next();
			Boolean isOk = false;
			if (option.equals("1") || option.equals("2") || option.equals("3") || option.equals("4") ||option.equals("5")) {
				isOk = true;
			}else {
				System.out.println("��������Ҫ�ľ����������Ӧ����ǣ�1��2��3");
			}
			
			if (option.equals("1")) {
				//System.out.println("��ѯ���");
				AccountManager at= new AccountManager();
				at.checkBalance();
			} else if (option.equals("2")) {
				//System.out.println("ת��");
				AccountManager at= new AccountManager();
				at.transferMoney();
			} else if (option.equals("3")) {
				//System.out.println("ȡ��");
				AccountManager at= new AccountManager();
				at.drawMoney();
			} else if (option.equals("4")) {
				//System.out.println("���");
				AccountManager at= new AccountManager();
				at.savaMoney();
			} else if (option.equals("5")) {
				MainUI mu= new MainUI();
				mu.mainMenu();
			}
		}

	}

}
