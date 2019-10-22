package Chapter03;

import java.io.*;
import java.util.Date;

public class NonBuffered {
	public static void main(String[] args) throws Exception {
		int from = 0;
		int to = 100000;
		long start = new Date().getTime();
		
		FileOutputStream fos = new FileOutputStream("numbers.txt");
		for (int i = from; i < to; i++)
			fos.write(i);
		fos.close();
		
		int bytes = 0;
		FileInputStream fis = new FileInputStream("numbers.txt");
		int input = fis.read();
		while (input != -1) {
			bytes++;
			input = fis.read();
		}
		System.out.println("Tot = " + bytes);
		fis.close();
		
		long end = new Date().getTime();
		System.out.println("Elapsed Time = " + (end - start));
	}
}
