package www.woniu.gui.teacher.one;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.xvolks.jnative.JNative;
import org.xvolks.jnative.Type;

public class WinCalcTest {
	
	// 定义Windows消息，对应单击和关闭，以16进制表示其值
	private static int BM_CLICK = 0x00F5;
	private static int WM_CLOSE = 0x0010;

	public static void main(String[] args) throws Exception {
		WinCalcTest wct = new WinCalcTest();
		wct.calcTest(); 
	}
	
	public void calcTest() throws Exception {
		this.runApp("D:\\calcen.exe");
		
		// 识别和操作计算器窗口及里面的各个元素
		int parentHandle = this.findWindow("sciCalc", "Calculator");
		
		
//		int control= 0;
//		control= this.findWindowEx(parentHandle, "Button", "3");
//		this.sendMessage(control, BM_CLICK);			
//		System.out.println(control);
//		Thread.sleep(1000);
		
		
		int buttonHandle = 0;	// 定义按钮的句柄
		buttonHandle = this.findWindowEx(parentHandle, "Button", "3");
		this.sendMessage(buttonHandle, BM_CLICK);
		System.out.println(buttonHandle);
		
		buttonHandle = this.findWindowEx(parentHandle, "Button", "+");
		this.sendMessage(buttonHandle, BM_CLICK);
		buttonHandle = this.findWindowEx(parentHandle, "Button", "2");
		this.sendMessage(buttonHandle, BM_CLICK);
		buttonHandle = this.findWindowEx(parentHandle, "Button", "=");
		this.sendMessage(buttonHandle, BM_CLICK);
		Thread.sleep(2000);
		
		// 按组合键Ctrl+C将结果复制到剪贴板
		this.keyCopy();
		
		// 从剪贴板中取出刚才复制的数据，与期望结果进行比较，以实现断言
		if (this.getClipboardText().equals("5")) {
			System.out.println("测试成功.");
		}
		else {
			System.out.println("测试失败.");
		}
		
		// 关闭窗口
		this.sendMessage(parentHandle, WM_CLOSE);
	}
	
	// 运行计算器程序（运行之前先判断程序是否已经启动）
	public void runApp(String processName) throws Exception {
		// 运行DOS命令tasklist来获取进程列表
		Process proc = Runtime.getRuntime().exec("tasklist");
		InputStreamReader isr = new InputStreamReader(proc.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		boolean isOpened = false;
		while ((line = br.readLine()) != null) {
			// 如果找到了进程名已经存在于列表中，表明程序已经运行
			if (line.indexOf(processName) >= 0) {
				isOpened = true;	
				break;
			}
		}
		
		if (!isOpened) {
		// 运行系统自带的计算器程序	
			Runtime runtime = Runtime.getRuntime();
			runtime.exec(processName);
			Thread.sleep(2000);
		}
	}
	
	// 读取操作系统的剪贴板内容，以获取到计算器的运算结果
	public String getClipboardText() throws Exception {
		String content = "";
	    Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
	    // 获取剪切板中的内容
	    Transferable clipT = clip.getContents(null);
	    if (clipT != null) {
	    // 检查内容是否是文本类型，也可获取其它类型的剪贴板内容
	    if (clipT.isDataFlavorSupported(DataFlavor.stringFlavor))
	    	content = (String)clipT.getTransferData(DataFlavor.stringFlavor); 
	    }
	    return content;
	}
	
	// 按下Ctrl+C对计算结果进行复制
	public void keyCopy() throws Exception {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
		
		Thread.sleep(2000);
	}

	// 映射user32的FindWindow函数，对应的参数为
	// 1. windowClass: 窗口对应的Class属性，即类型
	// 2. windowCaption: 窗口对应的Caption属性，即标题
	public int findWindow(String windowClass, String windowCaption) throws Exception {
		// 加载user32.dll文件，同时指定要调用的函数FindWindowA.
		// 此处后缀必须加A，否则JNative无法定位到FindWindow，下同
		JNative jnative = new JNative("user32.dll","FindWindowA");
		jnative.setRetVal(Type.INT); // 设置其返回值类型
		jnative.setParameter(0, Type.STRING, windowClass);
		jnative.setParameter(1, Type.STRING, windowCaption);
		jnative.invoke();
		return Integer.parseInt(jnative.getRetVal()); // 返回找到的元素的句柄
	}
	
	// 映射user32的FindWindowEx函数，对应的参数为
	// 1. parentHandle: 控件元素所在的父窗口句柄
	// 2. controlClass: 控件元素对应的类型
	// 3. controlCaption: 控件元素对应的标题
	public int findWindowEx(int parentHandle, String controlClass, String controlCaption) throws Exception {
		JNative jnative = new JNative("user32.dll","FindWindowExA");
		jnative.setRetVal(Type.INT);
		jnative.setParameter(0, Type.INT, String.valueOf(parentHandle));
		jnative.setParameter(1, Type.INT, "0");
		jnative.setParameter(2, Type.STRING, controlClass);
		jnative.setParameter(3, Type.STRING, controlCaption);
		jnative.invoke();
		return Integer.parseInt(jnative.getRetVal());
	}
	
	// 处理SendMessage函数
	public void sendMessage(int parentHandle, int message) throws Exception {
		JNative jnative = new JNative("user32.dll","SendMessageA");
		jnative.setRetVal(Type.VOID);
		jnative.setParameter(0, Type.INT, String.valueOf(parentHandle));
		jnative.setParameter(1, Type.INT, String.valueOf(message));
		jnative.setParameter(2, Type.INT, "0");
		jnative.setParameter(3, Type.INT, "0");
		jnative.invoke();
		Thread.sleep(1000);
	}
}