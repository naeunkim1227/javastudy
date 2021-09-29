package prob02;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("입력하세요");
		
		Goods[] goods = new Goods[COUNT_GOODS];

		
		
		for(int i=0;i<COUNT_GOODS;i++) {
			String line = scanner.nextLine();
			String[] tokens = line.split(" ");
			String drink = tokens[0];
			int money = Integer.parseInt(tokens[1]);
			int count = Integer.parseInt(tokens[2]);
			
			Goods good = new Goods();
			good.setCount(count);
			good.setDrink(drink);
			good.setMoney(money);
			
			goods[i] = good;
			
		}
		
		for(Goods g:goods) {
			System.out.println(g.getDrink() + "(가격:" + g.getMoney() + "원)이 " + g.getCount() +"개 입고 되었습니다." );
		}
		
		// 상품 출력
		
		// 자원정리
		scanner.close();
	}
}
