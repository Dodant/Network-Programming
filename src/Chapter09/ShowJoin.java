package Chapter09;

class ShowJoin {
	public static void main(String[] args){
		CalcThread calc = new CalcThread();
		calc.start();
		doSomethingElse();
		try{
			calc.join();
			System.out.println("Result is " + calc.getResult());
		} catch (InterruptedException e){
			System.out.println("조인 중에 인터럽 됨");
		}
	}
	static void doSomethingElse(){
	}
}
