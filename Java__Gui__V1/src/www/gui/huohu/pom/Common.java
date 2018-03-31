package www.gui.huohu.pom;

import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Common {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Common c= new Common();
		c.getScreenWH();
	}
	
	private void sleepSecond(int n) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(n*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int[] getScreenWH() {
		// TODO Auto-generated method stub
		int height= 0;
		int width= 0;
		height= (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		width= (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
//		System.out.println(height+"__"+width);
		int[] result= {width, height};
		return result;
	}

}
