package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class EchoClient {

	private static final String SERVER_IP = "127.0.0.1";
	private static final int PORT = 6000;

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		//close 해주기 위해 따로 선언
		
		try {
			scanner = new Scanner(System.in); //스캐너 생성
			socket = new Socket(); //소켓 생성
			//연결
			socket.connect(new InetSocketAddress(SERVER_IP,PORT));
			
			log("connected");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			// true 작성 > 자동으로 flush 실행
			
			while (true) {
				System.out.print(">");
				String line = scanner.nextLine();

				if ("exit".equals(line)) {
					break;
				}
				
				pw.println(line);
				
				String data = br.readLine();
				
				if(data == null) {
					log("closed by server");
					break;
				}
				
				System.out.println("<" + data);
				
				
			}
		} catch (SocketException e) {
			//서버가 끊겼을 때의 예외 처리
			log("suddenly closed by server" + e);
		}catch (IOException e) {
			log("error :" + e);
		}finally {
			try {
				if(scanner != null) {scanner.close();}
				if(socket != null && socket.isClosed() == false) {
				socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static void log(String log) {
		System.out.println("[Echo Client]" + log);
	}

}
