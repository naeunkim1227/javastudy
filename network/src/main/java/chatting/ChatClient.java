package chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import chat.ChatServer;

public class ChatClient {

	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 9999;
	static Scanner scanner = null;

	public static void main(String[] args){

		Socket socket = null;
		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);
			// 2. socket 생성
			socket = new Socket();

			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

			// 4. reader/writer 생성
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

			// 5. join 프로토콜
			writer.println("join:" + join());
			writer.flush();

			// 6. chatClientReceive Thread 시작
			ChatClientThread chatClientreceivethread = new ChatClientThread(socket, reader, writer);
			chatClientreceivethread.start();

			// 7. 키보드 입력 처리
			while (true) {
				System.out.print(">>");
				String input = scanner.nextLine();

				if ("quit".equals(input) == true) {
					// 8. quit 프로토콜 처리
					writer.println("quit");
					break;
				} else {
					// 9.메세지 처리
					writer.println("message:" + input); // 안끝냇으니깐 input에 내가 적은거 출력되게
				}
			}
		} catch (IOException e) {
			ChatServer.log("error:" + e);
		} finally {
			
			if (socket != null && socket.isClosed() == false) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (scanner != null) {
				scanner.close();
			}

		}

	}

	private static String join() {
		String nickname;
		while(true) {
		System.out.println("닉네임을 입력해주세요!");
		System.out.print("닉네임>>");
		nickname = scanner.nextLine();
		if ("".equals(nickname) == false) {
			break;
		}
		
		}
		return nickname;
		}

	private static void log(String logString) {
		System.out.println(logString);
	}
}