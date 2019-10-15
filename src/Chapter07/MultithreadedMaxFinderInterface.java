package Chapter07;

import java.util.concurrent.ExecutionException;

public class MultithreadedMaxFinderInterface {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int[] ints = { 2, 11, 7, 3, 13, 5, 17 };
		int a = MultithreadedMaxFinder.max(ints);
		System.out.println(a);
	}
}
