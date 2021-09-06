package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("숫자를 입력하세요 : ");
		/* 코드 작성 */
		int a = 0;
		a = scanner.nextInt();
		int sum = 0;
		
		if((a % 2)!=0){
			for(int i=1;i<=a;i++) {
				System.out.print(i);
				i++;
			}
			
			
		}else{
			for(int j=2;j<=a;j++) {
				System.out.print(j);
				j++;
			}
		
		}
		
		scanner.close();
	}
}
