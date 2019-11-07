package Chapter11;

import java.io.*;
import java.net.*;

public class FileAndURL {

	public static void main(String[] args) {

		InputStream in = null;
		String url = "file:///Users/Dodanto/Eclipse-WS/Network Programming/file01.txt";
		File f = new File("/Users/Dodanto/Eclipse-WS/Network Programming/file01.txt");
		try {
			URL u = new URL(url);
			in = u.openStream();
			in = new BufferedInputStream(in);
			Reader r = new InputStreamReader(in);
			int c;
			while ((c = r.read()) != -1) {
				System.out.print((char) c);
			}
		} catch (MalformedURLException ex) {
			System.err.println(url + " is not a parseable URL");
		} catch (IOException ex) {
			System.err.println(ex);
		} finally {
			if (in != null) {
				try { in.close(); } catch (IOException e) { }
			}
		}
	}
}
