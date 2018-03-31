package www.wujianbo.testng;

import com.wujianbo.compare.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class StringHandlerTestPara {
	
	@DataProvider(name= "isNumberPara")
	public Object[][] users() {
		return new Object[][] {
				{"123", true},
				{"888", true},
				{"888t", false}
			};
	}
		
	
	@Test(dataProvider= "isNumberPara")
	public void isNumberPara(String number, boolean expect) {
		// TODO Auto-generated method stub
		String source= number;
		boolean actual= new StringHandle().isNumber(source);
		System.out.println(actual);
		Assert.assertEquals(actual, expect);
		

	}
}
