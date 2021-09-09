package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods goods = new Goods();
		
		goods.setName("Nicon");
		goods.setPrice(2000);
		goods.setCountStock(10);
		goods.setCountSold(20);
		goods.showInfo();
		
		System.out.println(Goods.CountOfGoods);
		
		
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		String s = "콜라 100 20";
		String[] tokens = s.split(" ");
		for(String ss : tokens) {
			System.out.println(ss);
		}
		
		
		
	}

}
