package prob5;

import java.util.Arrays;

public class Prob5 {

	public static void main(String[] args) {
		for (int i = 1; i < 100; i++) {
			float a = i / 10f;
			String str = a + "";

			String ten = str.substring(0, 1);
			String one = str.substring(2, 3);
			StringBuilder clap = new StringBuilder();
			
			
			if(one.contains("3") || one.contains("6") || one.contains("9")) clap.append("짝");
			
			if (ten.contains("3") || ten.contains("6") || ten.contains("9")) clap.append("짝");
			
			if (clap.length() != 0) {
				System.out.print(i);
			System.out.println(" " + clap);
			}
		
		}

	}// main
}
