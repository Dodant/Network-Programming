package Chapter15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;

public class EchoServerByHand {

	public static void main(String[] args) {
		try(ServerSocket ss = new ServerSocket(11112)){
			System.out.println("접속을 기다립니다.");
			Socket conn = ss.accept();
			System.out.println(conn.getInetAddress() + " " + conn.getPort() + " 로 부터 접속 요청");
			
			BufferedReader netInput = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line = netInput.readLine();
			System.out.println("클라이언트로 부터 전송 받은 문자열 : " + line);
			
			PrintWriter netOutput = new PrintWriter(
					new OutputStreamWriter(conn.getOutputStream()));
			netOutput.println(line);
			netOutput.flush();
			
			netInput.close();
			netOutput.close();
			conn.close();
			ss.close();
			
		} catch (Exception e){
			System.out.println(e);
		}

	}

}
