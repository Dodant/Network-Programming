package Chapter14;

import java.net.*;
import java.io.*;

public class EchoClient {
	public static void main(String[] args) {
		String hostname = "localhost";
		PrintWriter networkOut = null;
		BufferedReader networkIn = null;
		try {
			Socket server = new Socket(hostname, 7);
			
			networkIn = new BufferedReader(
						new InputStreamReader(
						server.getInputStream()));
			
			BufferedReader userIn = new BufferedReader(
									new InputStreamReader(
									System.in));
			
			networkOut = new PrintWriter(
						server.getOutputStream());
			
			System.out.println("Connected to echo server " + server.getInetAddress() + "의 Port " + server.getPort() + "에 서비스 요청");

			while (true) {
				System.out.println("서버로 보낼 문장을 입력하시오(.은 종료)");
				String theLine = userIn.readLine();
				if (theLine.equals("."))
					break;
				networkOut.println(theLine);
				networkOut.flush();
				System.out.println(networkIn.readLine());
			}
			userIn.close();
			server.close();
		}
		catch (IOException e) {
			System.err.println(e);
		} finally {
			try {
				System.out.println("클라이언트가 입출력 스트림을 닫습니다.");
				if (networkIn != null) networkIn.close();
				if (networkOut != null) networkOut.close();
			} catch (IOException e) {
			}
		}
	} // end main
} // end EchoClient
