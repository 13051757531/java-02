package www.woniu.gui.one;

import java.awt.Component;
import java.awt.Frame;
import java.lang.reflect.Method;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Test__Five {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class<?> clazz= Class.forName("www.woniu.gui.one.MyCalc__Swing");
			Method main= clazz.getMethod("main", String[].class);
			main.invoke(clazz, new String[1]);
			
			Frame[] jframes= JFrame.getFrames();
			for(int i=0; i<jframes.length; i++) {
				System.out.println(jframes[i].getTitle());
//				if(jframes[i].getTitle().equals("Java演示程序")) {
//					JFrame jf= (JFrame)jframes[i];
//					Component[] com= jf.getContentPane().getComponents();
//					for(int j=0; j<com.length; j++) {
//						if(com[i].getName() != null && com[i].getName().equals("txtNumberX")) {
//							JTextField jt= (JTextField)com[i];
//							System.out.println(jt);
//							
//						}
//					}
//				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Frame[] jframes= JFrame.getFrames();
		for(int i=0; i<jframes.length; i++) {
			System.out.println(jframes[i].getTitle());
			if(jframes[i].getTitle().equals("Java演示程序")) {
				JFrame jf= (JFrame)jframes[i];
				Component[] controls= jf.getContentPane().getComponents();
				System.out.println(controls.length);
				for(int j=0; j<controls.length; j++) {
					System.out.println(controls[j].getName());
//					if(com[i].getName() != null && com[i].getName().equals("txtNumberX")) {
//						JTextField jt= (JTextField)com[i];
//						System.out.println(jt);
						
					}
				}
			}
		}

	}


