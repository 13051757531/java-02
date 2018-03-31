package www.gui.v2;

import java.awt.AWTException;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Capture2 {
	WebDriver driver= null;
	Actions actions= null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Capture2 gx= new Capture2();
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
		
		
		
		Rectangle screenRect= new Rectangle(0, 0, 1600, 900);
		try {
			BufferedImage bi= new Robot().createScreenCapture(screenRect);
		    ImageIO.write(bi, "png", new File("e:\\444.png"));
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	

}
