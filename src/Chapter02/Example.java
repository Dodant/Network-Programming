package Chapter02;
import java.io.File;

public class Example {
	public static void main(String[] args) throws Exception {
		// 현행 폴더 알아 내기
		System.out.println(System.getProperty("user.dir")); 
		
		// 파일 관련 System Property
		// java.home		자바 설치 홈 
		// user.home		사용자 홈 디렉토리 
		// user.dir			사용자 현행 작업 디렉토리 
		// file.separator	파일 구분자 
		
		File f = new File("..//dirC");
 		System.out.println("getName() = " + f.getName());
 		System.out.println("getPath() = " + f.getPath());
 		System.out.println("getAbsolutePath() = " + f.getAbsolutePath());
		System.out.println("getParent() = " + f.getParent());
		
		// 디렉터리 생성 
//		File file1 = new File("mother//");
//		File file2 = new File("father//son//");
//		file1.mkdir();
//		file2.mkdirs();
		
		System.out.println(java.io.File.separator);
		System.out.println(java.io.File.separatorChar);
		System.out.println(java.io.File.pathSeparator);
		System.out.println(java.io.File.pathSeparatorChar);

	}
}
