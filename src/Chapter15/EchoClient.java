package Chapter15;

import java.net.*;
import java.io.*;

public class EchoClient {
	public static void main(String[] args) {

		PrintWriter networkOut = null;
		BufferedReader networkIn = null;
		try {
			Socket theSocket = new Socket("localhost", 7);
			networkIn = new BufferedReader(new InputStreamReader(theSocket.getInputStream()));
			networkOut = new PrintWriter(theSocket.getOutputStream());
			BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Connected to echo server");

			while (true) {
				String theLine = userIn.readLine();
				if (theLine.equals("."))
					break;
				networkOut.println(theLine);
				networkOut.flush();
				System.out.println(networkIn.readLine());
			}
		} // end try
		catch (IOException ex) {
			System.err.println(ex);
		} finally {
			try {
				if (networkIn != null)
					networkIn.close();
				if (networkOut != null)
					networkOut.close();
			} catch (IOException ex) {
			}
		}
	} // end main
} // end EchoClient
