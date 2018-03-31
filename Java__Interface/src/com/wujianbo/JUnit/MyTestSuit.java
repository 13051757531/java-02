package com.wujianbo.JUnit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
			{
				JUnit3TestBasic.class,
				JUnit4TestBasic.class
			}
		)

public class MyTestSuit {
	
}
