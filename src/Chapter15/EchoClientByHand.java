package Chapter15;

import java.io.*;
import java.net.Socket;

public class EchoClientByHand {

	public static void main(String[] args) {
		
		try(Socket sock = new Socket("localhost", 11112)){
			sock.setSoTimeout(3000);
			System.out.println("Connected to echo server " + sock.getInetAddress() + "의 Port " + sock.getPort() + "에 서비스 요청");
			
			BufferedReader userInput = new BufferedReader(
									new InputStreamReader(System.in));
			BufferedReader netInput = new BufferedReader(
									new InputStreamReader(sock.getInputStream()));
			PrintWriter netOutput = new PrintWriter(sock.getOutputStream());
			
			String line = userInput.readLine();
			netOutput.println(line);
			netOutput.flush();
			System.out.println(netInput.readLine());
			
			netOutput.close();
			netInput.close();
			userInput.close();
			System.out.println("끝 ");
		} catch (Exception e){
			System.out.println(e);
		}
	}
}
