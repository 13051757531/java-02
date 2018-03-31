package www.woniu.auto;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class RobotMouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//启动计算器
			Runtime.getRuntime().exec("calc.exe");
			Thread.sleep(3000);
			
			//鼠标操作
			Robot robot= new Robot();
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			Thread.sleep(20000);
			
			robot.mousePress(InputEvent.BUTTON3_MASK);
			robot.mouseRelease(InputEvent.BUTTON3_MASK);
			Thread.sleep(20000);
			
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
