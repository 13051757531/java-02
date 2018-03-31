package www.woniu.gui.one;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.xvolks.jnative.JNative;
import org.xvolks.jnative.Type;
import org.xvolks.jnative.exceptions.NativeException;

public class CalcJava {
	static int BM_CLICK= 0x00F5;
	static int WM_CLOSE= 0x0010;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalcJava cj= new CalcJava();
		cj.calTest();
		

	}
	
	private void calTest() {
		// TODO Auto-generated method stub
		CalcJava cj= new CalcJava();
		try {
			
			//Process process= runtime.exec("dir d:");
			//Process process= runtime.exec("ping www.woniuxy.com");
			//Process process= runtime.exec("ipconfig");
			//InputStream is= process.getInputStream();
			//InputStreamReader isr= new InputStreamReader(is, "GBK");
			//BufferedReader br= new BufferedReader(isr);
			//String line= "", body="";
			//while((line=br.readLine()) != null) {
				//body +=line;
			//	body +=line + "\n";
			//}
			//System.out.println(body);
			//被测应用程序的启动
			Runtime runtime= Runtime.getRuntime();
			Process process= runtime.exec("tasklist");//检查被测应用程序是否启动
			InputStreamReader isr= new InputStreamReader(process.getInputStream());
			BufferedReader br= new BufferedReader(isr);
			String line= "";
			boolean isOpen= false;
			while((line=br.readLine()) != null) {
				if(line.indexOf("calc.exe") >= 0) {
					isOpen= true;
					break;
				}
			}
			if(!isOpen) {
				runtime.exec("D:\\calcen.exe");//强子指定的计算器
				Thread.sleep(2000);
			}
			
			
			//int parentHandle= 
			Thread.sleep(2000);
			int window= this.findWindow("sciCalc", "Calculator");
			System.out.println("应用程序编号为："+window);
			System.out.println("=========");
			
			int control= 0;
			control= this.findWindowEx(window, "Button", "3");
			this.sendMessage(control, BM_CLICK);			
			System.out.println(control);
			Thread.sleep(1000);
			
			control= this.findWindowEx(window, "Button", "+");
			this.sendMessage(control, BM_CLICK);
			Thread.sleep(1000);
			control= this.findWindowEx(window, "Button", "2");
			this.sendMessage(control, BM_CLICK);
			Thread.sleep(1000);
			control= this.findWindowEx(window, "Button", "=");
			this.sendMessage(control, BM_CLICK);
			Thread.sleep(1000);
			
			//将结果进行复制 Ctrl+C
			Robot robot= new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_C);
			Thread.sleep(2000);
			
			//从剪贴板取出复制的值，同预期结果进行比较，断言
			String content= "";
			Clipboard clip= Toolkit.getDefaultToolkit().getSystemClipboard();
			Transferable clipT= clip.getContents(null);
			if(clipT != null) {
				if(clipT.isDataFlavorSupported(DataFlavor.stringFlavor)) {
					content= (String) clipT.getTransferData(DataFlavor.stringFlavor);
				}
			}
			System.out.println(content);
			if(content.equals("5")) {
				System.out.println("测试成功");
			} else {
				System.out.println("测试失败");
			}
			
			this.sendMessage(window, WM_CLOSE);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block  
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block  InterruptedException
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block  InterruptedException AWTException 
			e.printStackTrace();
		} catch (UnsupportedFlavorException e) {
			// TODO Auto-generated catch block  InterruptedException AWTException UnsupportedFlavorException
			e.printStackTrace();
		}
		

	}
	
	
	private int findWindowEx(int parentHandle, String controlClass, String windowCaption) {
		// TODO Auto-generated method stub
		int result= 0;
		try {
			JNative jnative= new JNative("user32.dll", "FindWindowExA");
			jnative.setRetVal(Type.INT);
			jnative.setParameter(0, Type.INT, String.valueOf(parentHandle));
			jnative.setParameter(1, Type.INT, "0");
			jnative.setParameter(2, Type.STRING, controlClass);
			jnative.setParameter(3, Type.STRING, windowCaption);
			jnative.invoke();
			result= Integer.parseInt(jnative.getRetVal());
			
		} catch (NativeException e) {
			// TODO Auto-generated catch block  IllegalAccessException
			e.printStackTrace();
		}catch (IllegalAccessException e) {
			// TODO Auto-generated catch block  IllegalAccessException
			e.printStackTrace();
		}
		
		return result;
	}
	
	private int findWindow(String windowClass, String windowCaption ) {
		// TODO Auto-generated method stub
		int result= 0;
		try {
			JNative jnative= new JNative("user32.dll", "FindWindowA");
			jnative.setRetVal(Type.INT);
			jnative.setParameter(0, Type.STRING, windowClass);
			jnative.setParameter(1, Type.STRING, windowCaption);
			jnative.invoke();
			result= Integer.parseInt(jnative.getRetVal());
			
		} catch (NativeException e) {
			// TODO Auto-generated catch block  IllegalAccessException
			e.printStackTrace();
		}catch (IllegalAccessException e) {
			// TODO Auto-generated catch block  IllegalAccessException
			e.printStackTrace();
		}
		
		return result;
		

	}

	
	private void sendMessage(int parentHandle, int message) {
		// TODO Auto-generated method stub
		try {
			JNative jnative= new JNative("user32.dll", "SendMessageA");
			jnative.setRetVal(Type.VOID);
			jnative.setParameter(0, Type.INT, String.valueOf(parentHandle));
			jnative.setParameter(1, Type.INT, String.valueOf(message));
			jnative.setParameter(2, Type.STRING, "0");
			jnative.setParameter(3, Type.STRING, "0");
			jnative.invoke();
			Thread.sleep(2000);
			
		} catch (NativeException e) {
			// TODO Auto-generated catch block  IllegalAccessException InterruptedException
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block  IllegalAccessException
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block  IllegalAccessException
			e.printStackTrace();
		}
		
	}
	
	
	
	
}













