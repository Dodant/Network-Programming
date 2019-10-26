package Chapter09;

import java.io.IOException;

public class WaitAndNotify {
	public static void main(String[] args) {
		WaitNotify wn = new WaitNotify();
		Thread t1 = new Thread(wn, "WAIT");
		Thread t2 = new Thread(wn, "NOTIFY");
		t1.start();
		t2.start();
	}

	static class WaitNotify implements Runnable {
		private Object lockObject = new Object();

		public void run() {
			if ((Thread.currentThread().getName()).equals("WAIT")) sun();
			if ((Thread.currentThread().getName()).equals("NOTIFY")) moon();
		}

		public void sun() {
			synchronized (lockObject) {
				try {
					System.out.println("1 sun() ");
					lockObject.wait();
					System.out.println("2 sun() ");
				} catch (InterruptedException e) {
					System.out.println("3 sun() ");
				}
			}
		}

		public void moon() {
			synchronized (lockObject) {
				System.out.println("A moon() ");
				lockObject.notify();
				System.out.println("B moon() ");
				try {
					int val = System.in.read();
					System.out.println(val);
				} catch (IOException e) {
				}
				;
			}
		}
	}
}
