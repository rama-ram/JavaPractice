import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test()
public class testAnno2 {

	// @AfterClass()
	// public void afterTest(ITestContext context){
	// for (ITestNGMethod testNGMethod : context.getAllTestMethods()) {
	// testNGMethod.setInvocationCount(5);
	// System.out.println("method name is " + testNGMethod.getMethodName() + "
	// and invocation time is " + testNGMethod.getCurrentInvocationCount());
	// }
	//
	// }
	@BeforeClass()
	public void beforeTest(ITestContext context) {
		System.out.println("the before suite value in test2 is " + TestBeforeSuite.tests);
	}

	// }
	@Test(dataProvider = "dp")
	public void test3(String x, String y) {
		System.out.println(" test 3 from class 2" + this.getClass());
		Assert.assertFalse(true);
	}

	@Test(dataProvider = "dp")
	public void test4(String x, String y) {
		System.out.println(" test 4 from class 2" + this.getClass());
		Assert.assertFalse(false);
	}

	@DataProvider(parallel = true, name = "dp")
	Object[][] dp() {
		Object[][] obj = new Object[4][2];
		obj[0][0] = "user1";
		obj[0][1] = "password1";
		obj[1][0] = "user2";
		obj[1][1] = "password2";
		obj[2][0] = "user23";
		obj[2][1] = "password23";
		obj[3][0] = "user33";
		obj[3][1] = "password33";
		return obj;
	}

}
