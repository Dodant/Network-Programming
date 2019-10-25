package Chapter08_CallBack;

public class SumThreadInterface {

	public void printResult(int n, int sum) {
		System.out.println("input number : " + n);
		System.out.println("sum : " + sum);
		
	}
	public static void main(String[] args) {
		SumThread st = new SumThread(10, new SumThreadInterface());
		st.start();
	}
}
