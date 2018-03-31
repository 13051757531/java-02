package com.wujianbo.JUnit;
import com.wujianbo.compare.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ParamTest {
	public String source= "aaa";
	public Boolean resut;
	
	public ParamTest(String source, Boolean resut) {
		// TODO Auto-generated constructor stub
		this.source= source;
		this.resut= resut;
	}
	
	@Parameters
	@SuppressWarnings("unlocked")
	static public Collection getParameters() {
		// TODO Auto-generated method stub
		Object[][] object= {
					{"12345", true}, 
					{"tt123545", false},
					{"", false},
					{null, false},
					{"###", false}
				};
		return Arrays.asList(object);

	}
	
	@Test
	public void isNumper_pam() {
		// TODO Auto-generated method stub
		//System.out.println("fga ");
		Boolean actual= new StringHandle().isNumber(this.source);
		assertEquals(this.resut, actual);

	}
}
