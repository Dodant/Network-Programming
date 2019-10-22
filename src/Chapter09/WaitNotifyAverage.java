package Chapter09;

public class WaitNotifyAverage {
	public static void main(String[] args) {
		Mean mean = new Mean();
		Waiter waiter = new Waiter(mean);
		Server server = new Server(mean, new int[] { 1, 2, 3, 4, 5 });
		Thread t1 = new Thread(waiter);
		Thread t2 = new Thread(server);
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Interrupted !");
		}
		t2.start();
	}

	static class Waiter implements Runnable {
		private Mean avr;

		public Waiter(Mean a) {
			avr = a;
		}

		public void run() {
			synchronized (avr) {
				try {
					avr.wait();
					System.out.println("average = " + avr.getAverage());
				} catch (InterruptedException e) {
					System.out.println("Interrupted !");
				}
			}
		}
	}

	static class Server implements Runnable {
		private Mean avr;
		private int[] array;

		public Server(Mean a, int[] data) {
			avr = a;
			array = data;
		}

		public void run() {
			synchronized (avr) {
				double sum = 0;
				for (int i = 0; i < array.length; i++) {
					sum += array[i];
				}
				avr.setAverage(sum / array.length);
				avr.notify();
			}
		}
	}

	static class Mean {
		private double average;

		void setAverage(double d) {
			average = d;
		}

		double getAverage() {
			return average;
		}
	}
}
