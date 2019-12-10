package Chapter17;

import java.io.*;
import java.net.*;

public class MulticastServer extends Thread {
	DatagramSocket socket = null;
	DatagramPacket packet = null;
	InetAddress multicastGroup = null;
	int port = 20002;
	String address = "237.100.100.1";
	boolean onAir = true;

	public MulticastServer() throws IOException {
		super("멀티캐스트 방송국");
		socket = new DatagramSocket();
	}

	public void run() {
		byte[] b = new byte[100];
		while (onAir) {
			try {
				b = "이 자료는 멀티캐스트 방송국에서 보내고 있습니다".getBytes(); // 메시지를 바이트 배열로 변환
				multicastGroup = InetAddress.getByName(address);
				packet = new DatagramPacket(b, b.length, multicastGroup, port);
				socket.send(packet);
				try {
					sleep(500);
					System.out.println("방송 중입니다.");
				} catch (InterruptedException e) {
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // end while
		socket.close();
	}

	public static void main(String[] args) throws java.io.IOException {
		new MulticastServer().start();
	}
}
