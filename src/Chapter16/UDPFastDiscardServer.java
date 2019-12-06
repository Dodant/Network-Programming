package Chapter16;

import java.net.*;

public class UDPFastDiscardServer extends UDPServer {

	public final static int DEFAULT_PORT = 9;

	public UDPFastDiscardServer() {
		super(DEFAULT_PORT);
	}

	public static void main(String[] args) {
		UDPServer server = new UDPFastDiscardServer();
		Thread t = new Thread(server);
		t.start();
	}

	public void respond(DatagramSocket socket, DatagramPacket request) {}
}
