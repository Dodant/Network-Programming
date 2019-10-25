package Chapter08;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
	private static void unitTask() {
		System.out.println(Thread.currentThread().getName() + " 1회의 일 처리");
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 1; i <= 11; i++) {
			executorService.execute(new Runnable() {
				public void run() {
					unitTask();
				}
			});
		}
		executorService.shutdown();
	}
}
