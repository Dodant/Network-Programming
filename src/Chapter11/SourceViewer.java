package Chapter11;

import java.io.*;
import java.net.*;

public class SourceViewer {

	public static void main(String[] args) {

		InputStream in = null;
		String url = "http://www.jnu.ac.kr";
		try {
			// Open the URL for reading
			URL u = new URL(url);
			in = u.openStream();
			// buffer the input to increase performance
			in = new BufferedInputStream(in);
			// chain the InputStream to a Reader
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
				try {
					in.close();
				} catch (IOException e) { }
			}
		}
	}
}
