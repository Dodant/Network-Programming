package Chapter13;

import java.io.*;
import java.net.*;

public class AllHeaders {

	public static void main(String[] args) {
		String url = "https://image.shutterstock.com/image-photo/colorful-flower-on-dark-tropical-260nw-721703848.jpg";
//		String url = "http://www.jnu.ac.kr";
		try {
			URL u = new URL(url);
			URLConnection uc = u.openConnection();
			for (int j = 1;; j++) {
				String header = uc.getHeaderField(j);
				if (header == null)
					break;
				System.out.println(uc.getHeaderFieldKey(j) + ": " + header);
			}
		} catch (MalformedURLException ex) {
			System.err.println(url + " is not a URL I understand.");
		} catch (IOException ex) {
			System.err.println(ex);
		}
		System.out.println();
	}
}
