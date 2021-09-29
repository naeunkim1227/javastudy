package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name) {
		//윈도우 창
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}
	
	public void show() {
	
		/* 1. UI 초기화 */
		
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		
		//람다식
		//buttonSend.addActionListener((e) ->System.out.println("click"));
		
		
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});
		
		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				char keycode = e.getKeyChar();
				if(keycode == KeyEvent.VK_ENTER) {
					//엔터키를 눌렀을때 샌드메세지 함수 실행 
					sendMessage();
				}
			}
			
		
		});
		

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		
		//2.IOStream 가져오기
		
		//3.Chat Client Thread 생성
		/* 스레드를 내부 클래스로 만들어 놔야 좋다.
			
		
		*/
		
		
	}
	
	private void sendMessage() {
		String message = textField.getText();
		System.out.println("메세지 보내는 프로토콜 구현:" + message);
		textField.setText("");
		textField.requestFocus();
		
		
		//Receive Thread에서 서버로 부터 받은 메세지가 있다고 치고
		updateTextArea("마이콜: " + message);
		//가짜 데이터
	}
	
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	
	private void finish() {
		System.out.println("소켓 닫기 or 방 나가기 프로토콜 구현");
		System.exit(0);
	}
	
	
	private class ChatClientThread extends Thread{
		//부모 메소드 접근에 편하기 때문에 이너클래스로 만들어 주자
		public void run() {
			updateTextArea("......");
		}
		
	}
	
	
}
