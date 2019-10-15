package Chapter07;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Executor01 implements Runnable {

	private static Executor ex = Executors.newSingleThreadExecutor();

	public void run() {
		unitTask();
	}

	private void unitTask() {
		for (int i = 65; i < 65 + 26; i++) {
			System.out.print((char)i);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			ex.execute(new Executor01());
		}
	}	

}
