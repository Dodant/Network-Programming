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
//		readCharacterData();
	}
	public static void readCharacterData() throws IOException {
	    int c;
	    int count = 0;
	    InputStreamReader link = new InputStreamReader(System.in); 
	    BufferedReader br  = new BufferedReader( link);
	    while (  (c = br.read())  != -1) {
	        count++;
	        System.out.println(c + "  "+(char)c);
	    }
	    System.out.println("Number of Characters: "+count);
	}

}