package Chapter13;

import java.net.*;
import java.io.*;

public class SourceViewer {
	public static void main(String[] args) {
		String url = "http://www.jnu.ac.kr";
		try {
			// Open the URLConnection for reading
			URL u = new URL(url);
			URLConnection uc = u.openConnection();
			InputStream raw = uc.getInputStream();
			InputStream buffer = new BufferedInputStream(raw);
			// chain the InputStream to a Reader
			Reader r = new InputStreamReader(buffer);
			int c;
			while ((c = r.read()) != -1) {
				System.out.print((char) c);
			}
		} catch (MalformedURLException ex) {
			System.err.println(url + " is not a parseable URL");
		} catch (IOException ex) {
			System.err.println(ex);
		}
	} // end main
} // end SourceViewer
