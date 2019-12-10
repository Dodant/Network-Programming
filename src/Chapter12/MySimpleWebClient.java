package Chapter12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Date;

public class MySimpleWebClient {
	public static void main(String[] args) {
		Writer out = null;
		BufferedReader br = null;
		Socket sock = null;
		try {
			sock = new Socket("www.jnu.ac.kr", 80);
			out = new OutputStreamWriter(sock.getOutputStream(), "UTF-8");
			br = new BufferedReader(new InputStreamReader(sock.getInputStream(), "UTF-8"));

			out.write("GET / HTTP/1.1\r\n\r\n");
			out.flush();

			int count = 0;
			int ch = br.read();
			while (ch != -1 && count < 1000) {
				System.out.print((char) ch);
				count++;
				ch = br.read();
			}

		} catch (Exception e) {
			System.out.println(new Date() + " " + e);
		} finally {
			try {
				out.close();
				br.close();
				sock.close();
			} catch (Exception ex) {
			}
		}
	} // end main
}// end class
