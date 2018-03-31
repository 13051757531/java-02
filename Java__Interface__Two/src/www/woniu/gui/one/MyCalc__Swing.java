package www.woniu.gui.one;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyCalc__Swing extends JFrame {
	// 定义界面元素、完成初始化操作
	private JPanel jpanel = new JPanel();
	private JLabel jlable1 = new JLabel("运算数一");
	private JLabel jlable2 = new JLabel("运算数二");
	private JLabel jlable3 = new JLabel("运算类型");
	private JLabel jlable4 = new JLabel("计算结果");
	private JButton btnCalc = new JButton("计算");
	private JButton btnClose = new JButton("关闭");

	// 定义运算数一、运算数二
	private JTextField txtNumberX = new JTextField("1");
	private JTextField txtNumbery = new JTextField("2");

	// 定义下拉框：加、减、乘、除
	private JComboBox<String> calcType = new JComboBox<String>();
	private JLabel lblResult = new JLabel("结果在此显示.......S");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCalc__Swing calc = new MyCalc__Swing();
		calc.windowInit();
		calc.buttonInvoke();

	}

	// 窗口初始化操作，设置元素大小、位置、初始值
	private void windowInit() {
		// TODO Auto-generated method stub
		// 窗口基本属性
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(420, 280);
		this.setTitle("Java演示程序");

		// 控件属性、窗口位置
		jlable1.setSize(new Dimension(80, 20));
		jlable1.setFont(new Font("Dialog", Font.BOLD, 12));
		jlable1.setLocation(new Point(58, 40));

		jlable2.setSize(new Dimension(80, 20));
		jlable2.setLocation(new Point(58, 74));

		jlable3.setSize(new Dimension(80, 20));
		jlable3.setLocation(new Point(58, 108));

		jlable4.setSize(new Dimension(80, 20));
		jlable4.setLocation(new Point(58, 148));

		txtNumberX.setLocation(new Point(162, 41));
		txtNumberX.setName("txtNumberX");
		txtNumberX.setSize(new Dimension(160, 21));

		txtNumbery.setLocation(new Point(162, 74));
		txtNumbery.setName("txtNumberY");
		txtNumbery.setSize(new Dimension(160, 21));

		// 为下拉框添4个加运算符
		calcType.addItem("加法");
		calcType.addItem("减法");
		calcType.addItem("乘法");
		calcType.addItem("除法");
		calcType.setLocation(new Point(162, 108));
		calcType.setName("calcType");
		calcType.setSize(new Dimension(160, 21));

		lblResult.setSize(new Dimension(150, 20));
		lblResult.setName("lblResult");
		lblResult.setBackground(Color.white);
		lblResult.setLocation(new Point(162, 148));

		btnCalc.setLocation(new Point(91, 190));
		btnCalc.setName("btnCalc");
		btnCalc.setSize(new Dimension(90, 21));

		btnClose.setLocation(new Point(210, 190));
		btnClose.setName("btnClose");
		btnClose.setSize(new Dimension(80, 21));

		// 将控件放到容器中
		jpanel.setLayout(null);
		jpanel.add(jlable1);
		jpanel.add(jlable2);
		jpanel.add(jlable3);
		jpanel.add(jlable4);
		jpanel.add(txtNumberX);
		jpanel.add(txtNumbery);
		jpanel.add(lblResult);
		jpanel.add(btnCalc);
		jpanel.add(btnClose);
		jpanel.add(calcType);
		this.add(jpanel);

	}

	// 执行运算和关闭应用程序
	private void buttonInvoke() {
		// TODO Auto-generated method stub
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				doClose();
			}
		});

		btnCalc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double numberX = Double.parseDouble(txtNumberX.getText());
				double numberY = Double.parseDouble(txtNumbery.getText());
				double result = doCalc(numberX, numberY);
				lblResult.setText(String.valueOf(result));
			}
		});

	}

	// 关闭应用程序
	private void doClose() {
		// TODO Auto-generated method stub
		System.exit(1);
	}

	// 计算操作
	public double doCalc(double x, double y) {
		// TODO Auto-generated method stub
		double result = 0;
		if(calcType.getSelectedItem().equals("加法")) {
			result= x + y;
		}else if(calcType.getSelectedItem().equals("减法")) {
			result= x - y;
		}else if(calcType.getSelectedItem().equals("乘法")) {
			result= x * y;
		}else if(calcType.getSelectedItem().equals("除法")) {
			result= x / y;
		}
		
		return result;
	}

}
