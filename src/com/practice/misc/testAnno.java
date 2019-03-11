import java.io.IOException;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testAnno {

	private static String testName;

	@BeforeClass
	public void setUp(ITestContext context) throws IOException {
		System.out.println("the before suite value in test1 is " + TestBeforeSuite.tests);
		testName = context.getAllTestMethods()[0].getMethodName();
	}

	@Test(invocationCount = 7, dataProvider = "dp")
	public void testt1(String x, String y, ITestContext context) {
		String tid = Thread.currentThread().getName() + "_"
				+ context.getAllTestMethods()[0].getCurrentInvocationCount();
		System.out.println("the invocation count with thread id is " + tid);
	}

	@DataProvider(parallel = true, name = "dp")
	Object[][] dp() {
		Object[][] obj = new Object[2][2];
		obj[0][0] = "user1";
		obj[0][1] = "password1";
		obj[1][0] = "user2";
		obj[1][1] = "password2";

		return obj;
	}

}
