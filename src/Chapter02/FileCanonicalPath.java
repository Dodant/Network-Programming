package Chapter02;
import java.io.File;

public class FileCanonicalPath {
	public static void main(String[] args) throws Exception {
		
		File file1 = new File("Ran.test");
		File file2 = new File(".");
		File file3 = new File("..");
		
		System.out.println(System.getProperty("user.dir")); 
		System.out.println(file1.getCanonicalPath());
		System.out.println(file2.getCanonicalPath());
		System.out.println(file3.getCanonicalPath());

	}
}
