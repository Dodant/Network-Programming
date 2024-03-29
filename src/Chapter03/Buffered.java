package Chapter03;
import java.io.*;
import java.util.Date;

public class Buffered {
	public static void main(String[] args) throws Exception{
		int from = 0;
		int to = 100000;
		long start = new Date().getTime();
		
		FileOutputStream fos = new FileOutputStream("numbers.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos); // <- Wrapping, Chaining / High-Level Stream
		for(int i = from; i < to; i++)
			bos.write(i);
		bos.flush();
		bos.close();
		
		int bytes = 0;
		FileInputStream fis = new FileInputStream("numbers.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		int input = bis.read();
		while (input != -1) {
			bytes++;
			input = bis.read();
		}
		bis.close();
		
		System.out.println("Tot =  " + bytes);
		long end = new Date().getTime();
		System.out.println("Buffered Elapsed Time = " + (end - start));
	}
}