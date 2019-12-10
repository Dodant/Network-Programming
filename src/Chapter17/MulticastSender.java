package Chapter17;

import java.io.*;
import java.net.*;
import java.util.Date;

public class MulticastSender {

	public static void main(String[] args) {

		InetAddress ia = null;
		int port = 0;
		byte ttl = (byte) 1;
		// command line에서 주소 읽어 들임
		try {
			ia = InetAddress.getByName("237.100.100.1");
			port = 1900;
			if (args.length > 2)
				ttl = (byte) Integer.parseInt("1");
		} catch (NumberFormatException | IndexOutOfBoundsException | UnknownHostException ex) {
			System.err.println(ex);
			System.err.println("Usage: java MulticastSender multicast_address port ttl");
			System.exit(1);
		}

		try (MulticastSocket ms = new MulticastSocket()) {
			ms.setTimeToLive(ttl);
			ms.joinGroup(ia);
			for (int i = 1; i < 10; i++) {
				byte[] data = (i + " " + new Date() + " 멀티캐스트 데이터\r\n").getBytes("UTF-8");
				DatagramPacket dp = new DatagramPacket(data, data.length, ia, port);
				ms.send(dp);
			}
			ms.leaveGroup(ia);
		} catch (SocketException ex) {
			System.err.println(ex);
			ex.printStackTrace();
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}