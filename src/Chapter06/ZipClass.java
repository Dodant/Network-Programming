package Chapter06;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipClass {
	public static void main(String[] args) throws IOException {
		ZipFile zf = new ZipFile("comp.zip");
		Enumeration e = zf.entries();
		while (e.hasMoreElements()) {
			ZipEntry ze = (ZipEntry) e.nextElement();
			System.out.println("Unzipping: " + ze.getName());
			FileOutputStream fos = new FileOutputStream(ze.getName());
			InputStream is = zf.getInputStream(ze);
			for (int c = is.read(); c != -1; c = is.read()) {
				fos.write(c);
			}
			is.close();
			fos.close();
		}
	}
}
