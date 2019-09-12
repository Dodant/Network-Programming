package Chapter02;
import java.io.File;

public class Example {
	public static void main(String[] args) throws Exception {
		// 현행 폴더 알아 내기
		System.out.println(System.getProperty("user.dir")); 
		
		File f = new File("..//dirC");
 		System.out.println("getName() = " + f.getName());
 		System.out.println("getPath() = " + f.getPath());
 		System.out.println("getAbsolutePath() = " + f.getAbsolutePath());
		System.out.println("getParent() = " + f.getParent());
		
		// 디렉터리 생성 
		System.out.println(System.getProperty("user.dir"));
		File file1 = new File("mother//");
		File file2 = new File("father//son//");
		file1.mkdir();
		file2.mkdirs();


	}
}
