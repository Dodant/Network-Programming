package Chapter17;

import java.io.*;
import java.net.*;

public class MulticastSniffer {

	public static void main(String[] args) {
		System.setProperty("java.net.preferIPv4Stack", "true");
		InetAddress group = null;
		int port = 0;

		// read the address from the command line
		try {
			group = InetAddress.getByName("237.100.100.1");
			port = 1900;
		} catch (ArrayIndexOutOfBoundsException | NumberFormatException | UnknownHostException ex) {
			System.err.println("Usage: java MulticastSniffer multicast_address port");
			System.exit(1);
		}

		MulticastSocket ms = null;
		try {
			ms = new MulticastSocket(port);
			ms.joinGroup(group);

			while (true) {
				byte[] buffer = new byte[8192];
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
				ms.receive(dp);
				String s = new String(dp.getData(), "UTF-8");
				System.out.println(s);
			}
		} catch (IOException ex) {
			System.err.println(ex);
		} finally {
			if (ms != null) {
				try {
					ms.leaveGroup(group);
					ms.close();
				} catch (IOException ex) {
				}
			}
		}
	}
}