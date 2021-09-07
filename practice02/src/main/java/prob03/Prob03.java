package prob03;

public class Prob03 {
	public static void main(String args[]) {
		char c[] = { 'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'p', 'e', 'n', 'c', 'i', 'l', '.' };

		// 원래 배열 원소 출력
		printCharArray(c);

		// 공백 문자 바꾸기
		replaceSpace(c);

		// 수정된 배열 원소 출력
		printCharArray(c);
		
		
		
	}
	
	
	static void printCharArray(char[] c) {
		System.out.println(c);
		
	}
	
	static void replaceSpace(char[] c) {
		String tostr = String.valueOf(c);
		tostr = tostr.replaceAll(" ", ",");
		System.out.println(tostr);
		
		}
		
	}
	
	

