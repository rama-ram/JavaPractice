import org.testng.annotations.BeforeSuite;

public class TestBeforeSuite {
	public static String tests;

	@BeforeSuite
	public void testBeforeSuite() {
		System.out.println(" this is before suite test **");
		tests = "Value1";

	}

}
