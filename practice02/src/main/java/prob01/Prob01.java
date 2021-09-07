package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );
		int a = 0;
		
		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		/* 코드 작성 */
		System.out.print("금액 : ");
		a = scanner.nextInt();
		
		
		System.out.println(a);
		
		if(a-50000 >= 0) {
			
			int b = a/50000;
			System.out.println("50000원 : "+ b + "개");
			
			if(a-10000 >= 0) {
			System.out.println("10000원 : " + "개");
			}
			
			
		}
		
		
		scanner.close();
 	}
}