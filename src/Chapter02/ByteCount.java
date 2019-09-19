package Chapter02;
import java.io.*;

public class ByteCount {
//	public static void main(String[] args) throws IOException {
//		FileInputStream fis = new FileInputStream ("javalogo.png");
//		int total = 0;
//		int j = fis.read();
//		while (j != -1) {
//			total++;
//			j = fis.read();
//		}
//		System.out.println(total + " bytes");
//	}
//}
	
//	public static void main(String[] args) throws IOException {
//		FileInputStream fis = new FileInputStream ("javalogo.png");
//		int total = 0;
//		int j = fis.read();
//		while (j != -1) {
//			total++;
//			j = fis.read();
//			System.out.print((char)j);
//		}
//		System.out.println(total + " bytes");
//	}
//}

	public static void main(String[] args) throws IOException {
//		FileInputStream fis = new FileInputStream ("javalogo.gif");
//		FileOutputStream fos = new FileOutputStream ("image.gif");
		FileInputStream fis = new FileInputStream ("hwpsample.hwp");
		FileOutputStream fos = new FileOutputStream ("hwpcopy.hwp");
		int total = 0;
		int j = fis.read();
		while (j != -1) {
			total++;
			fos.write(j);
			j = fis.read();
		}
		System.out.println(total + " bytes");
	}
}


