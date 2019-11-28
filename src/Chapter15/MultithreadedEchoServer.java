package Chapter15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultithreadedEchoServer {

	public static int DEFAULT_PORT = 7;

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(DEFAULT_PORT)) {
			while (true) {
				try {
					Socket connection = server.accept();
					System.out.println("접속을 기다립니다.");
					new MyEchoThread(connection).start();
				} catch (Exception e) {
				}
			}
		} catch (IOException e) {
			System.out.println("Couldn't start server");
			e.printStackTrace();
		}
	}

	private static class MyEchoThread extends Thread {

		private Socket connection;

		public MyEchoThread(Socket conn) {
			this.connection = conn;
		}

		public void run() {
			try {
				System.out.println(connection.getInetAddress() + " " + connection.getPort() + "로부터의 접속요청 ");

				PrintWriter pw = new PrintWriter(connection.getOutputStream());
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String str = null;
				while ((str = br.readLine()) != null) {
					System.out.println(str);
					pw.println(str);
					pw.flush();
				}
				pw.close();
				br.close();
				connection.close();
			} catch (Exception e) {
			}
		}
	}
}