package Chapter03;

import java.io.*;

public class DoubleStream {

	public static void main(String[] args) {
		try {
			DataOutputStream dos = new DataOutputStream(
								   new FileOutputStream("real.dat"));
			for (int i = 0; i < 5; i++) {
				dos.writeDouble(Math.random());
			}
			dos.flush();
			dos.close();
		} catch (IOException e) {
			System.err.println("Output IOException occured");
		}
		
		int total = 0;
		try {
			FileInputStream fis = new FileInputStream("real.dat");
			int j = fis.read();
			while (j != -1) {
				total++;
				System.out.print(j + " ");
				if (total % 8 == 0)
					System.out.print("\n");
				j = fis.read();
			}
			fis.close();
			System.out.println(total + " bytes");
		} catch (IOException e) {
			System.err.println("Input IOException occured");
		}
		
		total = 0;
		try {
			DataInputStream dis = new DataInputStream(
					              new FileInputStream("real.dat"));
			while (true) {
				double theRead = dis.readDouble();
				total++;
				System.out.println(theRead + " ");
			}
		} catch (EOFException e) {
			System.out.println(total + " Doubles");
		} catch (IOException e) {
			System.err.println("Input IOException occured");
		}
	}
}