package Chapter07;

public class EachThread implements Runnable {
	public void run() {
		unitTask();
	}

	private void unitTask() {
		System.out.println(Thread.currentThread().getName() + " 1회의 일 처리");
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(new EachThread()).start();
		}
	}
}
