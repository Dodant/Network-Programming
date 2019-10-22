package Chapter09;

public class SleepAndInterrupt extends Thread{

	public static void main(String[] args) {
		Thread si = new Thread(new SleepAndInterrupt());
		si.run();
		si.interrupt();

	}
	public void run( ) {
		while (true) {
			try {
				Thread.sleep(3000); // 300milliseconds
			} catch (InterruptedException e) {
				System.out.println("자는 도중 인터럽트 발생 ");
				break;
			}
			System.out.println("실행 끝 ");
		}
	}
}
