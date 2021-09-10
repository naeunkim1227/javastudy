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
		String[] tokens = line.split(" ");
		
		List<String> lineadd = null;
		
		System.out.println(tokens.length);
		for(int i=0;i<tokens.length;i++) {
			
			
		}
		
		
		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		Goods good = new Goods();
		
		// 상품 출력
		
		// 자원정리
		scanner.close();
	}
}
