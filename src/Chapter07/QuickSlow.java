package Chapter07;

class QuickSlow extends Thread {
	String say;
	int delay;

	QuickSlow(String whatToSay, int delayTime) {
		say = whatToSay;
		delay = delayTime;
	}

	public void run() {
		try {
			for (;;) {
				System.out.print(say + " ");
				sleep(delay);
			}
		} catch (InterruptedException e) {
			return; // 스레드 실행 끝
		}
	}

	public static void main(String[] args) {
		new QuickSlow("Quick", 1000).start();
		new QuickSlow("Slow", 3000).start();
	}
}