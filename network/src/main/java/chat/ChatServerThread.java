package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;

import echo.EchoServer;

public class ChatServerThread extends Thread {

	private String nickname;
	private Socket socket;

	public ChatServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		InetSocketAddress inetremoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		String remoteHostAddress = inetremoteSocketAddress.getAddress().getHostAddress();
		int remoteHostport = inetremoteSocketAddress.getPort();
		EchoServer.log("connected by client[" + remoteHostAddress + ":" + remoteHostport + "]");

		try {
			// IO 생성
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			// 파일 읽어오기
			while (true) {
				String request = reader.readLine();
				if (request == null) {
					ChatServer.log("closed by client");
					break;
				}

				ChatServer.log("received:" + request);

				// 읽어온 데이터를 출력
				writer.println(request);
			}

		} catch (UnsupportedEncodingException e) {
			ChatServer.log("error" + e);
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
		}

	}

}
