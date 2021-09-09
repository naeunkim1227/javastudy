package prob02;

import java.util.Arrays;
import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("입력하세요");
		
		String line = scanner.nextLine();
		
		String[] datas = line.split(" ");
		
		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		Goods good = new Goods();
		
			for(String data: datas) {
				System.out.print(data);
			}
		// 상품 출력
		
		// 자원정리
		scanner.close();
	}
}
