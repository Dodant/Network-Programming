package Chapter10;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetByName {

	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getByName("www.jnu.ac.kr");
			System.out.println(address);
			address = InetAddress.getByName("168.131.31.206"); // 권장하지 않음
			System.out.println(address.getHostName());

		} catch (UnknownHostException ex) {
			System.out.println("Could not find www.jnu.ac.kr");
		}

		try {
			InetAddress[] addresses = InetAddress.getAllByName("www.apple.com");
			for (InetAddress address : addresses) {
				System.out.println(address);
			}
		} catch (UnknownHostException e) {
			System.out.println("Could not find www.apple.com");
		}

		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address);
		} catch (UnknownHostException ex) {
			System.out.println("Could not find this computer's address.");
		}
		
		try {
			System.out.println(InetAddress.getLocalHost());
			System.out.println(InetAddress.getByName("localhost"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
