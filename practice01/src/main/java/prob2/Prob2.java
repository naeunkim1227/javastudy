package prob2;

public class Prob2 {
	public static void main(String[] args) {
		/* 코드 작성 */
		int k = 1;
		int j;
		for(int i=0;i<10;i++) {
			
				for(j=k;j<10+k;j++) {
					System.out.print(j + " ");
				}
			System.out.println("");
			k++;
		}
		
	}
}
