package www.gui.huohu.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DengLuPage {
	WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DengLuPage dl= new DengLuPage();
		//dl.init();
		//dl.doLogin("admin", "admin", true);
	}
	
	public DengLuPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
	}
	private WebElement getUsernameInputbox() {
		// TODO Auto-generated method stub
		return this.driver.findElement(By.id("username"));
	}
	
	private WebElement getPasswordInputbox() {
		// TODO Auto-generated method stub
		return this.driver.findElement(By.id("password"));
	}
	
	private WebElement getSaveloginInputbox() {
		// TODO Auto-generated method stub
		return this.driver.findElement(By.id("savelogin"));
	}
	
	private WebElement getLoginButton() {
		// TODO Auto-generated method stub
		return this.driver.findElement(By.id("login"));
	}
	
	
	public void doLogin(String username, String password, Boolean isSaveLogin) {
		// TODO Auto-generated method stub
		this.getUsernameInputbox().sendKeys(username);
		this.getPasswordInputbox().sendKeys(password);
		if(isSaveLogin){
			this.getSaveloginInputbox().click();
		}
		this.getLoginButton().click();
	}
}
