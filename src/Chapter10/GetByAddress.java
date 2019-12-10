package Chapter10;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetByAddress {

	public static void main(String[] args) {
		try {
			byte[] address = {(byte)168, (byte)131, 31, (byte)206};
			InetAddress lessWrong = InetAddress.getByAddress(address);
			InetAddress lessWrongWithName = InetAddress.getByAddress("lessWrong.com", address);
			System.out.println(lessWrong);
			System.out.println(lessWrongWithName);
			System.out.println();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		try {
		    InetAddress ia = InetAddress.getByName("www.jnu.ac.kr");
		    System.out.println("toString() --> " + ia);
		    System.out.println("getHostName() --> " + ia.getHostName());
		    System.out.println("getCanonicalHostName() --> " + ia.getCanonicalHostName());
		    for (byte k : ia.getAddress()) {
		        System.out.println("getAddress() --> " + (k & 0xff));
		    }
		    System.out.println("getHostAddress() --> "+ ia.getHostAddress());
		    System.out.println();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			InetAddress me = InetAddress.getLocalHost();
			for (byte k : me.getAddress()) {
		        System.out.println("getAddress() --> " + (k & 0xff));
		    }
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
