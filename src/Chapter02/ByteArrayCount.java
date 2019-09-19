package Chapter02;

import java.io.*;

public class ByteArrayCount {

//	public static void main(String[] args) throws IOException {
//		FileInputStream fis = new FileInputStream("javalogo.gif");
//		FileOutputStream fos = new FileOutputStream ("image2.gif");
//		int total = 0;
//		int readCnt = 0;
//		byte[] buf = new byte[300];
//		int count = fis.read(buf, 0, 100);
//		while (count != -1) {
//			total = total + count;
//			fos.write(buf, 0, count);
//			count = fis.read(buf, 0, 100);
//			readCnt++;
//		}
//		System.out.println("read : "+ readCnt);
//		System.out.println(total + " bytes");
//	}
//}

	public static void main(String[] arguments) throws Exception{
		FileInputStream fis = new FileInputStream("javalogo.gif");
		byte[] b = new byte[fis.available()];
		int count = fis.read(b);
		fis.close();
		System.out.println("Bytes read: " + count);
		for (int i = 0; i < count; i++) {
			// 127보다 큰 수는 byte 배열에 저장될 때 음수로 바뀌어 저장됨
			// 원래의 값을 알기 위해 & 0xff 처리하면 됨
			int alpha = b[i] & 0xff;
			System.out.print(alpha + " ");
			// 1줄에 8개 바이트씩 인쇄
			if(i % 8 == 7) System.out.print('\n');
			else System.out.print('\t');
		}
	}
}
