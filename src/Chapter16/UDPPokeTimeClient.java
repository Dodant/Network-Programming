package Chapter16;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UDPPokeTimeClient {

	public final static int PORT = 37;
	public final static String DEFAULT_HOST = "localhost";
	
	public static void main(String[] args) throws IOException {

		InetAddress host;
		try {
			if (args.length > 0) {
				host = InetAddress.getByName(args[0]);
			} else {
				host = InetAddress.getByName(DEFAULT_HOST);
			}
		} catch (RuntimeException | UnknownHostException ex) {
			System.out.println("Usage: java UDPTimeClient [host]");
			return;
		}
		
		byte[] buffer = new byte[1024]; 
		UDPPoke poker = new UDPPoke(host, PORT, buffer.length, 3000);
		buffer = poker.poke();
		if (buffer == null) {
			System.out.println("No response within allotted time");
			return;
		} else {
			System.out.println(new String(buffer));
			return;
		}
	}
}
