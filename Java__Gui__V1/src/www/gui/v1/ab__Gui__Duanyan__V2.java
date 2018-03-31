package www.gui.v1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ab__Gui__Duanyan__V2 {
	WebDriver driver= null;
	Actions actions= null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ab__Gui__Duanyan__V2 gd= new ab__Gui__Duanyan__V2();
		gd.init();
		//gd.killDo();
		//gd.tableProcess();

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

	}
	
	private void killDo() {
		// TODO Auto-generated method stub
		this.driver.get("http://localhost/Agileone/");
		try {Thread.sleep(3000);} catch (InterruptedException e1) {e1.printStackTrace();}
		
		try {Runtime.getRuntime().exec("taskkill /f /im firefox.exe");} catch (IOException e) {e.printStackTrace();}
	}
	
	private void tableProcess() {
		// TODO Auto-generated method stub
		this.driver.get("http://localhost/Agileone/");
		this.driver.findElement(By.id("username")).sendKeys("admin");
		this.driver.findElement(By.id("password")).sendKeys("admin");
		this.driver.findElement(By.id("login")).click();
		
		this.driver.findElement(By.partialLinkText("需求提案")).click();
		
		this.driver.findElement(By.id("headline")).sendKeys("wjb__3");
		this.driver.findElement(By.className("ke-common-icon")).click();
		this.driver.findElement(By.className("ke-textarea")).sendKeys("dd");
		this.driver.findElement(By.id("add")).click();
		
		try {Thread.sleep(3000);} catch (InterruptedException e1) {e1.printStackTrace();}
		
		WebElement table= this.driver.findElement(By.xpath("//table[@id='dataTable']"));
		//System.out.println(table.getText());
		WebElement tr1= this.driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr"));
		//System.out.println(tr.getText());
		WebElement tr3= this.driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[3]"));
		//System.out.println(tr3.getText());
		WebElement tr1con2= this.driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[1]/td[2]"));
		System.out.println(tr1con2.getText());
	}

}
