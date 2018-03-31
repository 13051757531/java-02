package www.gui.huohu.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class XuqiutianMokuai {
	WebDriver driver= null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
	public XuqiutianMokuai(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
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
	
	private WebElement getXuqiutianLianjie() {
		// TODO Auto-generated method stub
		return this.driver.findElement(By.partialLinkText("需求提案"));
	}

	private void getBianhaoInputbox() {
		// TODO Auto-generated method stub
		
	}
	
	private void getChuangjianzheInputbox() {
		// TODO Auto-generated method stub

	}
	
	private void getLeixingSelectbox() {
		// TODO Auto-generated method stub

	}
	
	private void getZhongyaoxingSelectbox() {
		// TODO Auto-generated method stub

	}
	
	private WebElement getBiaotiInputbox() {
		// TODO Auto-generated method stub
		return this.driver.findElement(By.id("headline"));
	}
	
	private WebElement getContentButton() {
		// TODO Auto-generated method stub
		return this.driver.findElement(By.className("ke-common-icon"));
	}
	
	private WebElement getContentInputBox() {
		// TODO Auto-generated method stub
		return this.driver.findElement(By.className("ke-textarea"));
	}
	
	private void getChulijieguoInputbox() {
		// TODO Auto-generated method stub

	}
	
	private WebElement getXinzengButton() {
		// TODO Auto-generated method stub
		return this.driver.findElement(By.id("add"));

	}
	
	private void getShousuoButton() {
		// TODO Auto-generated method stub

	}
	
	private void getChongzhiButton() {
		// TODO Auto-generated method stub

	}
	
	private void getBianjiButton() {
		// TODO Auto-generated method stub

	}
	
	private void getShanchuButton() {
		// TODO Auto-generated method stub

	}
	
	private void getXinjianyonghugushiButton() {
		// TODO Auto-generated method stub

	}
	
	private void getBianhaoOnerow() {
		// TODO Auto-generated method stub

	}
	
	private void getBiaotiOnerow() {
		// TODO Auto-generated method stub

	}
	
	public void doXinzeng() {
		// TODO Auto-generated method stub
		this.getXuqiutianLianjie().click();
		this.getBiaotiInputbox().sendKeys("wujianbo");
		this.getContentButton().click();
		this.getContentInputBox().sendKeys("wujianbo");
		this.getXinzengButton().click();
	}
}
