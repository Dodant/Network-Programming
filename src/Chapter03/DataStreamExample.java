package Chapter03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class DataStreamExample { // FromTextToBinary
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(new File("textFile.txt"));
		DataOutputStream out = new DataOutputStream(new FileOutputStream("binaryFile"));
		// binary file <- 8 bytes
		while (input.hasNext()) {
			int number = input.nextInt();
			out.writeInt(number);
		}
		out.close();

		
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("1000.txt"));
		dos.writeInt(18);
		dos.writeInt(-18);
//		int a = (int) (65 * Math.pow(2, 24) + 66 * Math.pow(2, 16) + 67 * Math.pow(2, 8) + 68);
//		dos.writeInt(a);
//		int b = (int) (0x3C * Math.pow(2, 24) + 0x3D * Math.pow(2, 16) + 0x3E * Math.pow(2, 8) + 0x3F);
//		dos.writeInt(a);
//		dos.close();
		FileInputStream fis = new FileInputStream("1000.txt");
		int total = 0;
		int j = fis.read();
		while (j != -1) {
			total++;
			System.out.print(j + " ");
			j = fis.read();
		}
		System.out.println(total + "bytes");
		
		
		int total1 = 0;
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream("1000.dat"));
			while (true) {
				int theRead = dis.readInt();
				total1++;
				System.out.println(theRead + " ");
			}
		} catch (EOFException e) {
			System.out.println(total1 + " ints read");
		} catch (IOException e) {
			System.err.println("Some  IO Exception occurred");
		}

	}
}
