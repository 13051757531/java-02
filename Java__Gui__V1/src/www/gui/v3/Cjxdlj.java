package www.gui.v3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cjxdlj {
	WebDriver driver= null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cjxdlj gc= new Cjxdlj();
		gc.init();
	}
	
	private void init() {
		// TODO Auto-generated method stub
		// System.setProperty("webdriver.firefox.bin", "D:\\Mozilla
		// Firefox_53\\firefox.exe");
		System.setProperty("webdriver.chrome.bin",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		// this.driver= new FirefoxDriver();//启动火狐浏览器
		this.driver = new ChromeDriver();
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// 元素等待时间
		this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// 页面加载时间
		this.driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);// ajax请求
		this.driver.manage().window().maximize();
		//this.driver.get("https://www.baidu.com/");// 在浏览器中打开该网址
		this.driver.get("http://localhost/Agileone/");
		
		String temp= this.driver.findElement(By.cssSelector("html >body >table >tbody")).getText();//定位元素,绝对路径
		this.driver.findElement(By.cssSelector("input#username")).clear();//定位元素, 相对路径
		this.driver.findElement(By.cssSelector("input#username")).sendKeys("admin");//定位元素, 相对路径
		this.driver.findElement(By.cssSelector("input.login-password#password")).clear();//定位元素, 相对路径
		this.driver.findElement(By.cssSelector("input.login-password#password[type='password']")).sendKeys("admin");//定位元素, 相对路径
//		this.driver.findElement(By.xpath("//input[@id='login']")).click();//定位元素, 相对路径
//		///html/body/table/tbody/tr[2]/td[1]/div[1]/ul/li[5]/a  需求提案绝对路径
//		this.driver.findElement(By.partialLinkText("需求")).click();//定位元素, 相对路径
//		temp= this.driver.findElement(By.xpath("//table[@class='table-data']/tbody/tr[1]")).getText();//定位元素, 相对路径
		//temp= this.driver.findElement(By.xpath("//*[@id='dataPanel']")).getText();//定位元素, 相对路径
		//String temp= this.driver.findElement(By.xpath("//td[@align='right']")).getText();//定位元素, 相对路径
		System.out.println(temp);
		//this.driver.findElement(By.xpath("/html/body/table")).sendKeys("");//xpath绝对路径
		
	}


}
