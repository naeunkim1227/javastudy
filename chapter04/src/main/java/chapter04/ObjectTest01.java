package chapter04;


public class ObjectTest01 {

	public static void main(String[] args) {
		Point p = new Point(10,20);
		
		//Class klass = p.getClass();
		
		
		System.out.println(p.getClass());
		System.out.println(p.hashCode()); //address기반의 해싱값, address X, reference x
		System.out.println(p.toString()); //getClass() + "@" + hashcode()
		System.out.println(p);
	}

}
