package Chapter04;

import java.io.*;

public class ConsoleTest {
	public static void main(String[] args) throws IOException {
		int count = 0;
		int b = System.in.read();
		while (b != -1) {
			count++;
			System.out.println(b + "  " + (char) b); // 바이트와 해당 문자
			b = System.in.read();
		}
		System.out.println("Number of Characters: " + count);
	}
}
