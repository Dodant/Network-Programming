package Chapter02;
import java.io.File;

public class AboutFile {
	public static void pathInfo(File file) throws Exception {
		System.out.println("Name: " + file.getName());
		System.out.println("Path: " + file.getPath());
		
		// CanonicalPath는 보통은 AbsolutePath와 동일하다. 
		// 그러나 .. 과 . 같은 축약기호를 사용했을 때는 상이하다
		System.out.println("Absolute Path: " + file.getAbsolutePath());
		System.out.println("Canonical Path: " + file.getCanonicalPath());
		System.out.println("Parent: " + file.getParent());
		System.out.println();
	}
	public static void main(String[] args) throws Exception{
		
		// File Generator
		File f1 = new File("file1.txt");
		File f2 = new File("/Users/Dodanto/Eclipse-WS/Network Programming/src/Chapter02", "file2.txt");
		File dir = new File("/Users/Dodanto/Eclipse-WS/Network Programming/src/Chapter02");
		File f3 = new File(dir, "file3.txt");
		
		boolean success = f1.createNewFile();
		if(success) {			
			System.out.println("Generated");
		}
		
		// Boolean Method
		System.out.println(f1.exists());
		System.out.println(f1.canRead());
		System.out.println(f1.canWrite());
		System.out.println(f1.isFile());
		System.out.println(f1.isDirectory());		
		System.out.println(f1.isAbsolute());
		System.out.println(f1.isHidden());
		
		// File System Query and Renew Method
		System.out.println(f1.lastModified());
		System.out.println(f1.length());
		System.out.println(f1.mkdir());		
		System.out.println(f1.mkdirs());
		
		// 파일 또는 디렉터리 이름을 새로운 이름으로 변경 
		// 파일을 다른 위치로 옮길 때도 사용 
		System.out.println(f1.renameTo(new File("renamed")));
		
		System.out.println(f1.delete() + "\n");
		
		pathInfo(f1);
		pathInfo(f2);
		
		System.out.println(new File(".").getAbsolutePath());
		System.out.println(new File(".").getCanonicalPath());
		
		System.out.println(new File("..").getAbsolutePath());
		System.out.println(new File("..").getCanonicalPath());
		
	}
}
