package Chapter07;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorService02 implements Callable<String> {
	public String call() throws Exception {
		return "Callable Result";
	}

	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Future<String> future = executorService.submit(new ExecutorService02());
		System.out.println("Result = " + future.get());
		executorService.shutdown();
	}

}
