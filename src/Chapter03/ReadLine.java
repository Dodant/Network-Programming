package Chapter03;

import java.io.*;
public class ReadLine{
	public static void main(String[] arguments) {
		try {
			FileInputStream file = new FileInputStream("line.dat");
			DataInputStream dis = new DataInputStream(file);
			String line = dis.readLine();
			while (line != null) {
				System.out.println(line);
				line = dis.readLine();
			}
			dis.close();
		} catch (IOException e) {
			System.out.println("Error -- " + e.toString());
		}
	}
}
