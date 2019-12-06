package Chapter16;

import java.net.*;
import java.io.*;
import java.util.*;

public class UDPDaytimeServer extends UDPServer {

	public final static int DEFAULT_PORT = 13;

	public UDPDaytimeServer() throws SocketException {
		super(DEFAULT_PORT);
	}

	public void respond(DatagramSocket ds, DatagramPacket packet) {
		try {
			Date now = new Date();
			String response = now.toString() + "\r\n";
			byte[] data = response.getBytes("ASCII");
			DatagramPacket outgoing = new DatagramPacket(data, data.length, packet.getAddress(), packet.getPort());
			ds.send(outgoing);
		} catch (IOException e) {
			System.err.println(e);
		}

	}

	public static void main(String[] args) {
		try {
			UDPDaytimeServer server = new UDPDaytimeServer();
			new Thread(server).start();
		} catch (SocketException e) {
			System.err.println(e);
		}
	}
}