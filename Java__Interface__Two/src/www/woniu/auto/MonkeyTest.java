package www.woniu.auto;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.util.Random;

public class MonkeyTest {
	Robot robot= null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MonkeyTest monkey= new MonkeyTest();
		try {
			monkey.robot= new Robot();
			Runtime.getRuntime().exec("calc.exe");//IOException
			
			for(int i=0; i<100; i++) {
				monkey.move();
				Thread.sleep(1000); //InterruptedException
				monkey.mouse();
				Thread.sleep(1000);
				monkey.keyBoard();
				Thread.sleep(1000);
			}
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	//键盘随机输入
	private void keyBoard() {
		// TODO Auto-generated method stub
		int[] keys= {0x30, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39};
		int index= (int)(Math.random()*keys.length);
		this.robot.keyPress(keys[index]);
		this.robot.keyRelease(keys[index]);
	}
	
	private void mouse() {
		// TODO Auto-generated method stub
		int random= (int)(Math.random()*10);
		if(random >= 5) {
			this.robot.mousePress(InputEvent.BUTTON1_MASK);
			this.robot.mouseRelease(InputEvent.BUTTON1_MASK);
		}else {
			this.robot.mousePress(InputEvent.BUTTON3_MASK);
			this.robot.mouseRelease(InputEvent.BUTTON3_MASK);
		}

	}
	
	
	private void move() {
		// TODO Auto-generated method stub
		Random myrandom= new Random();
		int x= myrandom.nextInt(40);
		int y= myrandom.nextInt(40);
		robot.mouseMove(x, y);
	}
	

}
