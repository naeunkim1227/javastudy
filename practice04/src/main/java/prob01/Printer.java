package prob01;

public class Printer {
	/*
	
	public void println(int i){
		System.out.println(i);
		
	}
	
	public void println(double i){
		System.out.println(i);
		
	}
	
	public void println(boolean i){
		System.out.println(i);
		
	}
	
	public void println(String i){
		System.out.println(i);
		
	}
	
	*/
	
	//제네릭 메소드로 해결하는 방법
	public <T> void println(T t) {
		System.out.println(t);
	}
	public <T> void println(T... ts) {
		for(T t : ts) {
			System.out.println(t);
		}
	}

	public int sum(Integer... nums) {
		int sum = 0;
		for(Integer i :nums) {
			sum += i;
		}
		return sum;
	}
}
