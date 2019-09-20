package Chapter03;
import java.io.*;
import java.util.Date;

public class BirdStream {

	public static void main(String[] args) throws Exception {
		
		long start1 = new Date().getTime();
		FileInputStream fis1 = new FileInputStream("bird.gif");
		FileOutputStream fos1 = new FileOutputStream("bird1.gif");

		int j = fis1.read();
		while (j != -1) {
			fos1.write(j);
			j = fis1.read();
		}
		fis1.close();
		long end1 = new Date().getTime();
		System.out.println("Non-Buffered Elapsed Time = " + (end1 - start1));
		
		
		FileInputStream fis2 = new FileInputStream("bird.gif");
		FileOutputStream fos2 = new FileOutputStream("bird2.gif");
		byte[] buf = new byte[1024];
		int cnt = fis2.read(buf);
		while(cnt != -1) {
			fos2.write(buf);
			cnt = fis2.read(buf);
		}
		fis2.close();
		
		FileInputStream fis3 = new FileInputStream("bird.gif");
		FileOutputStream fos3 = new FileOutputStream("bird3.gif");
		byte[] buff = new byte[1024];
		int count = fis3.read(buff);
		while(count != -1) {
			fos3.write(buff, 0, count);
			count = fis3.read(buff, 0 ,count);
		}
		fis3.close();
		
		long start2 = new Date().getTime();
		FileInputStream fis4 = new FileInputStream("bird.gif");
		FileOutputStream fos4 = new FileOutputStream("bird4.gif");
		BufferedInputStream bis = new BufferedInputStream(fis4);
		int input = bis.read();
		while(input != -1) {
			fos4.write(input);
			input = bis.read();
		}
		bis.close();
		long end2 = new Date().getTime();
		System.out.println("Buffered Elapsed Time = " + (end2 - start2));
		
	}

}
