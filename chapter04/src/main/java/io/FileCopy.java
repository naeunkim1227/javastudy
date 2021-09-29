package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {

	public static void main(String[] args) throws IOException {

		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("moo.jpg");
			os = new FileOutputStream("moo.copy.jpg");
			//is.read()
			
			int data = -1;
			
			while((data=is.read()) != -1) {
				os.write(data);
			}

		} catch (FileNotFoundException e) {
			System.out.println("file not found :" + e);
		} finally {
			try {
				if(is != null) {
				is.close();
				}
				if(os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
