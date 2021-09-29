package prob3;

public class Duck extends Bird {
	private String duck = "오리";
	
	
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
		System.out.println(duck +"(" + name + ")는 날지 않습니다.");
	}

	@Override
	public void sing() {
		System.out.println(name + "는 소리내어 웁니다.");
	}



	@Override
	public String toString() {
		return "오리의 이름은 " + name + "입니다.";
	}

	
	

	
	
}
