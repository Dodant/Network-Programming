package Chapter10;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetByAddress {

	public static void main(String[] args) {
		try {
			byte[] address = {(byte)168, (byte)131, 31, (byte)206};
			InetAddress lessWrong = InetAddress.getByAddress(address);
			InetAddress lessWrongWithName = InetAddress.getByAddress("lessWrong.com", address);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
		    InetAddress ia = InetAddress.getByName("www.jnu.ac.kr");
		    System.out.println("toString() --> " + ia);
		    System.out.println("getHostName() --> " + ia.getHostName());
		    System.out.println("getCanonicalHostName() --> " + ia.getCanonicalHostName());
		    for(byte k: ia.getAddress()){
		        System.out.println("getAddress() --> " + (k & 0xff));
		    }
		    System.out.println("getHostAddress() --> "+ ia.getHostAddress());

//		    ia = InetAddress.getByName("208.201.239.37");
//	    	System.out.println("getCanonicalHostName() --> " + ia.getCanonicalHostName());
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			InetAddress me = InetAddress.getLocalHost();
			byte[] address = me.getAddress();
			for(byte k: address){
		        System.out.println("getAddress() --> " + (k & 0xff));
		    }
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
