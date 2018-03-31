package www.woniuxy.com.llq;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IeGoOn {
	WebDriver driver = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IeGoOn ig= new IeGoOn();
		ig.init();

	}

	private void init() {
		// TODO Auto-generated method stub
		// System.setProperty("webdriver.firefox.bin", "D:\\Mozilla
		// Firefox_53\\firefox.exe");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		// this.driver= new FirefoxDriver();//启动火狐浏览器
		this.driver = new ChromeDriver();
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// 元素等待时间
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// 页面加载时间
		this.driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);// ajax请求
		this.driver.manage().window().maximize();
		this.driver.get("https://www.baidu.com/");// 在浏览器中打开该网址
	}

}
