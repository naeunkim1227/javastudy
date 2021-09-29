package prob2;


public class SmartPhone extends MusicPhone {

	@Override
	public void execute(String function) {
		if(function.equals("앱")) {
			app();
			return;
		}
		
		super.execute(function);
	}

	private void app() {
		System.out.println("앱을 실행합니다.");
	}
	

	
}
