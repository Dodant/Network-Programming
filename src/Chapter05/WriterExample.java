package Chapter05;

import java.io.*;

public class WriterExample {

	public static void main(String[] args) throws IOException {
		Writer w = new OutputStreamWriter(
				// System.out
				new FileOutputStream("korea.txt"));
		char[] nation = { 'K', 'O', 'R', 'E', 'A', '한', '국' };
		for (int i = 0; i < nation.length; i++)
			w.write(nation[i]); // write(int)
		w.write(nation); // write(char[])
		w.write(nation, 0, nation.length); // write(char[], int, int)
		w.write("KOREA한국"); // write(String)
		w.write("KOREA한국", 0, 7); // write(String, int, int)
		w.flush(); // flush()를 호출하지 않으면 출력 결과 안 보인다

		System.out.println(System.getProperty("file.encoding"));

		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("hanguel.txt"), "UTF-16");
		osw.write("자바의 OutputStreamWriter 스트림 사용 연습\n");
		osw.write("자바의 OutputStreamWriter 스트림 사용 연습");
		System.out.println(osw.getEncoding());
		osw.close();

		File file = new File("alphabet.txt");
		FileWriter fw = new FileWriter(file);
		for (int i = 0; i < 26; i++) {
			fw.write(i + 'a');
		}
		fw.close();

		FileWriter fw1 = new FileWriter("hangeul3.txt");
		String s = " 자바의 FileWriter를 사용한다";
		fw1.write(s);
		fw1.flush();
		fw1.close();

	}
}
