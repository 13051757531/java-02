package www.woniu.auto;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class RobotUseage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//启动计算器
			Runtime.getRuntime().exec("calc.exe");
			
			//键盘操作
			Thread.sleep(3000);
			Robot robot= new Robot();
			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_2);
			Thread.sleep(1000);
			//robot.keyRelease(KeyEvent.VK_2);\
			robot.keyPress(KeyEvent.VK_ADD);
			robot.keyPress(KeyEvent.VK_3);
			//robot.keyPress(KeyEvent.VK_EQUALS);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			
			//程序退出
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.keyRelease(KeyEvent.VK_F4);
			
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block  
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block  InterruptedException  IOException
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block  InterruptedException  IOException
			e.printStackTrace();
		}

	}

}
