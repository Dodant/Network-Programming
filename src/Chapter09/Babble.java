package Chapter09;

class Babble extends Thread {
	static int times;
	static boolean doYield;
	private String word;

	Babble(String word) {
		this.word = word;
	}

	public void run() {
		for (int i = 0; i < times; i++) {
			System.out.println(word);
			if (doYield)
				yield(); // give another thread a chance
		}
	}

	public static void main(String[] args) {
		times = Integer.parseInt(args[1]);
		doYield = new Boolean(args[0]).booleanValue();
		Thread cur = currentThread();
		cur.setPriority(Thread.MAX_PRIORITY);
		for (int i = 2; i < args.length; i++) {
			new Babble(args[i]).start();
		}
	}
}
