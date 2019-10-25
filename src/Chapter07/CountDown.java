package Chapter07;

//public class CountUp extends Thread {
//	
//	int init, sum;
//	
//	public CountUp(int init) {
//		this.init = init;
//		this.sum = 0;
//	}
//	
//	public void run() {
//		for (int i = 1; i <= init; i++) {
//			sum += i;
//			System.out.println("Summing: " + (sum));
//		}
//	}
//
//	public static void main(String[] args) {
//		
//		new CountUp(7).start();
//		new CountUp(10).start();
//	}
//}

public class CountDown implements Runnable {
	public void run() {
		System.out.println("Counting Down" + " ");
		for (int i = 0; i < 10; i++) {
			System.out.print(10 - i + " ");
		}
		System.out.println("\nShot");
	}

	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			System.out.println("Counting Down" + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(10 - i + " ");
			}
			System.out.println("\nShot");
		}, "Count Down");
		t.start();
		
		System.out.println(t.getName());
		System.out.println("outer " + Thread.currentThread().getName());
	}
}
