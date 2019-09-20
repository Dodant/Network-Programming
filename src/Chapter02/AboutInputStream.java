package Chapter02;
import java.io.*;

public class AboutInputStream {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("myFile.txt");
//		FileInputStream fis = new FileInputStream(new File("file03.txt"));
		int total = 0;
		int j = fis.read(); // read()문을 2개 사용 (권장) 
		while(j != -1) {
			total++;
			j = fis.read();
		}
		System.out.println(total + " bytes");
		
		
		// 다형적 스트림 객체 참조변수 
		InputStream is = new FileInputStream("myFile.dat");
		is.close();
	}

}
