package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

   public static void main(String[] args) {
      ServerSocket serverSocket = null;
      try {
         //1. 서버소켓 생성
         serverSocket = new ServerSocket();
         
         //2. 바인딩(binding)
         //Socket에 InetSocketAddress(IPAddress + port)
         // IPAderess : 0.0.0.0 : 모든 IP로 부터의 연결을 허용
         serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000));
         
         //3.accept
         //클라이언트로 부터 연결 요청을 기다린다.
         Socket socket = serverSocket.accept(); //blocking
         
         InetSocketAddress inetRemoteSocketAddress =  (InetSocketAddress)socket.getRemoteSocketAddress();
         //다운캐스팅 해주기
         String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
         int remoteHostPort = inetRemoteSocketAddress.getPort();
         
         System.out.println("[server] connected by client[" + remoteHostAddress+ ":" +
         remoteHostPort + "]");
         
         try {
         //4. IO Stream 받아오기
         InputStream is =  socket.getInputStream();
         OutputStream os = socket.getOutputStream();
        
         while(true) {
        	 //5. 데이터 읽기
        	 byte[] buffer = new byte[256];
        	 int readByteCount = is.read(buffer);
        	 if(readByteCount == -1) {
        		 //반대편(클라이언트)이 정상적으로 종료되었다.(close() 호출) 
        		 System.out.println("[server] closed by client");
        		 break;
        	 }
        	 
        	 String data = new String(buffer,0,readByteCount,"utf-8");
        	 System.out.println("[server] received"+ data);
        	 
        	 
        	 //6.데이터 쓰기
        	 os.write(data.getBytes("utf-8"));
        	
        	 
        	 
        	 
        	 
         }
         }catch(SocketException e) {
        	 //InputStream is =  socket.getInputStream(); 에 대한 예외
        	 System.out.println("[server] suddenly closed by client" + e);
         }catch(IOException e) {
        	 //InputStream is =  socket.getInputStream(); 에 대한 예외
        	 System.out.println("[server] error" + e);
         }finally {
        	 
        	try {
        		if(socket != null && socket.isClosed() == false) {
        			socket.close();
        		}
			} catch (Exception e2) {
				// TODO: handle exception
			}
        	 
		}
        //////데이터 소켓 관련 
         
         
         ////서버 소켓관련
      } catch (IOException e) {
         System.out.println("[server error] "  + e);
      } finally {
         try {
            if(serverSocket != null && serverSocket.isClosed() == false) {
               serverSocket.close();
            }
         } catch (IOException e) {
            e.printStackTrace();
         }finally {
			
		}
      }


   }

}