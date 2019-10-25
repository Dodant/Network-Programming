package Chapter02;
import java.io.File;

public class FileCanonicalPath {
	public static void main(String[] args) throws Exception {
		
		File file1 = new File("Ran.test");
		File file2 = new File(".");
		File file3 = new File("..");
		
		// 현행폴더 알아내기 
		System.out.println(System.getProperty("user.dir")); 
		System.out.println(file1.getCanonicalPath());
		System.out.println(file2.getCanonicalPath());
		System.out.println(file3.getCanonicalPath());
		
		System.out.println(file1.getParent());
		System.out.println(file2.getParent());
		System.out.println(file3.getParent());
		
		File[] root = File.listRoots();
		for(File f: root)
		     System.out.println(f);
	}
}
