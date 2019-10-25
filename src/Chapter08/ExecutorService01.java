package Chapter08;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorService01 {
	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Future future = executorService.submit(() -> {
			System.out.println("Asynchronous Callable");
			return "Callable Result";
		});
		System.out.println("future.get() = " + future.get());
		executorService.shutdown();
	}
}
