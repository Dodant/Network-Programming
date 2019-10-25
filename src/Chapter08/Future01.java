package Chapter08;

import java.util.concurrent.*;

public class Future01 {
	private static int count = 0;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = null;
		try {
			executorService = Executors.newSingleThreadExecutor();
			// run은 람다식으로 씀 
			Future<?> future = executorService.submit(() -> {
				for (int i = 0; i < 50000; i++)
					Future01.count++;
			});
			System.out.println("future.get() = " + future.get(1, TimeUnit.MILLISECONDS));
			System.out.println("도달함");
		} catch (TimeoutException e) {
			System.out.println("시간 내 도달하지 못함");
		} finally {
			executorService.shutdown();
		}
	}
}
