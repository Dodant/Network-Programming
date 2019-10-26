package Chapter09;

class CalcThread extends Thread {
	private int[] arr;
	private double result;
	
	public CalcThread(int[] arr) {
		this.arr = arr;
	}
	public void run(){
		result = calculate();
	}
	public String toString() {
		return "Average is " + result;
	}
	public double calculate(){
		for (int i : arr) result += i;
		return result/arr.length;
	}
}
