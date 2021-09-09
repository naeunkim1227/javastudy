package prob5;

import java.util.Arrays;

public class Prob5 {

	public static void main(String[] args) {
		 String[] arr = new String[100];
		 String[] arr2 = new String[100];
		 float d[] = new float[100];
		int i = 0;
		
	 for(i=0;i<100;i++){
		 
		d[i] = i/10f;
		arr[i] = d[i] + " ";
		
		System.out.println(arr[i].charAt(i));
		 
		 /*
		 if(arr[i].contains("3") || arr[i].contains("6") || arr[i].contains("9")) {
			 System.out.println(i + " 짝");
		 }*/
	 
	 }
	 
	 
	}
}
