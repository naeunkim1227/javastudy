package chapter03;

public class StudentTest {

	public static void main(String[] args) {
		Student s1 =  new Student();
		s1.setGrade(1);
		s1.setMajor("cs");
		s1.setName("둘리");
		
		Person p1 = s1; //upcasting(암시적, Implicity)
		p1.setName("둘리");
		
		
		Student s2 =(Student)p1; //downcasting(명시적, explicity)
		s2.setMajor("cs");
		
		//p1.setMajor("cs"); 는 되지 않는다. person클래스에는 있지 않은 메소드임.
		
		
		
		
		
	}

}
