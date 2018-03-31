package www.gui.Atesting;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Test
	public void seleniumApi() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.firefox.bin", "D:\\FireFox__37\\firefox.exe");
		WebDriver driver= new FirefoxDriver();
	}

}
