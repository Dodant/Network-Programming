package Chapter08_CallBack;

public class SumThread extends Thread{

	private int n;
	private int sum;
	private SumThreadInterface sti = null;
	
	public SumThread(int n, SumThreadInterface sti) {
		this.n = n;
		this.sum = 0;
		this.sti = sti;
	}
	
	public void run() {
		for (int i = 1; i <= n; i++) sum += i;
		sti.printResult(n, sum);
	}
}
