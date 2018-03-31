package www.gui.v4;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class Sikuli {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Screen s= new Screen();
		try {
			
			s.doubleClick("d:\\guge.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
