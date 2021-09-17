package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPEchoClient {

	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = UDPEchoServer.PORT;
	public static final int BUFFER_SIZE = UDPEchoServer.BUFFER_SIZE;
	
	public static void main(String[] args) {
		DatagramSocket socket = null;
		Scanner scanner = null;
		
		try {
			//1. Scanner 생성
			scanner = new Scanner(System.in);
			
			//2. Socket 생성
			//포트 번호는 에코서버에서 가져오기
			socket = new DatagramSocket();
			
			while(true) {
				System.out.print(">");
				String line = scanner.nextLine();
				
				if("exit".equals(line)) {
					break;
				}
				
				
				//예외 처리 필요함
				//데이터 보내기
				byte[] sndData = line.getBytes("utf-8");
				
				//보내는 패킷
				DatagramPacket sndPacket  = new DatagramPacket(
						sndData,
						sndData.length,
						new InetSocketAddress(SERVER_IP,SERVER_PORT));
				socket.send(sndPacket);
				
				
				//데이터 받기
				DatagramPacket rcvPacket = new DatagramPacket(new byte[BUFFER_SIZE],BUFFER_SIZE);
				socket.receive(rcvPacket); // blocking
				
				byte[] rcvData= rcvPacket.getData();
				int length = rcvPacket.getLength();
				String message = new String(rcvData,0,length,"utf-8");
				
				System.out.println("<" + message);
				
			}
			
			
		} catch (IOException e) { //소켓, 인코딩 예외처리
			System.out.println("error :" + e);
		}finally {
			if(scanner != null) {
				scanner.close();
			}
			if(socket != null && socket.isClosed() == false) {
				socket.close();
			}
		}
		 
		
		
	}

}
