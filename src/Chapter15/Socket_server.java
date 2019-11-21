package Chapter15;

import java.io.IOException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Socket_server {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(1234);
		while (true) {
			try (Socket connection = server.accept()) {
				Writer out = new OutputStreamWriter(connection.getOutputStream());
				Date now = new Date();
				out.write(now.toString() + "qwerty \r\n");
				out.flush();
			} catch (IOException ex) {
				// 한 클라이언트와의 연결에서 생긴 문제
				// 서버를 셧다운할 필요는 없음
				System.err.println(ex.getMessage());
			}
		}
	}
}
