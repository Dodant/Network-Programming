package Chapter14;

import java.io.*;
import java.net.*;

public class DictClient {

	public static final String SERVER = "dict.org";
	public static final int PORT = 2628;
	public static final int TIMEOUT = 15000;

	public static void main(String[] args) {

		try (Socket socket = new Socket(SERVER, PORT)){
			socket.setSoTimeout(TIMEOUT);
			
			System.out.println(socket.getInetAddress());
			System.out.println(socket.getPort());
			System.out.println(socket.getLocalAddress());
			System.out.println(socket.getLocalPort());
			
			
			BufferedWriter writer = new BufferedWriter(
									new OutputStreamWriter(
									socket.getOutputStream(), "UTF-8"));
			BufferedReader reader = new BufferedReader(
									new InputStreamReader(
									socket.getInputStream(), "UTF-8"));

			for (String word : args) define(word, writer, reader);

			writer.write("quit\r\n");
			writer.flush();
			
		} catch (IOException ex) {
			System.err.println(ex);
		} 
	}

	static void define(String word, Writer writer, BufferedReader reader) throws IOException, UnsupportedEncodingException {
		
		writer.write("DEFINE fd-eng-lat " + word + "\r\n");
		writer.flush();

		for (String line = reader.readLine(); line != null; line = reader.readLine()) {
			if (line.startsWith("250 ")) { // OK
				return;
			} else if (line.startsWith("552 ")) { // no match
				System.out.println("No definition found for " + word);
				return;
			} else if (line.matches("\\d\\d\\d .*"))
				continue;
			else if (line.trim().equals("."))
				continue;
			else
				System.out.println(line);
		}
	}
}
