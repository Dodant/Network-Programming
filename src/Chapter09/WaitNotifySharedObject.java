package Chapter09;

public class WaitNotifySharedObject {
	public static void main(String[] args) {
		Integer integer = new Integer(100);
		Wait wait = new Wait(integer);
		Notify notify = new Notify(integer);
		Thread t1 = new Thread(wait, "WAIT");
		Thread t2 = new Thread(notify, "NOTIFY");
		t1.start();
		t2.start();
	}

	static class Wait extends Thread {
		private Object lockObject;

		public Wait(Object obj) {
			lockObject = obj;
		}

		public void run() {
			synchronized (lockObject) {
				try {
					System.out.println(Thread.currentThread().getName() + "-  1");
					lockObject.wait();
					System.out.println(Thread.currentThread().getName() + "-  2");
				} catch (InterruptedException e) {
					System.out.println("Sun() 3");
				}
			}
		}
	}

	static class Notify extends Thread {
		private Object lockObject;

		public Notify(Object obj) {
			lockObject = obj;
		}

		public void run() {
			synchronized (lockObject) {
				System.out.println(Thread.currentThread().getName() + "-  A");
				lockObject.notify();
				System.out.println(Thread.currentThread().getName() + "-  B");
			}
		}
	}
}