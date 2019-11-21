package Chapter15;

import java.net.*;
import java.io.*;

public class Chap_Client {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("168.131.180.209", 7112);
			socket.setSoTimeout(15000);
			InputStream in = socket.getInputStream();
			DataInputStream reader = new DataInputStream(in);
			String s = reader.readUTF();
			System.out.println(s);
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		

		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
