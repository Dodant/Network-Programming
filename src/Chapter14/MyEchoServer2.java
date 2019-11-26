package Chapter14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyEchoServer2 {

	public static int DEFAULT_PORT = 7;

	public static void main(String[] args) {
		try (ServerSocket ss = new ServerSocket(DEFAULT_PORT)) {
			while (true) {
				try {
					Socket sock = ss.accept();
					System.out.println("접속을 기다립니다.");
					System.out.println(sock.getInetAddress() + " " + sock.getPort() + "로부터의 접속요청 ");

					PrintWriter pw = new PrintWriter(sock.getOutputStream());
					BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
					System.out.println("문자 읽기 ");

					String str = null;
					while ((str = br.readLine()) != null) {
						System.out.println(str);
						pw.println(str);
						pw.flush();
					}
					pw.close();
					br.close();
					sock.close();
				} catch (Exception e) {
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
