package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class FileReaderTest {

	public static void main(String[] args) {
		Reader in = null;
		Writer out = null;
		try {
			in = new FileReader("1234.txt");
			
			int data = -1;
			int count = 0;
			while((data = in.read()) != -1) {
				System.out.print((char)data);
				count++;
			}
			System.out.println();
			System.out.println(count);
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found :" + e);
		}catch (IOException e) {
				System.out.println("error :" + e);
			}finally {
			
			try {
				if(in != null) {
				in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
