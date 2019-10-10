package Chapter06;

import java.io.*;
import java.util.zip.*;

public class ZipFiles {

	public static void main(String[] args) throws Exception {
		// ZipOuputStream 생성
		// 압축 파일명 : zipzip.zip
		ZipOutputStream zout = new ZipOutputStream(
							   new FileOutputStream("zipzip.zip"));
		
		// ZipEntry 객체 생성 및 아카이브에 추
		zout.putNextEntry(new ZipEntry("jnu.txt"));
		// Stream에 데이터 출력 
		FileInputStream fin = new FileInputStream("jnu.txt");
		for (int c = fin.read(); c != -1; c = fin.read()) {
			zout.write(c);
		}
		zout.closeEntry();
		
		zout.putNextEntry(new ZipEntry("hangeul.txt"));
		FileInputStream fin1 = new FileInputStream("hangeul.txt");
		for (int c = fin1.read(); c != -1; c = fin1.read()) {
			zout.write(c);
		}
		zout.closeEntry();
		
		zout.close();
	}

}
