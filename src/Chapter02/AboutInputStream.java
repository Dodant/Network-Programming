package Chapter02;
import java.io.*;

public class AboutInputStream {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("myFile.txt");
//		FileInputStream fis = new FileInputStream(new File("file03.txt"));
		int total = 0;
		int j = fis.read();
		while(j != -1) {
			total++;
			j = fis.read();
		}
		System.out.println(total + " bytes");
	}

}
