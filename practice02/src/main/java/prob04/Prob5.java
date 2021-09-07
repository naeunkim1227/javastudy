package prob04;
public class Prob5 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		printCharArray( c1 );
		
		char[] c2 = reverse( "Java Programming!" );
		printCharArray( c2 );
	}
	
	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
		String a = str.substring(0, str.length());
		
		for(int i=str.length();i<=0;i--){
			
		}
		
		
		return null;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		System.out.println( array );
	}
}