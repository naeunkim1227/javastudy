package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private static final int PORT = 6000;

	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		// 서버 소켓과 소켓의 다른점???
		try {
			serverSocket = new ServerSocket();

			// 소켓 어드레스 = ip + 포트
			// 바인딩 작업

			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("starts... [port:" + PORT + "]");

			Socket socket = serverSocket.accept();

			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			// 다운캐스팅 해주기
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetRemoteSocketAddress.getPort();

			log("[server] connected by client[" + remoteHostAddress + ":" + remoteHostPort + "]");

			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
				// true 작성 > 자동으로 flush 실행
				while (true) {
					String data = br.readLine();
					if (data == null) {
						log("closed by client");
						break;
					}

					log("received:" + data);
					pw.println(data);
				}
			} catch (IOException e) {
				log("error:" + e);
			} finally {
				try {
					if (socket != null && socket.isClosed() == false) {
						socket.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			log("error: " + e);
		} finally {
			try {
				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void log(String log) {
		System.out.println("[EchoServer] " + log);
	}
}