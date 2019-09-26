package Chapter05;

import java.io.*;

public class PrintWriterExample {

	public static void main(String[] args) throws IOException{
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("alphabet.txt")));
		for (int i = 0; i < 26; i++) {
			pw.println((char)(i +'A'));
		}
		pw.close();

	}

}
