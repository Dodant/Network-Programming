package Chapter09;

class CalcThread extends Thread {
	private double result;
	public void run(){
		result = calculate();
	}
	public double getResult(){
		return result;
	}
	public double calculate(){
		// calculate a value for "result"
		return 3.14;
	}
}
