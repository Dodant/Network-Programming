package Chapter05;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArray {

	public static void main(String[] args) throws IOException {
		byte[] fromArray = {71,72,73,74,75};
		
		System.out.println("배열 내의 byte 수  " + fromArray.length);
		
		ByteArrayInputStream bais = new ByteArrayInputStream(fromArray);
		byte[] carrier = new byte[512]; // 1회에 512 바이트씩 끊어 읽음
		int count = bais.read(carrier);
		while(count != -1){
			System.out.write(carrier, 0, count); //
			count = bais.read(carrier);
		}
		System.out.println();
		System.out.println("byte 배열을 모니터에 모두 출력했음");

	}

}
