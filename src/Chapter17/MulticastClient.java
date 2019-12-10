package Chapter17;

import java.io.*;
import java.net.*;

public class MulticastClient {
	MulticastSocket receiver = null;
	DatagramPacket packet = null;
	InetAddress multicastGroup = null;
	int port = 20002;
	String address = "237.100.100.1";
	byte[] b = new byte[100];

	public MulticastClient() {
		try {
			receiver = new MulticastSocket(port);
			multicastGroup = InetAddress.getByName(address);
			packet = new DatagramPacket(b, b.length);
			receiver.joinGroup(multicastGroup);
			for (int i = 0; i < 3; i++) {
				receiver.receive(packet);
				String notice = new String(packet.getData());
				System.out.println(notice);
			}
			receiver.leaveGroup(multicastGroup);
			receiver.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		new MulticastClient();
	}
}
