package Chapter09;

class ShowJoin {
	public static void main(String[] args){
		int[] arr = new int[] {1,5,8,3,9,3,1,5,8,2,1};		
		CalcThread calc = new CalcThread(arr);
		calc.start();
		
		try{
			calc.join();	// main이 calc를 기다림 
			System.out.println(calc.toString());
		} catch (InterruptedException e){
			System.out.println("조인 중에 인터럽 됨");
		}
	}
}
