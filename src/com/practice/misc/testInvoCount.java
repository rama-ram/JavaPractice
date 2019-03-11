import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testInvoCount {
	@BeforeSuite
	void testBeforeSuite() {
		System.out.println(" this is before suite test 1 **");
	}

	testInvoCount() {
		System.out.println("CONSTRUCTOR ");
	}

	private static final long serialVersionUID = 1L;

	private static String testName;
	private static String outputFolder;
	private static final String log = "LOGS";

	@BeforeClass
	public void setUp(ITestContext context) throws IOException {
		createLogDir(context);
		testName = context.getAllTestMethods()[0].getMethodName();
	}

	private void createLogDir(ITestContext context) throws IOException {
		outputFolder = context.getOutputDirectory() + File.separator + log + File.separator
				+ context.getAllTestMethods()[0].getMethodName();
		File file = new File(outputFolder);
		if (file.exists()) {
			delete(file);
		}
		if (file.mkdirs()) {
			System.out.println("Directory is created!");
		} else {
			System.out.println("Failed to create directory!");
		}
		System.out.println("the o/p dir is " + outputFolder);

	}

	public static void delete(File file) throws IOException {

		if (file.isDirectory()) {

			// directory is empty, then delete it
			if (file.list().length == 0) {

				file.delete();
				System.out.println("Directory is deleted : " + file.getAbsolutePath());

			} else {

				// list all the directory contents
				String files[] = file.list();

				for (String temp : files) {
					// construct the file structure
					File fileDelete = new File(file, temp);

					// recursive delete
					delete(fileDelete);
				}

				// check the directory again, if empty then delete it
				if (file.list().length == 0) {
					file.delete();
					System.out.println("Directory is deleted : " + file.getAbsolutePath());
				}
			}

		} else {
			// if file, then delete it
			file.delete();
			System.out.println("File is deleted : " + file.getAbsolutePath());
		}
	}

	public void writeLog(String msg, String className, String threadId) {
		FileWriter ex = null;
		try {
			File file = new File(outputFolder + File.separator + threadId + ".log");
			if (file.createNewFile()) {
				// System.out.println("File is created!");
			} else {
				// System.out.println("File already exists.");
			}

			ex = new FileWriter(file, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuilder log = new StringBuilder(1000);
		String timestamp = DateFormat.getDateTimeInstance(3, 3, Locale.ENGLISH).format(new Date());
		log.append(timestamp + "[Thread " + threadId + "] - " + msg);
		if (log.length() > 10) {
			try {
				ex.write(log.toString());
				ex.write("\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			log = new StringBuilder(1000);
		}
		try {
			ex.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// @Test(invocationCount=1)
	// public void testCaller(){
	// for (int i=0;i<3;i++)
	// testt1();
	// }
	@Test(invocationCount = 7, dataProvider = "dp")
	public void testt1(String x, String y, ITestContext context) {
		String tid = Thread.currentThread().getName() + "_"
				+ context.getAllTestMethods()[0].getCurrentInvocationCount();
		writeLog("************STARTING TEST******", this.getClass().getName(), tid);

	}

	// @Test(dataProvider="dp")
	// public void testt2(String x, String y, ITestContext
	// context){System.out.println("*******TESTT2*****");Assert.assertFalse(false);
	// String tid =
	// Thread.currentThread().getName()+"_"+context.getAllTestMethods()[0].getCurrentInvocationCount();
	// writeLog("************STARTING TEST******" , this.getClass().getName(),
	// tid);}
	// @Test(invocationCount=1,dataProvider="dp")
	public void test2(String x, String y, ITestContext context) {
		String name = this.getClass().getName();
		System.out.println("THE CLASS NAME IS " + name);
		String tid = Thread.currentThread().getName() + "_"
				+ context.getAllTestMethods()[0].getCurrentInvocationCount();
		System.out.println(" user and invocation count combination is" + Thread.currentThread().getName()
				+ " invocaton count is " + context.getAllTestMethods()[0].getCurrentInvocationCount());
		writeLog("************STARTING TEST******", name, tid);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writeLog("************ENDED TEST******", name, tid);
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

	@AfterClass
	public synchronized void publishResult(ITestContext context) {
		EmailableReporter.sendReport(context, testName);
	}

}
