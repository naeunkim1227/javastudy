package prob04;

public class StringUtil {
	public static String concatenate(String[] str) {

		String plus = "";
		for(int i=0;i<str.length;i++) {
			plus += str[i];
		}
		
		return plus;
	}
}
