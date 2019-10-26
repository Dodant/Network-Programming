package Chapter09;

public class DigitalClockSM {
	public static void main(String[] args) {
		Switch swtch = new Switch();
		Second second = new Second(swtch);
		Thread t1 = new Thread(second);
		Minute minute = new Minute(swtch);
		Thread t2 = new Thread(minute);
		t1.start();
		t2.start();
	}
}

class Switch {
	private boolean inUse = true;

	public synchronized void on() {
		while (inUse) {
			try { wait();} 
			catch (InterruptedException e) {};
		}
		inUse = true;
	}

	public synchronized void off() {
		inUse = false;
		notify();
	}
}
// 스위치 1개  
class Second implements Runnable {
	private int seconds = 0;
	private Switch swtch;

	public Second(Switch swtch) {
		this.swtch = swtch;
	}

	public void run() {
		while (true) {
			try { Thread.sleep(1000);} 
			catch (InterruptedException e) {}
			if (seconds == 59) {
				swtch.off();
				seconds = 0;
			} else {
				seconds++;
				System.out.println(seconds);
			}
		}
	}
}
// 	분시계는 스위치 2개 필요 
class Minute implements Runnable {
	private int minutes = 0;
	private Switch swtch;

	public Minute(Switch swtch) {
		this.swtch = swtch;
	}

	public void run() {
		while (true) {
			swtch.on();
			if (minutes == 59) minutes = 0;
			else {
				minutes++;
				System.out.println(minutes + " minutes");
			}
		}
	}
}
