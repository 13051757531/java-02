package www.gui.v2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Upload__Robot {
	WebDriver driver= null;
	Actions actions= null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Upload__Robot gx= new Upload__Robot();
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
		
		this.driver.get("http://localhost/secure/view.php?id=last");
		this.driver.findElement(By.partialLinkText("新增")).click();
        this.driver.findElement(By.name("attachment")).click();
        //this.driver.findElement(By.name("attachment")).sendKeys("C:\\Users\\Administrator\\Desktop\\start___All.bat");
		try {
			Robot robot= new Robot();
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_2);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_2);
			
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_SEMICOLON);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_SEMICOLON);
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//this.driver.switchTo().alert().accept();
		//this.driver.switchTo().alert().dismiss();
		
        //this.driver.findElement(By.xpath("/html/body/table/tbody/tr[8]/td/input")).click();
	}
	
	

}
