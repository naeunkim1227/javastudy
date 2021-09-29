package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {

	public static final int PORT = 7000;
	public static final int BUFFER_SIZE = 1024;
	
	public static void main(String[] args) {
		DatagramSocket socket = null;

		try {
			//1.소켓 생성
			socket  = new DatagramSocket(PORT);
			
			while(true) {
			
			//2.데이터 수신
			DatagramPacket rcvPacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
			//읽어야하는 버퍼 넣기, 버퍼 사이즈 설정(편지봉투 안에 편지 넣기)
			
			socket.receive(rcvPacket); //blocking
			//안에 패킷을 하나 넣어서, 기다려 주면 , 데이터가 복사가 되서 읽을 수 있다.
			
			rcvPacket.getData();
			//패킷안에 있는 데이터를 해석 해주기 위해 꺼내줘야 한다.
			
			
			//디코딩을 위해 수행하는 작업
			byte[] rcvData = rcvPacket.getData();
			int length = rcvPacket.getLength();
			String message = new String(rcvData,0,length,"utf-8");
			
			
			
			System.out.println("[server] receive:" + message);

			//3.데이터 송신
			
			//센드 테이터 만들기
			byte[] sndData = message.getBytes("utf-8");
			
			DatagramPacket sndPacket = new DatagramPacket(sndData, sndData.length,rcvPacket.getAddress(),rcvPacket.getPort());
			//받는 패킷 
			//보내는 데이터,데이터 길이, 보내는 사람 주소, 포트 넣어주기
			//rcvPacket.getAddress() 보내는 사람의 주소
			//rcvPacket.getPort() 보내는 사람의 포트
			
			//소켓에서 보내주기
			socket.send(sndPacket);
			
			}
			
			
		} catch (SocketException e) {
			System.out.println("error:" + e);
		}catch (IOException e) {
			System.out.println("error:" + e);
		}finally {
			if(socket != null && socket.isClosed() == false) {
				socket.close();
			}
		}
		
		
	}

}
