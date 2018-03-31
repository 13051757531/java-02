package www.gui.v1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Gui__V1__Ie {
	WebDriver driver= null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gui__V1__Ie gv= new Gui__V1__Ie();
		gv.init();

	}
	
	private void init() {
		// TODO Auto-generated method stub
		// System.setProperty("webdriver.firefox.bin", "D:\\Mozilla
		// Firefox_53\\firefox.exe");
		System.setProperty("", "");
		System.setProperty("webdriver.ie.driver",
				"C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe");
		// this.driver= new FirefoxDriver();//启动火狐浏览器
		DesiredCapabilities dc= DesiredCapabilities.internetExplorer();
		dc.setCapability("ignoreProtectedModeSettings", true);
		driver= new InternetExplorerDriver(dc);
		
		//this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// 元素等待时间
		//this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// 页面加载时间
		//this.driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);// ajax请求
		//this.driver.manage().window().maximize();
		//this.driver.get("https://www.baidu.com/");// 在浏览器中打开该网址
	}

}
