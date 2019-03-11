import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.ITestContext;

public class EmailableReporter {

	private static PrintWriter m_out;

	public static void createReport(ITestContext context, String reportName) {
		try {
			m_out = createWriter(context.getOutputDirectory(), reportName);
			writeSummary(m_out, reportName);
			m_out.flush();
			m_out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected static PrintWriter createWriter(String outdir, String reportName) throws IOException {
		new File(outdir + File.separator + reportName).mkdirs();
		return new PrintWriter(new BufferedWriter(
				new FileWriter(new File(outdir + File.separator + reportName, "emailable-report.html"))));
	}

	public static void writeSummary(PrintWriter out, String testName) {
		m_out.print("<b><h2><u>TEST SUMMARY <u></h2></b>");
		m_out.print("<table border='1'>");
		m_out.print("<tr bgcolor='white'><th> STATUS</th><th> COUNT</th>");
		m_out.print("<tr bgcolor='green'><td>" + "PASSED" + "</td><td>" + TestReportGenerator.getPassedList().size()
				+ "</td>");
		m_out.print("<tr bgcolor='red'><td>" + "FAILED" + "</td><td>" + TestReportGenerator.getFailedList().size()
				+ "</td>");
		m_out.print("<tr bgcolor='yellow'><td>" + "SKIPPED" + "</td><td>" + TestReportGenerator.getSkippedList().size()
				+ "</td>");
		m_out.print("</table>");

		List<String> passed = new ArrayList<String>(TestReportGenerator.getPassedList());
		m_out.print("<br>");
		m_out.print("<table border='1'>");
		m_out.print("<tr bgcolor='green'><th> PASSED TESTS</th>");
		for (String s : passed)
			m_out.print("<tr bgcolor='white'><td>" + s + "</td>");
		m_out.print("</table>");
		m_out.print("<br>");
		m_out.print("<table border='1'>");
		m_out.print("<tr bgcolor='red'><th> FAIELD TESTS</th>");
		List<String> failed = new ArrayList<String>(TestReportGenerator.getFailedList());
		for (String s : failed)
			m_out.print("<tr bgcolor='white'><td>" + s + "</td>");
		m_out.print("</table>");
		m_out.print("<br>");
		m_out.print("<table border='1'>");
		m_out.print("<tr bgcolor='yellow'><th> SKIPPED TESTS</th>");
		List<String> skipped = new ArrayList<String>(TestReportGenerator.getSkippedList());
		for (String s : skipped)
			m_out.print("<tr bgcolor='white'><td>" + s + "</td>");
		m_out.print("</table>");
	}

	public static void emailGenerator(String file, String testName) {
		String to = "rama.rajeswari.ramachandran@oracle.com,sridhar.gundappa@oracle.com,kaushik.s.sarkar@oracle.com ";

		// Sender's email ID needs to be mentioned
		String from = "rama.rajeswari.ramachandran@oracle.com";

		// // Assuming you are sending email through relay.jangosmtp.net
		// String host = "relay.jangosmtp.net";

		Properties props = new Properties();
		props.put("mail.smtp.host", "internal-mail-router.oracle.com");
		props.put("mail.smtp.port", "25");
		// Get the Session object.
		Session session = Session.getInstance(props);

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);
			// Set From: header field of the header.

			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("Test Completion mail for " + testName);

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();
			// Now set the actual message
			StringBuffer buff = new StringBuffer();
			buff.append(
					"<br><b><h2><u>TEST SUMMARY <u></h2></b><table border='1'><tr bgcolor='white'><th> STATUS</th><th> COUNT</th><tr bgcolor='green'><td>"
							+ "PASSED" + "</td><td>" + TestReportGenerator.getPassedList().size()
							+ "</td><tr bgcolor='red'><td>" + "FAILED" + "</td><td>"
							+ TestReportGenerator.getFailedList().size() + "</td><tr bgcolor='yellow'><td>" + "SKIPPED"
							+ "</td><td>" + TestReportGenerator.getSkippedList().size() + "</td></table>");
			messageBodyPart.setContent("Test Completion mail, PFA the test report for " + testName + buff, "text/html");

			// Create a multipart message
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			String filename = file;
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart, "text/html");

			// Send message
			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void sendReport(ITestContext context, String testName) {
		String name = context.getOutputDirectory() + File.separator + testName;
		createReport(context, testName);
		emailGenerator(name + File.separator + "emailable-report.html", testName);
	}

	// public static void main(String[] args) {
	// emailGenerator("D:\\testFile.txt", "EMAIL TEST");
	// }
}
