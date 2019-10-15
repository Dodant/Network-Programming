package Chapter07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool implements Runnable {
	public void run() {
		unitTask();
	}

	private void unitTask() {
		System.out.println(Thread.currentThread().getName() + " 1회의 일 처리");
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 1; i <= 100; i++) {
			executorService.execute(new ThreadPool());
		}
		executorService.shutdown();

	}

}
