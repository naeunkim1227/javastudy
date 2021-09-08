package mypackage;

public class Goods2 {
	//접근지정자 개념
	public String name; //접근 제한이 없다, 모두 접근 가능
	protected int price; //같은 패키지 + *자식 접근 가능
	int countStock;	// default > 같은 패키지 접근 가능
	private int countSold; //모든 외부 클래스 접근 제한
	
	
	void m() {
		countSold = 100;
	}
	
}
