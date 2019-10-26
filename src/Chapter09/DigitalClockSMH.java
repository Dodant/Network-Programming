package Chapter09;

public class DigitalClockSMH {
	public static void main(String[] args) {

		SwitchSMH swtch1 = new SwitchSMH();
		SwitchSMH swtch2 = new SwitchSMH();

		HourSMH hour = new HourSMH(swtch2);
		MinuteSMH minute = new MinuteSMH(swtch1, swtch2);
		SecondSMH second = new SecondSMH(swtch1, minute, hour);

		Thread t1 = new Thread(second);
		Thread t2 = new Thread(minute);
		Thread t3 = new Thread(hour);

		t1.start();
		t2.start();
		t3.start();
	}
}

class SecondSMH implements Runnable {
	private int seconds = 58;
	private MinuteSMH min;
	private HourSMH hrs;
	private SwitchSMH swtch;

	public SecondSMH(SwitchSMH swtch, MinuteSMH minutes, HourSMH hours) {
		this.swtch = swtch;
		this.min = minutes;
		this.hrs = hours;
	}

	public void run() {
		while (true) {
			try {Thread.sleep(1000);}
			catch (InterruptedException e) {}
			if (seconds == 59) {
				System.out.println(toString());
				swtch.off();
				seconds = 0;
			} else {
				System.out.println(toString());
				seconds++;
			}
		}
	}
	public String toString() {
		int hr = hrs.getHours();
		int mn = min.getMinutes();
	
		StringBuilder sb = new StringBuilder();
		sb.append((hr/10 == 0 ? "0" + Integer.toString(hr) : hr) + " : ");
		sb.append((mn/10 == 0 ? "0" + Integer.toString(mn) : mn) + " : ");
		sb.append((seconds/10 == 0 ? "0" + Integer.toString(seconds) : seconds));
		return sb.toString();
		
	}
}

class MinuteSMH implements Runnable {
	private int minutes = 58;
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
			} else minutes++;
		}
	}
	public int getMinutes() { return minutes;}
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
			if (hours == 23) hours = 0;
			else hours++;
		}
	}
	public int getHours() { return hours;}
}

class SwitchSMH {
	private boolean inUse = true;

	public synchronized void on() {
		while (inUse) try {wait();} catch (InterruptedException e) {};
		inUse = true;
	}
	public synchronized void off() {
		inUse = false;
		notify();
	}
}
