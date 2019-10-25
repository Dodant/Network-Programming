package Chapter08;

import java.io.*;
import javax.xml.bind.*;

public class ReturnDigestUserInterfaceB {
	public static void main(String[] args) throws InterruptedException {
		ReturnDigest[] thread = new ReturnDigest[args.length];
		for (int i = 0; i < args.length; i++) {
			// Calculate the digest
			thread[i] = new ReturnDigest(args[i]);
			thread[i].start();
		}
		for (int i = 0; i < args.length; i++) {
			while (true) {
				Thread.sleep(4);
				byte[] digest = thread[i].getDigest();
				if (digest != null) {
					StringBuffer result = new StringBuffer(args[i]);
					result.append(": ");
					result.append(DatatypeConverter.printHexBinary(digest));
					System.out.println(result);
					break;
				}
			}
		}
	}
}
