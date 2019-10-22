package Chapter03;
import java.io.*;

public class PrintStreamExample {
	public static void main(String[] arguments) {
		try {
			FileOutputStream fos = new FileOutputStream("textout.txt");
			PrintStream ps = new PrintStream(fos);
			boolean bool = true;
			ps.println(bool);	// boolean
			byte b = -128;
			ps.println(b);		// byte
			double d = 0.9;
			ps.println(d);		// double
			Object o = new Object();
			ps.println(o);		// object
			
			System.out.println(1);	// ASCII 00110001 1 -> '1'
			System.out.write(1);	// ASCII 00000001
			System.out.flush();
			
			PrintStream ps1 = new PrintStream(new FileOutputStream("write.txt"));
			ps1.write(127);
			PrintStream ps2 = new PrintStream(new FileOutputStream("print.txt"));
			ps2.print(127);

			System.out.println(65);	// ASCII 00110001 1 -> '1'
			System.out.write(65);
			System.out.flush();
			
		} catch (IOException e) {
			System.out.println("Error -- " + e.toString());
		}
	}
}
