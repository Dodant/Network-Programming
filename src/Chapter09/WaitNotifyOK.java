package Chapter09;

public class WaitNotifyOK {
	public static void main(String[] args) {
		WaitNotify wn = new WaitNotify();
		Thread t1 = new Thread(wn, "WAIT");
		Thread t2 = new Thread(wn, "NOTIFY");
		t1.start();
		t2.start();
	}

	static class WaitNotify implements Runnable {
		private Object lockObject = new Object();
		private boolean OK = false;

		public void run() {
			if ((Thread.currentThread().getName()).equals("WAIT")) sun();
			if ((Thread.currentThread().getName()).equals("NOTIFY")) moon();
		}

		public void sun() {
			synchronized (lockObject) {
				try {
					System.out.println(Thread.currentThread().getName() + "- 1");
					while (OK != true)
						lockObject.wait();
					System.out.println(Thread.currentThread().getName() + "- 2");
				} catch (InterruptedException e) {
					System.out.println("sun() 3");
				}
			}
		}

		public void moon() {
			synchronized (lockObject) {
				System.out.println(Thread.currentThread().getName() + "- 1");
				OK = true;
				lockObject.notify();
				System.out.println(Thread.currentThread().getName() + "- 2");
			}
		}
	}
}