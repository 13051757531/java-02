package www.gui.v1;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class aa__Gui__Action__V1 {
	WebDriver driver = null;
	Actions actions = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		aa__Gui__Action__V1 ga = new aa__Gui__Action__V1();
		ga.init();
		// ga.doLogin();
		// ga.misc();
		// ga.iframe();
		// ga.iframe__Two();
		// ga.xlk();
		ga.onw();
		//ga.xh();

	}

	private void init() {
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

	private void doLogin() {
		// TODO Auto-generated method stub
		// http://localhost/Agileone/
		this.driver.get("http://localhost/Agileone/");
		this.driver.findElement(By.id("username")).clear();
		/// this.actions.click(this.driver.findElement(By.id("")));
		this.actions.sendKeys(this.driver.findElement(By.id("username")), "admin").perform();
		this.actions.sendKeys(this.driver.findElement(By.id("password")), "admin").perform();
		this.actions.click(this.driver.findElement(By.id("login"))).perform();

		this.actions.click(this.driver.findElement(By.id("newitem"))).perform();

		// this.actions.doubleClick(this.driver.findElement(By.id("newitem"))).perform();
		this.actions.contextClick(this.driver.findElement(By.partialLinkText("需求提案"))).perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.actions.sendKeys(Keys.ARROW_DOWN).perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.actions.sendKeys(Keys.ARROW_DOWN).perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.actions.sendKeys(Keys.ENTER).perform();
	}

	private void misc() {
		// TODO Auto-generated method stub
		this.driver.get("http://www.woniuxy.com/train/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.actions.clickAndHold(this.driver.findElement(By.partialLinkText("课程介绍"))).perform();
		// try {Thread.sleep(3000);} catch (InterruptedException e)
		// {e.printStackTrace();}
		// this.driver.findElement(By.partialLinkText("测试")).clear();
		// this.actions.doubleClick(this.driver.findElement(By.partialLinkText("测试"))).perform();
		// try {Thread.sleep(1000);} catch (InterruptedException e)
		// {e.printStackTrace();}
		this.actions.contextClick(this.driver.findElement(By.partialLinkText("测试"))).perform();
		// try {Thread.sleep(1000);} catch (InterruptedException e)
		// {e.printStackTrace();}
		this.actions.sendKeys(Keys.ARROW_DOWN).perform();
		this.actions.sendKeys(Keys.ENTER).perform();
		// this.driver.findElement(By.xpath("//*[@id='menu']/ul/li[2]/a")).click();
		// this.driver.findElement(By.cssSelector("#menu > ul > li:nth-child(2)
		// > a")).click();

		this.actions.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).keyUp(Keys.CONTROL).sendKeys(Keys.NULL).perform();
	}

	private void iframe() {
		// TODO Auto-generated method stub
		// http://localhost/HTML-%E5%AF%B9%E8%AF%9D%E6%A1%86%E5%92%8C%E7%AA%97%E5%8F%A3.html
		this.driver.get("http://localhost/HTML-%E5%AF%B9%E8%AF%9D%E6%A1%86%E5%92%8C%E7%AA%97%E5%8F%A3.html");
		this.driver.findElement(By.id("alertBtn")).click();
		// System.out.println(this.driver.switchTo().alert().getText());
		this.driver.switchTo().alert().accept();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.driver.findElement(By.id("confirmBtn")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.driver.switchTo().alert().dismiss();

		this.driver.findElement(By.id("promptBtn")).click();
		this.driver.switchTo().alert().sendKeys("111111");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.driver.switchTo().alert().accept();

	}

	private void iframe__Two() {
		// TODO Auto-generated method stub
		// http://localhost/HTML-%E5%AF%B9%E8%AF%9D%E6%A1%86%E5%92%8C%E7%AA%97%E5%8F%A3.html
		this.driver.get("http://localhost/HTML-%E5%AF%B9%E8%AF%9D%E6%A1%86%E5%92%8C%E7%AA%97%E5%8F%A3.html");
		// this.driver.findElement(By.id("alertBtn")).click();
		// System.out.println(this.driver.switchTo().alert().getText());

		// this.driver.switchTo().frame(0);
		// this.driver.switchTo().frame("myframe");
		this.driver.switchTo().frame(this.driver.findElement(By.id("myframe")));
		this.driver.findElement(By.id("username")).sendKeys("admin");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.driver.findElement(By.id("password")).sendKeys("admin");
		this.driver.findElement(By.id("login")).click();

	}

	private void xlk() {
		// TODO Auto-generated method stub
		this.driver.get("http://localhost/Agileone/");
		this.driver.findElement(By.id("username")).sendKeys("admin");
		this.driver.findElement(By.id("password")).sendKeys("admin");
		this.driver.findElement(By.id("login")).click();
		this.driver.findElement(By.partialLinkText("需求提案")).click();

		new Select(this.driver.findElement(By.id("type"))).selectByVisibleText("Nothing");
		new Select(this.driver.findElement(By.id("importance"))).selectByVisibleText("Low");

		this.driver.findElement(By.id("headline")).sendKeys("wjb");
		this.driver.findElement(By.className("ke-common-icon")).click();
		this.driver.findElement(By.className("ke-textarea")).sendKeys("wjb");
		this.driver.findElement(By.id("add")).click();
	}

	private void onw() {
		// TODO Auto-generated method stub
		this.driver.get("http://localhost/Agileone/");
		this.driver.findElement(By.id("username")).sendKeys("admin");
		this.driver.findElement(By.id("password")).sendKeys("admin");
		this.driver.findElement(By.id("login")).click();

		this.actions.contextClick(this.driver.findElement(By.partialLinkText("需求提案"))).perform();
		this.actions.sendKeys("w").perform();
		// this.driver.findElement(By.id("headline")).sendKeys("wjb_1");
		// System.out.println(this.driver.getTitle());
		// System.out.println(this.driver.getWindowHandle());
		String currentWindow= this.driver.getWindowHandle();
		Set<String> windows = this.driver.getWindowHandles();
		for (String Handle : windows) {
			//System.out.println(Handle);
			if(!(Handle == currentWindow)) {
				this.driver.switchTo().window(Handle);
			}
		}
		
		this.driver.findElement(By.id("headline")).sendKeys("wjb__1");
		

	}
	
	private void xh() {
		// TODO Auto-generated method stub
		int[] ia= {1, 2, 3, 4, 5, 6};
		for(int v: ia) {
			System.out.println(v);
		}
	}

}
