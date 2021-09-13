package prob05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Prob6 {
	
static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	
	static int randNum;
	static int start;
	static int end;
	
	private static void initProperties() {
		start = 1;
		end = 100;
	}
	
	public static void main(String args[]) throws Exception {
		while(true) {
			initProperties();
			randNum = generateRandomInteger();
			System.out.println("수를 결정하였습니다. 맞추어 보세요");
			
			if(!answerLoop()) {
				return;
			}
		}
	}
	
	private static int generateRandomInteger() {
		return (int)( Math.random() * 100);
	}
	
	private static boolean answerLoop() throws Exception {
		
		while(true) {
			System.out.println(start + "-" + end);
			int userAnswer = Integer.parseInt(bufferedReader.readLine());
			
			if(!isWrong(userAnswer)) {
				System.out.println("맞았습니다.");
				return askQuestion() ? true : false;
			}
		}
	}
	
	private static boolean isWrong(int userAnswer) {
		if(randNum != userAnswer) {
			if(userAnswer > randNum) {
				System.out.println("더 낮게");
				end = userAnswer < end ? userAnswer : end;
			}
			if(userAnswer < randNum) {
				System.out.println("더 높게");
				start = userAnswer > start ? userAnswer : start;
			}
			return true;
		}
		return false;
	}
	
	private static boolean askQuestion() throws Exception {
		
		while(true) {
			
			System.out.print("다시하시겠습니까?(y/n)>>");
			String userAnswer = bufferedReader.readLine();
			String revisedAnswer = userAnswer.toLowerCase();
			
			if(revisedAnswer.equals("y")) {
				return true;
			}
			if(revisedAnswer.equals("n")) {
				return false;
			}
		}
	}
}