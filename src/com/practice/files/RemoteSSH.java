package com.practice.files;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class RemoteSSH {
	static final String host = "host.com";
	static final int port = 22;
	static final String username = "username";
	static final String passwd = "";

	static void connct() {
		JSch jsh = new JSch();
		try {
			Session session = jsh.getSession(username, host, port);
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.setPassword(passwd);

			// now connect with a timeout
			session.connect(30000);
			// open a shell prompt and set i/ and o/p stream
			Channel channel = session.openChannel("shell");
			channel.setInputStream(System.in);
			channel.setOutputStream(System.out);
			// connect the channel;
			channel.connect(3 * 1000);
			// send and execute commands
			String command = "pwd;echo SUCCESS";

			PrintStream out = new PrintStream(channel.getOutputStream());
			out.println(command);
			out.println("exit");

			out.flush();
			String commandOutput = readChannelOutput(channel);
			System.out.println("Finished sending commands!");
			// final step
			channel.disconnect();
			session.disconnect();
			return;

		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String readChannelOutput(Channel channel) {
		String line = "";
		byte[] buffer = new byte[1024];

		try {
			InputStream in = channel.getInputStream();
			// String line = "";
			while (true) {
				while (in.available() > 0) {
					int i = in.read(buffer, 0, 1024);
					if (i < 0) {
						break;
					}
					line = new String(buffer, 0, i);
					System.out.println(line);
				}

				if (line.contains("logout")) {
					break;
				}

				if (channel.isClosed()) {
					break;
				}
				try {
					Thread.sleep(1000);
				} catch (Exception ee) {
				}
			}
		} catch (Exception e) {
			System.out.println("Error while reading channel output: " + e);
		}
		return line;
	}

	public static void main(String[] args) {
		RemoteSSH.connct();
	}
}