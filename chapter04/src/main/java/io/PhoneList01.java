package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

public class PhoneList01 {

	public static void main(String[] args) {
		BufferedReader br = null;

		try {
			File file = new File("phone.txt");

			if (!file.exists()) {
				System.out.println("file not found");
				return;
			}

			System.out.println("====== 파일정보 ======");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "bytes");
			System.out.println(file.lastModified());
			
			System.out.println("====== 전화번호 ======");
			
			// 1. 기반 스트림(표준입력, stdin, System.in)
			FileInputStream fis = new FileInputStream(file);
			
			
			// 2. 보조 스트림1(byte|byte|byte > char)
			InputStreamReader isr = new InputStreamReader(System.in, "utf-8");

			// 3. 보조 스트림2(char1|char2|char3|char4|\n -> "char1char2char3char4")
			// br = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
			br = new BufferedReader(isr);
			
			//4.처리
			String line = null;
			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line,"\t");
				
				int index = 0;
				while(st.hasMoreElements()) {
					String token = st.nextToken();
					if(index == 0) { //이름
						System.out.println(token + ":");
					}else if(index == 2){
						System.out.println(token + "-");
					}else if(index == 3){
						System.out.println(token + "-");
					} else {
						System.out.println(token);
					}
					index++;
					
					System.out.println(token + "=");
				}
			}

		} catch (UnsupportedEncodingException e) {
			System.out.println("error:" + e);
		} catch (IOException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
