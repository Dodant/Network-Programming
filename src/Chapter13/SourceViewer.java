package Chapter13;

import java.net.*;
import java.io.*;

public class SourceViewer {
	public static void main(String[] args) {
		String url = "http://www.jnu.ac.kr";
		try {
			// Open the URLConnection for reading
			URL u = new URL(url);
			Reader r = new InputStreamReader(
						new BufferedInputStream(
						 u.openConnection().getInputStream()));
			int c;
			while ((c = r.read()) != -1) {
				System.out.print((char) c);
			}
		} catch (MalformedURLException ex) {
			System.err.println(url + " is not a parseable URL");
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
