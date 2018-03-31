package www.gui.v2;

import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LiuLanQi {
	WebDriver driver= null;
	Actions actions= null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LiuLanQi gx= new LiuLanQi();
		gx.init();

	}
	
	private void init() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// System.setProperty("webdriver.firefox.bin", "D:\\Mozilla
		// Firefox\\firefox.exe");
		System.setProperty("webdriver.firefox.bin", "D:\\FireFox__37\\firefox.exe");

		this.driver = new FirefoxDriver();// 启动火狐浏览器

		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// 元素等待时间
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// 页面加载时间
		this.driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);// ajax请求
		this.driver.manage().window().maximize();
		// this.driver.get("https://www.baidu.com/");// 在浏览器中打开该网址
		actions = new Actions(driver);
		
		this.driver.get("http://localhost/Agileone/");
		this.driver.findElement(By.id("username")).sendKeys("admin");
		this.driver.findElement(By.id("password")).sendKeys("admin");
		this.driver.findElement(By.id("login")).click();
		this.driver.findElement(By.partialLinkText("需求提案")).click();
		this.driver.findElement(By.partialLinkText("缺陷跟踪")).click();
		
		
		
		this.driver.navigate().back();
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		this.driver.navigate().forward();
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		this.driver.navigate().refresh();
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		this.driver.navigate().to("http://www.baidu.com");
	
		
		
	}
	
	

}
