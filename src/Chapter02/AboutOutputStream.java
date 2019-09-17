package Chapter02;
import java.io.*;

public class AboutOutputStream {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos1 = new FileOutputStream("file02.txt");
//		for (int i = 33; i < 33 + 125; i++) // ASCII
//			fos.write(i);
		
//		for (int i = 65; i < 65 + 26; i++)
//			fos.write(i);		
		
//		int data = 321; 	// Overflow - "A" 65
//		fos.write(data);
		
//		for (int i = 321; i < 321 + 26; i++)
//			fos.write(i);
		
		for (int i = -191; i < -191 + 26; i++)
			fos1.write(i);
		
		byte[] bt = new byte[26];
		for(int i = 0; i < 26 ; i++) bt[i] = (byte)(i+65);
		FileOutputStream fos2 = new FileOutputStream("file03.txt");
		fos2.write(bt);
		
		String jnu = "자랑스러운 전남대학교";
		byte[] bt3 = jnu.getBytes();
		FileOutputStream fos3 = new FileOutputStream("jnu.txt");
		fos3.write(bt3);
		
		fos1.close();
		fos2.close();
		fos3.close();

	}
}
