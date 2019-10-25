package Chapter08;

import java.io.*;
import javax.xml.bind.*;

public class ReturnDigestUserInterfaceA {
	public static void main(String[] args) {
		ReturnDigest[] thread = new ReturnDigest[args.length];
		for (int i = 0; i < args.length; i++) {
			// Calculate the digest
			thread[i] = new ReturnDigest(args[i]);
			thread[i].start();
		} // for
		for (int i = 0; i < args.length; i++) {
			// Now print the result
			StringBuffer result = new StringBuffer(args[i]);
			result.append(": ");
			byte[] digest = thread[i].getDigest();
//			result.append(DatatypeConverter.printHexBinary(digest));
			result.append(digest);
			System.out.println(result);
		} // for
	} // main()
}
