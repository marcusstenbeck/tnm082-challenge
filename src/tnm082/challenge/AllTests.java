package tnm082.challenge;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(MissionTest.class);
		suite.addTestSuite(UserTest.class);
		//$JUnit-END$
		return suite;
	}

}
