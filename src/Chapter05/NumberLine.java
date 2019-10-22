package Chapter05;

import java.util.*;
import java.io.*;

public class NumberLine {
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private PrintWriter printWriter;

	public NumberLine() throws FileNotFoundException, IOException {
		String inputFile = "file03.txt";
		String outputFile = "outfile.txt";

		bufferedReader = new BufferedReader(new FileReader(inputFile));
		printWriter = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
	}

	public static void main(String[] args) throws Exception {

		NumberLine numberLines = new NumberLine();
		String s;
		int linecount = 0;
		while ((s = numberLines.bufferedReader.readLine()) != null) {
			linecount++;
			numberLines.printWriter.println(linecount + ": " + s);
			System.out.println(linecount + " processed");
		}
		numberLines.printWriter.close();
	}
}
