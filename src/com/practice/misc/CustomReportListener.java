import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.mail.Session;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.velocity.VelocityContext;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestNGMethod;
import org.testng.Reporter;
import org.testng.IClass;
import org.testng.IReporter;
import org.testng.ITestResult;
import org.testng.IResultMap;
import org.testng.xml.XmlSuite;
import org.uncommons.reportng.AbstractReporter;
import org.uncommons.reportng.ReportNGException;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.collections.Lists;
import org.testng.collections.Maps;
import org.testng.collections.Sets;
import org.testng.internal.Utils;
import org.testng.reporters.XMLReporterConfig;
import org.testng.reporters.XMLStringBuffer;
import org.testng.reporters.XMLSuiteResultWriter;
import org.testng.xml.XmlSuite;

public class CustomReportListener  implements IReporter {
	public static final String FILE_NAME = "TestReport_junit.xml";
	private final XMLReporterConfig config = new XMLReporterConfig();
	private XMLStringBuffer rootBuffer;

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		if (Utils.isStringEmpty(config.getOutputDirectory())) {
			config.setOutputDirectory(outputDirectory + "/../");
		}

		// Calculate passed/failed/skipped
		int passed = 0;
		int failed = 0;
		int skipped = 0;
		int ignored = 0;
		for (ISuite s : suites) {
			Map<String, ISuiteResult> suiteResults = s.getResults();
			synchronized (suiteResults) {
				for (ISuiteResult sr : suiteResults.values()) {
					ITestContext testContext = sr.getTestContext();
					passed += testContext.getPassedTests().size();
					failed += testContext.getFailedTests().size();
					skipped += testContext.getSkippedTests().size();
					ignored += testContext.getExcludedMethods().size();
				}
			}
		}

		rootBuffer = new XMLStringBuffer();
		Properties p = new Properties();
		p.put("name", xmlSuites.get(0).getName());
		// p.put("passed", passed);
		// p.put("failed", failed);
		// p.put("skipped", skipped);
		// p.put("ignored", ignored);
		// p.put("total", passed + failed + skipped + ignored);
		rootBuffer.push("testsuites", p);
		// writeReporterOutput(rootBuffer);
		for (ISuite suite : suites) {
			writeSuite(suite.getXmlSuite(), suite);
		}
		rootBuffer.pop();
		Utils.writeUtf8File(config.getOutputDirectory(), FILE_NAME, rootBuffer, null /* no prefix */);
		
		System.out.println("STARTING CUSTOM LISTENER***********************");
		sendMail(outputDirectory);
	}
	private static void sendMail(String outputDirectoryName){
		final String username = "testUser@gmail.com";
	final String password = "password";
	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");

	Session session = Session.getInstance(props,
	  new javax.mail.Authenticator() {
	    protected PasswordAuthentication getPasswordAuthentication() {
	        return new PasswordAuthentication(username, password);
	    }
	  });

	try {

	    Message message = new MimeMessage(session);
	    message.setFrom(new InternetAddress("rama.rajeswari.ramachandran@oracle.com"));
	    message.setRecipients(Message.RecipientType.TO,
	        InternetAddress.parse("rama.rajeswari.ramachandran@oracle.com"));
	    message.setSubject("Testing Subject");
	    message.setText("Dear Mail Crawler,"
	        + "\n\n No spam to my email, please!");

	    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  

	    String filename = outputDirectoryName+"Suite1\\test.html";
	    DataSource source = new FileDataSource(filename);  
	    messageBodyPart2.setDataHandler(new DataHandler(source));  
	    messageBodyPart2.setFileName(filename);  



	    Multipart multipart = new MimeMultipart();  
	    multipart.addBodyPart(messageBodyPart2);  

	     message.setContent(multipart );  


	    Transport.send(message);
	    System.out.println("***********completed emailing report*********");
	    System.out.println("Done");
	    

	} catch (MessagingException e) {
	    throw new RuntimeException(e);
	}}
	// private void writeReporterOutput(XMLStringBuffer xmlBuffer) {
	// // TODO: Cosmin - maybe a <line> element isn't indicated for each line
	// xmlBuffer.push(XMLReporterConfig.TAG_REPORTER_OUTPUT);
	// List<String> output = Reporter.getOutput();
	// for (String line : output) {
	// if (line != null) {
	// xmlBuffer.push(XMLReporterConfig.TAG_LINE);
	// xmlBuffer.addCDATA(line);
	// xmlBuffer.pop();
	// }
	// }
	// xmlBuffer.pop();
	// }

	private void writeSuite(XmlSuite xmlSuite, ISuite suite) {
		// switch (config.getFileFragmentationLevel()) {
		// case XMLReporterConfig.FF_LEVEL_NONE:
		writeSuiteToBuffer(rootBuffer, suite);
		// break;
		// case XMLReporterConfig.FF_LEVEL_SUITE:
		// case XMLReporterConfig.FF_LEVEL_SUITE_RESULT:
		// File suiteFile = referenceSuite(rootBuffer, suite);
		// writeSuiteToFile(suiteFile, suite);
		// break;
		// default:
		// throw new AssertionError("Unexpected value: " +
		// config.getFileFragmentationLevel());
		// }
	}

	private void writeSuiteToFile(File suiteFile, ISuite suite) {
		XMLStringBuffer xmlBuffer = new XMLStringBuffer();
		writeSuiteToBuffer(xmlBuffer, suite);
		File parentDir = suiteFile.getParentFile();
		suiteFile.getParentFile().mkdirs();
		if (parentDir.exists() || suiteFile.getParentFile().exists()) {
			Utils.writeUtf8File(parentDir.getAbsolutePath(), FILE_NAME, xmlBuffer.toXML());
		}
	}

	private void writeSuiteToBuffer(XMLStringBuffer xmlBuffer, ISuite suite) {

		// xmlBuffer.push("testsuite", getSuiteAttributes(suite));
		// writeSuiteGroups(xmlBuffer, suite);

		Map<String, ISuiteResult> results = suite.getResults();
		XMLSuiteResultWriter suiteResultWriter = new XMLSuiteResultWriter(config);
		for (Map.Entry<String, ISuiteResult> result : results.entrySet()) {

			writeSuiteResult(xmlBuffer, result.getValue());
		}

		// xmlBuffer.pop();
	}

	public void writeSuiteResult(XMLStringBuffer xmlBuffer, ISuiteResult suiteResult) {
		referenceSuiteResult(xmlBuffer, suiteResult);
		// to write the methods
		writeAllToBuffer(xmlBuffer, suiteResult);
	}

	private void writeAllToBuffer(XMLStringBuffer xmlBuffer, ISuiteResult suiteResult) {
		xmlBuffer.push("testsuite", getSuiteResultAttributes(suiteResult));
		Set<ITestResult> testResults = Sets.newHashSet();
		ITestContext testContext = suiteResult.getTestContext();
		addAllTestResults(testResults, testContext.getPassedTests());
		addAllTestResults(testResults, testContext.getFailedTests());
		addAllTestResults(testResults, testContext.getSkippedTests());
		addAllTestResults(testResults, testContext.getPassedConfigurations());
		addAllTestResults(testResults, testContext.getSkippedConfigurations());
		addAllTestResults(testResults, testContext.getFailedConfigurations());
		addAllTestResults(testResults, testContext.getFailedButWithinSuccessPercentageTests());
		addTestResults(xmlBuffer, testResults);
		xmlBuffer.pop();
	}

	@SuppressWarnings("unchecked")
	private void addAllTestResults(Set<ITestResult> testResults, IResultMap resultMap) {
		if (resultMap != null) {
			// Sort the results chronologically before adding them
			List<ITestResult> allResults = new ArrayList<>();
			allResults.addAll(resultMap.getAllResults());

			Collections.sort(new ArrayList(allResults), new Comparator<ITestResult>() {
				@Override
				public int compare(ITestResult o1, ITestResult o2) {
					return (int) (o1.getStartMillis() - o2.getStartMillis());
				}
			});

			testResults.addAll(allResults);
		}
	}

	private void addTestResults(XMLStringBuffer xmlBuffer, Set<ITestResult> testResults) {
		Map<String, List<ITestResult>> testsGroupedByClass = buildTestClassGroups(testResults);
		for (Map.Entry<String, List<ITestResult>> result : testsGroupedByClass.entrySet()) {
			Properties attributes = new Properties();
			String className = result.getKey();
			if (config.isSplitClassAndPackageNames()) {
				int dot = className.lastIndexOf('.');
				attributes.setProperty(XMLReporterConfig.ATTR_NAME,
						dot > -1 ? className.substring(dot + 1, className.length()) : className);
				attributes.setProperty(XMLReporterConfig.ATTR_PACKAGE,
						dot > -1 ? className.substring(0, dot) : "[default]");
			} else {
				attributes.setProperty(XMLReporterConfig.ATTR_NAME, className);
			}

			// xmlBuffer.push(XMLReporterConfig.TAG_CLASS, attributes);
			List<ITestResult> sortedResults = result.getValue();
			Collections.sort(sortedResults);
			for (ITestResult testResult : sortedResults) {
				addTestResult(xmlBuffer, testResult);
			}
			// xmlBuffer.pop();
		}
	}

	private Map<String, List<ITestResult>> buildTestClassGroups(Set<ITestResult> testResults) {
		Map<String, List<ITestResult>> map = Maps.newHashMap();
		for (ITestResult result : testResults) {
			String className = result.getTestClass().getName();
			List<ITestResult> list = map.get(className);
			if (list == null) {
				list = Lists.newArrayList();
				map.put(className, list);
			}
			list.add(result);
		}
		return map;
	}

	private void addTestResult(XMLStringBuffer xmlBuffer, ITestResult testResult) {
		Properties attribs = getTestResultAttributes(testResult);
		attribs.setProperty(XMLReporterConfig.ATTR_STATUS, getStatusString(testResult.getStatus()));
		// status, time, name
		xmlBuffer.addEmptyElement("testcase", attribs);
		// addTestMethodParams(xmlBuffer, testResult);
		// addTestResultException(xmlBuffer, testResult);
		// addTestResultOutput(xmlBuffer, testResult);
		// if (config.isGenerateTestResultAttributes()) {
		// addTestResultAttributes(xmlBuffer, testResult);
		// }
		// xmlBuffer.pop();
	}

	private String getStatusString(int testResultStatus) {
		switch (testResultStatus) {
		case ITestResult.SUCCESS:
			return "Passed";
		case ITestResult.FAILURE:
			return "Failed";
		case ITestResult.SKIP:
			return "Skipped";
		case ITestResult.SUCCESS_PERCENTAGE_FAILURE:
			return "SUCCESS_PERCENTAGE_FAILURE";
		default:
			throw new AssertionError("Unexpected value: " + testResultStatus);
		}
	}

	public void addTestMethodParams(XMLStringBuffer xmlBuffer, ITestResult testResult) {
		Object[] parameters = testResult.getParameters();
		if ((parameters != null) && (parameters.length > 0)) {
			xmlBuffer.push(XMLReporterConfig.TAG_PARAMS);
			for (int i = 0; i < parameters.length; i++) {
				addParameter(xmlBuffer, parameters[i], i);
			}
			xmlBuffer.pop();
		}
	}

	private void addParameter(XMLStringBuffer xmlBuffer, Object parameter, int i) {
		Properties attrs = new Properties();
		attrs.setProperty(XMLReporterConfig.ATTR_INDEX, String.valueOf(i));
		xmlBuffer.push(XMLReporterConfig.TAG_PARAM, attrs);
		if (parameter == null) {
			Properties valueAttrs = new Properties();
			valueAttrs.setProperty(XMLReporterConfig.ATTR_IS_NULL, "true");
			xmlBuffer.addEmptyElement(XMLReporterConfig.TAG_PARAM_VALUE, valueAttrs);
		} else {
			xmlBuffer.push(XMLReporterConfig.TAG_PARAM_VALUE);
			xmlBuffer.addCDATA(parameter.toString());
			xmlBuffer.pop();
		}
		xmlBuffer.pop();
	}

	private void addTestResultAttributes(XMLStringBuffer xmlBuffer, ITestResult testResult) {
		if (testResult.getAttributeNames() != null && testResult.getAttributeNames().size() > 0) {
			xmlBuffer.push(XMLReporterConfig.TAG_ATTRIBUTES);
			for (String attrName : testResult.getAttributeNames()) {
				if (attrName == null) {
					continue;
				}
				Object attrValue = testResult.getAttribute(attrName);

				Properties attributeAttrs = new Properties();
				attributeAttrs.setProperty(XMLReporterConfig.ATTR_NAME, attrName);
				if (attrValue == null) {
					attributeAttrs.setProperty(XMLReporterConfig.ATTR_IS_NULL, "true");
					xmlBuffer.addEmptyElement(XMLReporterConfig.TAG_ATTRIBUTE, attributeAttrs);
				} else {
					xmlBuffer.push(XMLReporterConfig.TAG_ATTRIBUTE, attributeAttrs);
					xmlBuffer.addCDATA(attrValue.toString());
					xmlBuffer.pop();
				}
			}
			xmlBuffer.pop();
		}
	}

	private Properties getTestResultAttributes(ITestResult testResult) {
		Properties attributes = new Properties();
		// if (!testResult.getMethod().isTest()) {
		// attributes.setProperty(XMLReporterConfig.ATTR_IS_CONFIG, "true");
		// }
		attributes.setProperty(XMLReporterConfig.ATTR_NAME, testResult.getMethod().getMethodName());
		String testInstanceName = testResult.getTestName();
		// if (null != testInstanceName) {
		// attributes.setProperty(XMLReporterConfig.ATTR_TEST_INSTANCE_NAME,
		// testInstanceName);
		// }
		// String description = testResult.getMethod().getDescription();
		// if (!Utils.isStringEmpty(description)) {
		// attributes.setProperty(XMLReporterConfig.ATTR_DESC, description);
		// }

		SimpleDateFormat format = new SimpleDateFormat(config.getTimestampFormat());
		String startTime = format.format(testResult.getStartMillis());
		String endTime = format.format(testResult.getEndMillis());
		// attributes.setProperty(XMLReporterConfig.ATTR_STARTED_AT, startTime);
		// attributes.setProperty(XMLReporterConfig.ATTR_FINISHED_AT, endTime);
		long duration = testResult.getEndMillis() - testResult.getStartMillis();
		String strDuration = Long.toString(duration / 1000);
		attributes.setProperty("time", strDuration);

		// if (config.isGenerateGroupsAttribute()) {
		// String groupNamesStr =
		// Utils.arrayToString(testResult.getMethod().getGroups());
		// if (!Utils.isStringEmpty(groupNamesStr)) {
		// attributes.setProperty(XMLReporterConfig.ATTR_GROUPS, groupNamesStr);
		// }
		// }
		//
		// if (config.isGenerateDependsOnMethods()) {
		// String dependsOnStr =
		// Utils.arrayToString(testResult.getMethod().getMethodsDependedUpon());
		// if (!Utils.isStringEmpty(dependsOnStr)) {
		// attributes.setProperty(XMLReporterConfig.ATTR_DEPENDS_ON_METHODS,
		// dependsOnStr);
		// }
		// }
		//
		// if (config.isGenerateDependsOnGroups()) {
		// String dependsOnStr =
		// Utils.arrayToString(testResult.getMethod().getGroupsDependedUpon());
		// if (!Utils.isStringEmpty(dependsOnStr)) {
		// attributes.setProperty(XMLReporterConfig.ATTR_DEPENDS_ON_GROUPS,
		// dependsOnStr);
		// }
		// }
		//
		// ConstructorOrMethod cm =
		// testResult.getMethod().getConstructorOrMethod();
		// Test testAnnotation;
		// if (cm.getMethod() != null) {
		// testAnnotation = cm.getMethod().getAnnotation(Test.class);
		// if (testAnnotation != null) {
		// String dataProvider = testAnnotation.dataProvider();
		// if (!Strings.isNullOrEmpty(dataProvider)) {
		// attributes.setProperty(XMLReporterConfig.ATTR_DATA_PROVIDER,
		// dataProvider);
		// }
		// }
		// }

		return attributes;
	}

	private Properties getSuiteResultAttributes(ISuiteResult suiteResult) {
		Properties attributes = new Properties();
		ITestContext tc = suiteResult.getTestContext();
		attributes.setProperty(XMLReporterConfig.ATTR_NAME, tc.getName());
		// XMLReporter.addDurationAttributes(config, attributes,
		// tc.getStartDate(), tc.getEndDate());
		return attributes;
	}

	private void referenceSuiteResult(XMLStringBuffer xmlBuffer, ISuiteResult suiteResult) {
		Properties attrs = new Properties();

		String suiteResultName = suiteResult.getTestContext().getName();
		attrs.setProperty(XMLReporterConfig.ATTR_NAME, suiteResultName);
		String status = "";
		// if (suiteResult.getTestContext().getFailedTests().size() == 0)
		// status = "Passed";
		// else
		// status = "Failed";
		// attrs.setProperty("status", status);
		// long duration = suiteResult.getTestContext().getEndDate().getTime()
		// - suiteResult.getTestContext().getStartDate().getTime();
		// attrs.setProperty("time", Long.toString(duration));
		// attrs.setProperty("passed",
		// Integer.toString(suiteResult.getTestContext().getPassedTests().size()));
		// attrs.setProperty("failed",
		// Integer.toString(suiteResult.getTestContext().getFailedTests().size()));
		// attrs.setProperty("skipped",
		// Integer.toString(suiteResult.getTestContext().getSkippedTests().size()));
		// attrs.setProperty("ignored",
		// Integer.toString(suiteResult.getTestContext().getSkippedTests().size()));
		// attrs.setProperty("total",
		// Integer.toString(suiteResult.getTestContext().getPassedTests().size()
		// + suiteResult.getTestContext().getFailedTests().size()
		// + suiteResult.getTestContext().getSkippedTests().size()));

		// xmlBuffer.addEmptyElement("testcase", attrs);

		// xmlBuffer.push("testsuite", getSuiteResultAttributes(suiteResult));

		ArrayList<ITestNGMethod> testcase = new ArrayList<ITestNGMethod>(
				Arrays.asList(suiteResult.getTestContext().getAllTestMethods()));
		//
		// for (ITestNGMethod method : testcase) {
		// //
		//
		// writeMethodToBuffer(xmlBuffer, method, suiteResult.getTestContext());
		//
		// }
		//
		// for (ITestResult testResult : sortedResults) {
		// addTestResult(xmlBuffer, testResult);
		// }

		// xmlBuffer.pop();
	}

	// private void writeMethodToBuffer(XMLStringBuffer xmlBuffer, ITestNGMethod
	// methodResult, ITestContext test) {
	//
	// Properties attrs = new Properties();
	// String methName = methodResult.getMethodName();
	// attrs.setProperty("name", methodResult.getMethodName());
	//
	// String strDuration = Long.toString(duration);
	//
	// IResultMap results = test.getFailedTests();
	// Set<ITestResult> newset = new HashSet<ITestResult>();
	// if (results.size() > 0) {
	//
	// newset = results.getResults(methodResult);
	// if (newset.size() == 0)
	// attrs.setProperty("Status", "Passed");
	// else {
	// for (ITestResult t : newset) {
	// if (t.getName().contains(methName))
	// attrs.setProperty("Status", "Failed");
	//
	// }
	// }
	// } else {
	// attrs.setProperty("Status", "Passed");
	// }
	// SimpleDateFormat format = new
	// SimpleDateFormat(config.getTimestampFormat());
	// String startTime = format.format(newset.getStartMillis());
	// String endTime = format.format(newset.getEndMillis());
	//
	// attrs.setProperty(XMLReporterConfig.ATTR_STARTED_AT, startTime);
	// attrs.setProperty(XMLReporterConfig.ATTR_FINISHED_AT, endTime);
	// long duration = newset.getEndMillis() - newset.getStartMillis();
	//
	// xmlBuffer.addEmptyElement("testcase", attrs);
	// // xmlBuffer.pop();
	// }

	private File referenceSuite(XMLStringBuffer xmlBuffer, ISuite suite) {
		String relativePath = suite.getName() + File.separatorChar + FILE_NAME;
		File suiteFile = new File(config.getOutputDirectory(), relativePath);
		Properties attrs = new Properties();
		attrs.setProperty(XMLReporterConfig.ATTR_URL, relativePath);
		xmlBuffer.addEmptyElement(XMLReporterConfig.TAG_SUITE, attrs);
		return suiteFile;
	}

	private Set<ITestNGMethod> getUniqueMethodSet(Collection<ITestNGMethod> methods) {
		Set<ITestNGMethod> result = new LinkedHashSet<>();
		for (ITestNGMethod method : methods) {
			result.add(method);
		}
		return result;
	}

	private Properties getSuiteAttributes(ISuite suite) {
		Properties props = new Properties();
		props.setProperty(XMLReporterConfig.ATTR_NAME, suite.getName());

		// // Calculate the duration
		// Map<String, ISuiteResult> results = suite.getResults();
		// Date minStartDate = new Date();
		// Date maxEndDate = null;
		// // TODO: We could probably optimize this in order not to traverse
		// this twice
		// synchronized(results) {
		// for (Map.Entry<String, ISuiteResult> result : results.entrySet()) {
		// ITestContext testContext = result.getValue().getTestContext();
		// Date startDate = testContext.getStartDate();
		// Date endDate = testContext.getEndDate();
		// if (minStartDate.after(startDate)) {
		// minStartDate = startDate;
		// }
		// if (maxEndDate == null || maxEndDate.before(endDate)) {
		// maxEndDate = endDate != null ? endDate : startDate;
		// }
		// }
		// }
		// // The suite could be completely empty
		// if (maxEndDate == null) {
		// maxEndDate = minStartDate;
		// }
		// addDurationAttributes(config, props, minStartDate, maxEndDate);
		return props;
	}

	/**
	 * Add started-at, finished-at and duration-ms attributes to the <suite> tag
	 */
	public static void addDurationAttributes(XMLReporterConfig config, Properties attributes, Date minStartDate,
			Date maxEndDate) {
		SimpleDateFormat format = new SimpleDateFormat(config.getTimestampFormat());
		TimeZone utc = TimeZone.getTimeZone("UTC");
		format.setTimeZone(utc);
		String startTime = format.format(minStartDate);
		String endTime = format.format(maxEndDate);
		long duration = maxEndDate.getTime() - minStartDate.getTime();

		// attributes.setProperty(XMLReporterConfig.ATTR_STARTED_AT, startTime);
		// attributes.setProperty(XMLReporterConfig.ATTR_FINISHED_AT, endTime);
		attributes.setProperty(XMLReporterConfig.ATTR_DURATION_MS, Long.toString(duration));
	}

	// TODO: This is not the smartest way to implement the config
	public int getFileFragmentationLevel() {
		return config.getFileFragmentationLevel();
	}

	public void setFileFragmentationLevel(int fileFragmentationLevel) {
		config.setFileFragmentationLevel(fileFragmentationLevel);
	}

	public int getStackTraceOutputMethod() {
		return config.getStackTraceOutputMethod();
	}

	public void setStackTraceOutputMethod(int stackTraceOutputMethod) {
		config.setStackTraceOutputMethod(stackTraceOutputMethod);
	}

	public String getOutputDirectory() {
		return config.getOutputDirectory();
	}

	public void setOutputDirectory(String outputDirectory) {
		config.setOutputDirectory(outputDirectory);
	}

	public boolean isGenerateGroupsAttribute() {
		return config.isGenerateGroupsAttribute();
	}

	public void setGenerateGroupsAttribute(boolean generateGroupsAttribute) {
		config.setGenerateGroupsAttribute(generateGroupsAttribute);
	}

	public boolean isSplitClassAndPackageNames() {
		return config.isSplitClassAndPackageNames();
	}

	public void setSplitClassAndPackageNames(boolean splitClassAndPackageNames) {
		config.setSplitClassAndPackageNames(splitClassAndPackageNames);
	}

	public String getTimestampFormat() {
		return config.getTimestampFormat();
	}

	public void setTimestampFormat(String timestampFormat) {
		config.setTimestampFormat(timestampFormat);
	}

	public boolean isGenerateDependsOnMethods() {
		return config.isGenerateDependsOnMethods();
	}

	public void setGenerateDependsOnMethods(boolean generateDependsOnMethods) {
		config.setGenerateDependsOnMethods(generateDependsOnMethods);
	}

	public void setGenerateDependsOnGroups(boolean generateDependsOnGroups) {
		config.setGenerateDependsOnGroups(generateDependsOnGroups);
	}

	public boolean isGenerateDependsOnGroups() {
		return config.isGenerateDependsOnGroups();
	}

	public void setGenerateTestResultAttributes(boolean generateTestResultAttributes) {
		config.setGenerateTestResultAttributes(generateTestResultAttributes);
	}

	public boolean isGenerateTestResultAttributes() {
		return config.isGenerateTestResultAttributes();
	}
	//// suiteRunners
	// public static void main (String args[]){
	// mTempDirectory = new File(slashTmpDir, "testng-tmp-" +
	//// System.currentTimeMillis() % 1000);
	// mTempDirectory.mkdirs();
	//
	// List<String> suiteFiles = new ArrayList<>(withSuiteFiles.length);
	// for (String suiteFile : withSuiteFiles) {
	// suiteFiles.add(new File(PARENT, suiteFile).getAbsolutePath());
	// }
	//
	// ReportGenerator reportGenerator = new ReportGenerator();
	// reportGenerator.generateReport(xmlSuites, suiteRunners,
	//// "D:\\myNewCloudProject\\test-report");
	// for (int i=0; i < suites.size(); i++) {
	// writeSuite(suites.get(i).getXmlSuite(),suites.get(i));
	// }
	//// TestNG tng = new TestNG();
	// * List<String> suites = Lists.newArrayList();
	// * suites.add("c:/tests/testng1.xml");
	// * suites.add("c:/tests/testng2.xml");
	// * tng.setTestSuites(suites);
}
