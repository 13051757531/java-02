package www.gui.liulanqi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Chrome2 {
	WebDriver driver= null;
	Actions actions= null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chrome2 gd= new Chrome2();
		gd.init();
		//gd.killDo();
		//gd.tableProcess();

	}
	
	private void init() {

		System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		//C:\Documents and Settings\Administrator\Local Settings\Application Data\Google\Chrome
		//C:\Documents and Settings\Administrator\Local Settings\Application Data\Google\Chrome
		//C:\Program Files (x86)\Google\Chrome\Application\chrome.exe
		//this.driver = new FirefoxDriver();// 启动火狐浏览器
		this.driver= new ChromeDriver();

		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// 元素等待时间
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// 页面加载时间
		this.driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);// ajax请求
		this.driver.manage().window().maximize();
		// this.driver.get("https://www.baidu.com/");// 在浏览器中打开该网址
		 this.driver.get("http://localhost/Agileone/");
		 this.driver.findElement(By.id("username")).sendKeys("admin");
		this.driver.findElement(By.id("password")).sendKeys("admin");
		this.driver.findElement(By.id("login")).click();
			
			this.driver.findElement(By.partialLinkText("需求提案")).click();

	}
	
	

}
