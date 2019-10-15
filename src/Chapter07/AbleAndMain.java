package Chapter07;

public class AbleAndMain {
	public static void main(String[] args) {
		Worker w = new Worker();
		Thread t = new Thread(w, "Able");
		t.start();
		for (int i = 0; i < 3; i++)
			w.namePrint();
	}
}

class Worker implements Runnable {
	public Worker() {
		Thread maker = Thread.currentThread();
		System.out.println(maker + " has created " + this);
	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			namePrint();
		}
	}

	public void namePrint() {
		Thread t = Thread.currentThread();
		System.out.println("namePrint() called by " + t.getName());
	}
}
