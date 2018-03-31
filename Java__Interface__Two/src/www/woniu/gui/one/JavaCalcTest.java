package com.woniuxy.auto;

import java.awt.Component;
import java.awt.Frame;
import java.lang.reflect.Method;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JavaCalcTest {

	public static void main(String[] args) {
		JavaCalcTest calcTest = new JavaCalcTest();
		calcTest.startApp();
		calcTest.doTest();
	}
	
	public void doTest() {
		JFrame jf = this.getFrame("JavaSwing演示程序");
		JTextField numberx = (JTextField)this.getComponent(jf, "txtNumberX");
		numberx.setText("100");
		JTextField numbery = (JTextField)this.getComponent(jf, "txtNumberY");
		numbery.setText("200");
		
		JComboBox type = (JComboBox)this.getComponent(jf, "calcType");
		type.setSelectedItem("乘法");
		JButton btnCalc = (JButton)this.getComponent(jf, "btnCalc");
		btnCalc.doClick();

		double expect = 20000;
		JLabel result = (JLabel)this.getComponent(jf, "lblResult");
		double actual = Double.parseDouble(result.getText());
		if (actual == expect) {
			System.out.println("乘法运算：成功.");
		}
		else {
			System.out.println("乘法运算：失败.");
		}
	}
	
	public void startApp() {
		try {
//			Class<?> clazz = Class.forName("com.woniuxy.auto.JavaSwingCalc");
//			Method main = clazz.getMethod("main", String[].class);
//			main.invoke(clazz, new String[1]);
			
			JavaSwingCalc.main(new String[0]);
			
//			JavaSwingCalc calc = new JavaSwingCalc();
//			calc.windowInit();
//			calc.buttonInvoke();
			
//			String userDir = System.getProperty("user.dir");
//			String jarFile = userDir + "\\lib\\JavaSwingCalc.jar";
//			Runtime.getRuntime().exec("java -jar " + jarFile);
	
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public JFrame getFrame(String title) {
		Frame[] frames = JFrame.getFrames();
		JFrame jf = null;
		for (int i=0; i<frames.length; i++) {
			if (frames[i].getTitle().equals(title)) {
				jf = (JFrame)frames[i];
			}
		}
		return jf;
	}

	public Component getComponent(JFrame jf, String name) {
		Component[] controls = jf.getContentPane().getComponents();
		Component control = null;
		for (int i=0; i<controls.length; i++) {
			if (controls[i].getName() != null &&
					controls[i].getName().equals(name)) {
				control = controls[i];
			}
		}
		return control;
	}
}
