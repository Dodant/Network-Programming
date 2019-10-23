package Chapter09;

public class DigitalClockSMH {
	public static void main(String[] args) {
		
		SwitchSMH swtch1 = new SwitchSMH();
		SwitchSMH swtch2 = new SwitchSMH();
		
		SecondSMH second = new SecondSMH(swtch1);
		MinuteSMH minute = new MinuteSMH(swtch1, swtch2);
		HourSMH hour = new HourSMH(swtch2);

		Thread t1 = new Thread(second);
		Thread t2 = new Thread(minute);
		Thread t3 = new Thread(hour);
		
		t1.start();
		t2.start();
		t3.start();
	}
}

class SecondSMH implements Runnable {
	private int seconds = 0;
	private SwitchSMH swtch;

	public SecondSMH(SwitchSMH swtch) {
		this.swtch = swtch;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			if (seconds == 59) {
				swtch.off();
				seconds = 0;
			} else {
				seconds++;
				System.out.print(seconds);
			}
		}
	}
}

class MinuteSMH implements Runnable {
	private int minutes = 0;
	private SwitchSMH swtch1;
	private SwitchSMH swtch2;

	public MinuteSMH(SwitchSMH swtch1, SwitchSMH swtch2) {
		this.swtch1 = swtch1;
		this.swtch2 = swtch2;
	}

	public void run() {
		while (true) {
			swtch1.on();
			if (minutes == 59) {
				swtch2.off();
				minutes = 0;
			} else {
				minutes++;
				System.out.println(minutes + " Minutes");
			}
		}
	}
}

class HourSMH implements Runnable {
	private int hours = 0;
	private SwitchSMH swtch;

	public HourSMH(SwitchSMH swtch) {
		this.swtch = swtch;
	}

	public void run() {
		while (true) {
			swtch.on();
			if (hours == 23)
				hours = 0;
			else {
				hours++;
				System.out.println(hours + " Hours");
			}
		}
	}
}

class SwitchSMH {
	private boolean inUse = true;

	public synchronized void on() {
		while (inUse) {
			try {
				wait();
			} catch (InterruptedException e) {};
		}
		inUse = true;
	}

	public synchronized void off() {
		inUse = false;
		notify();
	}
}
