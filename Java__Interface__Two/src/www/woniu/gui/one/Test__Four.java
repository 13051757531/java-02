package www.woniu.gui.one;

import java.awt.Component;
import java.awt.Frame;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Test__Four {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test__Four tf= new Test__Four();
		tf.startApp();
		try {
			Thread.sleep(3000);
			tf.doTest();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// 启动应用程序
	private void startApp() {
		// TODO Auto-generated method stub
		System.out.println("启动计算器应用程序........");

		try {
			URL urls[] = new URL[1];
			// urls[0]= new URL("file::CalcJava.jar");
			// System.out.println(urls[0]);
			URLClassLoader loader = new URLClassLoader(urls);
			Class<?> c = loader.loadClass("www.woniu.gui.one.MyCalc__Swing");
			Method main = c.getMethod("main", String[].class);
			main.invoke(null, new String[1]);
			loader.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//执行测试
	private void doTest() {
		// TODO Auto-generated method stub
		JFrame jf= this.getFrame("Java演示程序");
		//System.out.println(jf);
//		JTextField number1= (JTextField)this.getComponent(jf, "txtNumberX");
//		System.out.println(number1);
//		//number1.setText("100");
//		
//		JTextField number2= (JTextField)this.getComponent(jf, "txtNumbery");
//		//number2.setText("100");
//
//		JComboBox type= (JComboBox)this.getComponent(jf, "CalcType");
//		//type.setSelectedItem("乘法");
//		
//		JButton btnCalc= (JButton)this.getComponent(jf, "btnCalc");
//		//btnCalc.doClick();
//		
//		double expect= 100;
//		JLabel result= (JLabel)this.getComponent(jf, "lblResult");
//		//System.out.println(result);
	}
	//获取标题为tittle的frame
	private JFrame getFrame(String tittle) {
		// TODO Auto-generated method stub
		Frame[] jframes= JFrame.getFrames();
		//for(int i=0; i<jframes.length; i++) {
		//	System.out.println(jframes[i].getTitle());
		//}
		JFrame jf= null;
		for(int i=0; i<jframes.length; i++) {
			if(jframes[i].getTitle().equalsIgnoreCase(tittle)) {
				//JFrame jf= return (JFrame)jframes[i];
				jf= (JFrame)jframes[i];
			}
		}
		Component[] controls= jf.getContentPane().getComponents();
		for(int j=0; j<controls.length; j++) {
			//System.out.println(controls[j].getName());
		}
		return null;
	}
	
	//获取frame下的名为controlName的控件
	private Component getComponent(JFrame jf, String controlName) {
		// TODO Auto-generated method stub
		Component[] controls= jf.getContentPane().getComponents();
		for(int i=0; i<controls.length; i++) {
			//System.out.println(controls[i].getName());
		}
		for(int i=0; i<controls.length; i++) {
			if(controls[i].getName() != null) {
				if(controls[i].getName().equalsIgnoreCase(controlName)) {
					return controls[i];
				}
				
			}
		}
		return null;
	}

}
