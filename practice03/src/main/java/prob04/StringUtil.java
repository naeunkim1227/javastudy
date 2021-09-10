package prob04;

public class StringUtil {
	public static String cocatenate(String[] str) {
		
		StringBuilder add = null;
		for(int i=0;i<str.length;i++) {
			add.append(str[i]);
		}
		
		return add.toString();
	}
}
