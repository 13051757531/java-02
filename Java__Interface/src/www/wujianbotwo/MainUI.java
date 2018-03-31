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
	
	//主菜单：登录前
	public void mainMenu() {
		System.out.println("=====欢迎使用蜗牛ATM无限制取款系统======");
		System.out.println("=====请选择您操作，1：登录  2：注册 3：退出======");
		System.out.println("======================================");
		while(true) {
			Scanner sc= new Scanner(System.in);
			String option= sc.next();
			//登录界面
			if(option.equals("1")) {
				System.out.println("登录界面");
				this.login();
			//注册界面
			}else if(option.equals("2")) {
				//System.out.println("注册界面");
				this.register();
			//退出当前ATM系统
			}else if(option.equals("3")) {
				//break;
				//return 0;
				System.exit(0);
			}
		}
	
			
			
	}
	
	//主菜单：登录后
	private void subMenu() {
		// TODO Auto-generated method stub
		System.out.println("=====请输入您的选项======");
		System.out.println("=====1：查询余额   2:转账  3:取款  4:存款  5:返回主菜单======");
		System.out.println("======================================");
		while(true) {
			Scanner sc= new Scanner(System.in);
			String option= sc.next();
			if(option.equals("1")) {
				System.out.println("查询余额");
			}else if(option.equals("2")) {
				System.out.println("转账");
			}else if(option.equals("3")) {
				System.out.println("取款");
			}else if(option.equals("4")) {
				System.out.println("存款");
			}else if(option.equals("5")) {
				this.mainMenu();
			}
		}
		

	}
	
	
	//注册
	private void register() {
		// TODO Auto-generated method stub
		//String users[] = new String[5];
		//String passes[] = new String[5];
		//double balances[] = new double[5];
		//用户名、密码、余额
		Scanner sc= new Scanner(System.in);
		System.out.println("请输入用户名：");
		String username= sc.next();
		System.out.println("请输入密码：");
		String password= sc.next();
		System.out.println("请输入账号余额：");
		double balance= sc.nextDouble();
		
		//数组自动增加一个长度
		this.users=this.extendStrig(this.users);
		this.passes=this.extendStrig(this.passes);
		this.balances=this.extendDouble(this.balances);
		
		//将数据放在数组中
		this.users[this.regesterxIndex]= username;
		this.passes[this.regesterxIndex]= password;
		this.balances[this.regesterxIndex]= balance;
		System.out.println("注册成功");
		this.regesterxIndex++;
		this.mainMenu();

	}
	//扩展数组
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
	
	
	//登录
	public void login() {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("请输入用户名：");
		String username= sc.next();
		//System.out.println("请输入密码：");
		//String password= sc.next();
		
		Boolean isOk= false;
		//用户名匹配判断
		int index= -1;
		for(int i=0; i<this.users.length; i++) {
			if(username.equals(this.users[i])) {
				isOk= true;
				index= i;
			}
		}
		//密码匹配判断
		if(isOk) {
			while(true) {
				System.out.println("请输入密码：");
				String password= sc.next();
				if(password.equals(passes[index])) {
					this.subMenu();
					break;
				}else {
					System.out.println("密码错误，请重新操作");
				}
			}
			
		}else {
			System.out.println("对不起用户名输入不存在，请重新操作");
			this.login();
		}

	}

}
