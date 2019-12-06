package Chapter16;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

public class UDPTimeServer extends UDPServer {

	public final static int PORT = 37;
	
	public UDPTimeServer() {
		super(PORT);
	}
	
	public UDPTimeServer(int port) {
		super(port);
	}

	public static void main(String[] args) {
		UDPServer server = new UDPTimeServer();
		Thread t = new Thread(server);
		t.start();
	}

	@Override
	public void respond(DatagramSocket socket, DatagramPacket request) throws IOException {
		Date time = new Date();
		String str = time.toString();
		DatagramPacket outgoing = new DatagramPacket(
				str.getBytes(), str.length(), request.getAddress(), request.getPort());
		System.out.println("Incoming Request From " + request.getAddress() + " " + request.getPort());
		socket.send(outgoing);
	}
}
