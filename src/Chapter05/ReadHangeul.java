package Chapter05;

import java.io.*;

public class ReadHangeul {

	public static void main(String[] args) throws Exception {
//		InputStream is = new FileInputStream("hangeul.txt");
//		InputStreamReader isr = new InputStreamReader(is, "UTF-16");
		
		FileReader fd = new FileReader("hangeul.txt"); // 파일리더는 인코딩방식을 못 준다. 
		
		int chars = 0;
		int input = fd.read();
		while(input != -1) {
			System.out.print((char)input);
			 chars++;
			input = fd.read();
		}
		System.out.println("\n" + chars + " characters");
		fd.close();
		
		byte[] nation = "대한민국".getBytes("UTF-16");
		OutputStream os = new FileOutputStream("hangeul2.txt");
		os.write(nation);
		os.close();
		System.out.println(nation);
		
		InputStreamReader isr = new InputStreamReader(new FileInputStream("jnu.txt"));
		int inputs = isr.read();
		while(inputs != -1) {	
			System.out.print((char)inputs);
			inputs = isr.read();
		}
		isr.close();

		byte[] buf=new byte[1024];
		InputStream is = new FileInputStream("jnu.txt");
		int len = is.read(buf, 0, buf.length);
//		while(len != -1) {	
//			System.out.print((char)len);
//			len = is.read();
//		}
		String ms = new String(buf, 0, len, "MS949");
		System.out.println("MS949  encoding:" + ms);


	}

}
