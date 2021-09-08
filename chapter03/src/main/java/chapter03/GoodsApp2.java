package chapter03;

import mypackage.Goods2;

public class GoodsApp2 {

	public static void main(String[] args) {
		Goods2 g = new Goods2();
		
		g.name = "camera"; //public  :접근 제한이 없다
		//g.price = 1000; //protected : 같은 패키지내 접근이 가능하다., 자식에서도 접근이 가능하다.
		//g.countStock = 10; //default : 같은 패키지내 접근 가능하다.
		//private: g.countSold 접근 불가능하다.
		
		
	}

}
