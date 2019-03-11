import java.util.Set;
import java.util.TreeSet;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestReportGenerator extends TestListenerAdapter implements IInvokedMethodListener {
	private static Set<String> failedTests = new TreeSet<String>();
	private static Set<String> passedTests = new TreeSet<String>();
	private static Set<String> skippedTests = new TreeSet<String>();
	// private String testName = "";
	private ThreadLocal<String> testName = new ThreadLocal<String>();

	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		failedTests.add(testName.get());
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		super.onTestSkipped(tr);
		skippedTests.add(testName.get());

	}

	public static Set<String> getPassedList() {

		return passedTests;
	}

	public static Set<String> getFailedList() {
		return failedTests;
	}

	public static Set<String> getSkippedList() {
		return skippedTests;
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
		passedTests.add(testName.get());

	}

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// System.out.println("Hit #" + counter + ", isTestMethod = " +
		// method.isTestMethod());
		if (method.isTestMethod()) {
			// System.out.println(" CURRENT THREAD IS " +
			// method.getTestMethod().getMethodName() + "_"
			// + Thread.currentThread().getName() + "_" +
			// method.getTestMethod().getCurrentInvocationCount()
			// + " THREAD IS IS " + Thread.currentThread().getId());
			testName.set(method.getTestMethod().getMethodName() + "_" + Thread.currentThread().getName() + "_"
					+ method.getTestMethod().getCurrentInvocationCount());
			// System.out
			// .println("Created - " + testName.get() + " at counter " +
			// (counter++) + ", me=" + this.hashCode());
		}
	}

	public String getTestName() {
		// System.out.println("RETURNED TEST NAME AS " + this.testName);
		return this.testName.get();
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
	}

}