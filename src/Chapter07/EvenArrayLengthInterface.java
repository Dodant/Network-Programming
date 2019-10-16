package Chapter07;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class EvenArrayThread implements Callable<ArrayList> {

	private ArrayList<Integer> data;

	public EvenArrayThread(ArrayList<Integer> data) {
		this.data = data;
	}

	@Override
	public ArrayList<Integer> call() throws Exception {
		ArrayList<Integer> even = new ArrayList<>();
		for (int i : data) {
			if (i % 2 == 0)
				even.add(i);
		}
		return even;
	}
}

class EvenArrayLength {
	public static int length(ArrayList<Integer> data1, ArrayList<Integer> data2) throws InterruptedException, ExecutionException {
		EvenArrayThread task1 = new EvenArrayThread(data1);
		EvenArrayThread task2 = new EvenArrayThread(data2);

		ExecutorService service = Executors.newFixedThreadPool(2);

		Future<ArrayList> future1 = service.submit(task1);
		Future<ArrayList> future2 = service.submit(task2);

		return future1.get().size() + future2.get().size();
	}
}


public class EvenArrayLengthInterface {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		
		arr1.add(1); arr1.add(2); arr1.add(3); arr1.add(4); arr1.add(5);
		arr2.add(100); arr2.add(108); arr2.add(102); arr2.add(103);

		System.out.println(EvenArrayLength.length(arr1, arr2));
	}
}

//public static void main(String[] args) {
//ExecutorService service = Executors.newFixedThreadPool(2);
//
//}