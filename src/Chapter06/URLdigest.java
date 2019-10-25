package Chapter06;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class URLdigest {

	public static void main(String[] args) throws Exception {
		URL u = new URL("http://www.jnu.ac.kr");
		InputStream in = u.openStream();
		MessageDigest sha = MessageDigest.getInstance("SHA");
		byte[] data = new byte[1024];
		while (true) {
			int bytesRead = in.read(data);
			if (bytesRead < 0)
				break;
			sha.update(data, 0, bytesRead);
		}
		byte[] result = sha.digest();
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
