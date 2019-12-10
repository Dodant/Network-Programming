package Chapter11;

import java.io.*;
import java.net.*;

public class ContentGetter {

	public static void main(String[] args) {

		try {
			URL u = new URL("https://www.jnu.ac.kr");
			Object o = u.getContent();
			System.out.println("I got a " + o.getClass().getName());
			
		} catch (MalformedURLException ex) {
			System.err.println("www.jnu.ac.kr" + " is not a parseable URL");
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
