package prob05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Prob05 {
	
	
	static BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

	static int start;
	static int end;
	static int randomNum;
	static int count = 0;
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner( System.in );
		start = 1;
		end = 100;
		System.out.println("수를 결정하였습니다. 맞추어보세요");
		while( true ) {
			
			int randnum = generaterannum();
			
			System.out.println(start + "-" + end);
			
			int userAnswer = Integer.parseInt(bufferReader.readLine());
			
			if(randnum == userAnswer) {
				System.out.println("맞았습니다.");
				newGame();
			}else {
				if(userAnswer > randnum) {
					System.out.println("더 낮게");
					end = userAnswer < end? userAnswer:end;
					count++;
				}else if(userAnswer < randnum) {
					System.out.println("더 높게");
					start = userAnswer > start? userAnswer:start; 
					count++;
				}
				
			}
			
		
		}

	}

	private static int generaterannum() {
		return (int)(Math.random()*100);
	}


	private static boolean newGame() throws Exception {

		while (true) {
			System.out.print("다시 하겠습니까(y/n)>>");
			String answer = bufferReader.readLine();

			if (answer.equals("y")) {
				return true;
			} else if (answer.equals("n")) {
				return false;
			}
		}
	}

}