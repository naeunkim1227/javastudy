package prob4;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");
		String text = scanner.nextLine();
		
		String test = "";
		for(int i=0;i<text.length();i++) {
			test += text.charAt(i);
			System.out.println(test);
			Thread.sleep(1000);
		}
	
		scanner.close();
	}

}
