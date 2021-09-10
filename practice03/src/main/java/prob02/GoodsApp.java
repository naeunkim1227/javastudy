package prob02;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("입력하세요");
		
		String line = scanner.nextLine();
		String s = "콜라 100 20";
		String[] tokens = s.split(" ");
		for(String ss : tokens) {
		System.out.println(ss);
		}
		line.split(" ");
		
		
		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		Goods good = new Goods();
		
		// 상품 출력
		
		// 자원정리
		scanner.close();
	}
}
