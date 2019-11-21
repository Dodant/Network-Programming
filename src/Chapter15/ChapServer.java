package Chapter15;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ChapServer {

	public final static int PORT = 7009;

	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(PORT)) {
			while (true) {
				try (Socket connection = server.accept()) {
					OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
					out.write("친구 왈 : 너 내일 학교 몇시에 올래? \r\n");
					out.flush();
					System.out.println("I said : 너 내일 학교 몇시에 올래?");
					
					
					
					connection.close();
					System.out.println("asdasd");
				} catch (IOException ex) {
				}
			}
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
