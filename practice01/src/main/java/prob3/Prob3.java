package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요 : ");
		/* 코드 작성 */
		int a = scanner.nextInt();
		int sum = 0;
		
		if((a % 2)!=0){
			int i = 0;
			for(i=1;i<=a;i++) {
				sum += i;
				i++;
			}
			
			System.out.println("결과값 : " + sum);
			
		}else{
			int j = 0;
			for(j=2;j<=a;j++) {
				sum += j;
				j++;
			}
			System.out.println("결과값 : " + sum);
		}
		
		scanner.close();
	}
}
