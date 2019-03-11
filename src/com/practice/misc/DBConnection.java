package com.practice.misc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class DBConnection {
	// to do:
	// SSH session
	// winrm session
	// getting runtime for windows / oel
	// database connections
	// file parsings
	// java runtime - execute commands from Java

	public static void main(String[] args) {
		// create driver instance from driver manager factory -- assuming jdbc
		// thin driver
		// frame the url and initiate a connection
		// make a query statement
		// execute a statment and get result
		//
		// Class.forName("com.jdbc.driver.");
		// Connection conn = DriverManager.getConnection("dbusrl, username,
		// password");
		// Statement stmnt = conn.createStatement();
		// ResultSet result = stmnt.executeQuery("sampe swl query");
		// ssh to a server
		//
		JSch jsch = new JSch();
		Session sess;
		try {
			Properties prop = new Properties();
			prop.put("StrictHostKeyChecking", "no");
			sess = jsch.getSession("ramaram", "slc05emb.us.oracle.com");
			sess.setPassword("@");
			sess.setConfig(prop);
			sess.connect(30000);

			Channel channel = sess.openChannel("exec");
			channel.setInputStream(System.in);
			channel.setOutputStream(System.out);
			((ChannelExec) channel).setCommand("pwd;whoami;ls -rlat");

			InputStream in = channel.getInputStream();
			channel.connect();
			byte[] tmp = new byte[1024];
			boolean flag = true;
			while (true) {
				while (in.available() > 0) {
					int i = in.read(tmp, 0, 1024);
					if (i < 0)
						break;
					System.out.print(new String(tmp, 0, i));
				}
				if (channel.isClosed()) {
					System.out.println("exit-status: " + channel.getExitStatus());
					channel.disconnect();
					break;
				}
			}

			sess.disconnect();
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
