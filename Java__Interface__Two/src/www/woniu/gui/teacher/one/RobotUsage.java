package com.woniuxy.auto;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class RobotUsage {

	public static void main(String[] args) {
		
		try {
			// 任何在命令行可以运行的命令，均可以由exec方法调用
			Runtime.getRuntime().exec("calc.exe");
			Thread.sleep(3000);
			
			// 键盘的操作
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_3);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ADD);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_2);
			Thread.sleep(1000);
			// robot.keyPress(KeyEvent.VK_EQUALS);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			
			// 鼠标的操作
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);
			
			Thread.sleep(2000);
			
			robot.mousePress(InputEvent.BUTTON3_MASK);
			robot.mouseRelease(InputEvent.BUTTON3_MASK);
			
			Thread.sleep(2000);
			
			// 组合按键Alt+F4关闭当前窗口
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.keyRelease(KeyEvent.VK_F4);
			
		} catch (AWTException e) {
			e.printStackTrace();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
