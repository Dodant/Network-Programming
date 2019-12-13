package Chapter11;

import java.io.*;
import java.net.*;

public class EncoderTest {

	public static void main(String[] args) {

		try {
			System.out.println(URLEncoder.encode("This string has spaces", "UTF-8"));
			System.out.println(URLEncoder.encode("This*string*has*asterisks", "UTF-8"));
			System.out.println(URLEncoder.encode("This%string%has%percent%signs", "UTF-8"));
			System.out.println(URLEncoder.encode("This+string+has+pluses", "UTF-8"));
			System.out.println(URLEncoder.encode("This/string/has/slashes", "UTF-8"));
			System.out.println(URLEncoder.encode("This\"string\"has\"quote\"marks", "UTF-8"));
			System.out.println(URLEncoder.encode("This:string:has:colons", "UTF-8"));
			System.out.println(URLEncoder.encode("This~string~has~tildes", "UTF-16"));
			System.out.println(URLEncoder.encode("This(string)has(parentheses)", "UTF-16"));
			System.out.println(URLEncoder.encode("This.string.has.periods", "UTF-16"));
			System.out.println(URLEncoder.encode("This=string=has=equals=signs", "UTF-16"));
			System.out.println(URLEncoder.encode("This&string&has&ampersands", "UTF-16"));
			System.out.println(URLEncoder.encode("This사과string사과has사과non-ASCII characters", "MS949"));
			
			String s = "사과";
			byte[] apple = s.getBytes("UTF-16");
			for (byte b : apple)
				System.out.print(Integer.toHexString(b&0xFF) + "");
			System.out.println();
			byte[] apple3 = s.getBytes("Unicode");
			for (byte b : apple3)
				System.out.print(Integer.toHexString(b&0xFF) + "");
			System.out.println();
			byte[] apple4 = s.getBytes();
			for (byte b : apple4)
				System.out.print(Integer.toHexString(b&0xFF) + "");
			System.out.println();
			// feff - unicode 스트링이다 
			byte[] apple1 = s.getBytes("UTF-8");
			for (byte b : apple1)
				System.out.print(Integer.toHexString(b&0xFF) + "");
			System.out.println();
			byte[] apple2 = s.getBytes("MS949");
			for (byte b : apple2)
				System.out.print(Integer.toHexString(b&0xFF) + "");
			System.out.println();
			System.out.println(URLEncoder.encode(s, "MS949"));
			

			
		} catch (UnsupportedEncodingException ex) {
			throw new RuntimeException("Broken VM does not support UTF-8");
		}
	}
}
