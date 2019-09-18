package Chapter02;
import java.io.*;

public class PrintFiles {
	public static void main(String[] args) {
		File f = new File("//Users//Dodanto//Documents//Artistic");
		printFile(f);
	}
	public static void printFile(File f) {
		File[] list = f.listFiles();
		for (File file : list) {
			if (file.isDirectory()) {
				System.out.println(file.getName() + " <- Directory");
				printFile(file);
			}
			if (file.isFile())
				System.out.println(file.getName());
		}
	}
}
