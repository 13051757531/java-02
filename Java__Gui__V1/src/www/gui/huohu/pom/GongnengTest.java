package www.gui.huohu.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GongnengTest {
	static WebDriver driver= null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GongnengTest g= new GongnengTest();
		//g.dengluGongneng();
		g.xuqiutianXinzengGongneng();

	}
	
	private void init() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.firefox.bin", "D:\\FireFox__37\\firefox.exe");

		this.driver = new FirefoxDriver();// 启动火狐浏览器

		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// 元素等待时间
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// 页面加载时间
		this.driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);// ajax请求
		this.driver.manage().window().maximize();
		// this.driver.get("https://www.baidu.com/");// 在浏览器中打开该网址
		
		
		this.driver.get("http://localhost/Agileone/");

	}
	private void dengluGongneng() {
		// TODO Auto-generated method stub
		this.init();
		new DengLuPage(this.driver).doLogin("admin", "admin", true);
		if(this.driver.getPageSource().contains("蜗牛学院")) {
			System.out.println("登录测试__：成功");
		} else{
			System.out.println("登录测试__：失败");
		}
	}
	
	private void xuqiutianXinzengGongneng() {
		// TODO Auto-generated method stub
		this.init();
		new DengLuPage(this.driver).doLogin("admin", "admin", true);
		new XuqiutianMokuai(this.driver).doXinzeng();

	}

}
