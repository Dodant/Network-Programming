package Chapter08_CallBack;

import javax.xml.bind.*;

public class CallbackDigestUserInterface {

	public static void receiveDigest(byte[] digest, String name) {
		StringBuilder result = new StringBuilder(name);
		result.append(": ");
		result.append(DatatypeConverter.printHexBinary(digest));
		System.out.println(result);
	}

	public static void main(String[] args) {
		for (String filename : args) {
			// Calculate the digest
			CallbackDigest cb = new CallbackDigest(filename);
			Thread t = new Thread(cb);
			t.start();
		}
	}
}
