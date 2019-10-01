package Chapter05;

import java.io.*;

public class ByteArrayAndString {

	public static void main(String[] args) throws Exception{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(bos);
		String s = "자바stream"; // 중간고사 예시 
		osw.write(s);
		osw.flush();
		byte[] ba = bos.toByteArray(); // 중요
		// 바이트 배열의 전체 내용을 한 바이트씩 출력해 본다
		for(int m=0;m<ba.length;m++){
			int ich = ba[m] & 0xff;
			System.out.print(Integer.toHexString(ich) + " ");
		}
		// 바이트 배열을 문자열로 변환하여 출력해 본다
		String reconstructed = new String(ba, 0, ba.length);
		System.out.println('\n' + reconstructed);
	}
}
