package prob04;
public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse( "Hello World" );
		
		char[] c2 = reverse( "Java Programming!" );
	}
	
	public static char[] reverse(String str) {
		/* 코드를 완성합니다 */
		
		int leng = str.length(); 
		
		for(int i=leng;i<0;i--) {
			char a[] = new char[leng];
			a[i] = str.substring(0, str.length()).charAt(i);
			System.out.println(a[i]);
		}
		
		
		return null;
	}

	public static void printCharArray(char[] array){
		/* 코드를 완성합니다 */
		System.out.println( array );
	}
}