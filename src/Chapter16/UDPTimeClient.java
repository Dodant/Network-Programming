package Chapter16;

import java.io.IOException;
import java.net.*;
import java.util.*;

public class UDPTimeClient {

	public final static int PORT = 37;
	public final static String DEFAULT_HOST = "time.nist.gov";

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

		UDPPoke poker = new UDPPoke(host, PORT);
		byte[] response = poker.poke();
		if (response == null) {
			System.out.println("No response within allotted time");
			return;
		} else if (response.length != 4) {
			System.out.println("Unrecognized response format");
			return;
		}

		// Time 프로토콜은 1900년 기준
		// Java의 Date 클래스는 1970년 기준
		// 다음 값은 이들 사이의 시간 차
		long differenceBetweenEpochs = 2208988800L;

		long secondsSince1900 = 0;
		for (int i = 0; i < 4; i++) {
			secondsSince1900 = (secondsSince1900 << 8) | (response[i] & 0x000000FF);
		}

		long secondsSince1970 = secondsSince1900 - differenceBetweenEpochs;
		long msSince1970 = secondsSince1970 * 1000;
		Date time = new Date(msSince1970);

		System.out.println(time);
	}
}
