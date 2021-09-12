package prob3;

public class Sparrow extends Bird {
	private String sparrow = "참새";

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}

	@Override
	public void fly() {
		System.out.println(sparrow + "(" + name + ")가 날아다닙니다.");
	}

	@Override
	public void sing() {
		System.out.println(sparrow + "(" + name + ")가 소래내어 웁니다.");
	}

	@Override
	public String toString() {
		return "참새의 이름은 " + name + "입니다.";
	}
	
	
}
