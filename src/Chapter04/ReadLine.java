package Chapter04;

import java.io.*;

public class ReadLine {

	public static void main(String[] args) throws IOException {
		InputStreamReader link = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(link);
		System.out.println("Enter lines fo text. End with control Z");
		String str = br.readLine();
		while(str != null) {
			System.out.println(str);
			str = br.readLine();
		}
	}
}