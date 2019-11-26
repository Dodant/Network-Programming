package Chapter14;

import java.net.*;
import java.io.*;

public class DaytimeClient {

	public static void main(String[] args) {
		try {
			InetAddress addr = InetAddress.getByName("localhost");
			Socket socket = new Socket(addr, 13);
			socket.setSoTimeout(15000);
			InputStream in = socket.getInputStream();
			InputStreamReader reader = new InputStreamReader(in, "ASCII");
			StringBuilder time = new StringBuilder();
			for (int c = reader.read(); c != -1; c = reader.read()) {
				time.append((char) c);
			}
			time.append("Sender : OJK");
			System.out.println(time);
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
