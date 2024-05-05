package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Base64;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		
		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);
			
			// 2. socket 생성
			socket = new Socket();
			
			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			
			// 4. reader/writer 생성
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
			// 5.join 프로토콜
			System.out.print("닉네임>> ");
			String nickname = scanner.nextLine();
			printWriter.println("join:" + nickname);
			printWriter.flush();
			
			// 6. ChatClientReceiveThread 시작
			new ChatClientThread(bufferedReader).start();
			
			// 7. 키보드 입력 처리
			while (true) {
				String input = scanner.nextLine();
				String encodedMessage = Base64.getEncoder().encodeToString(input.getBytes("utf-8"));
				
				if ("quit".equals(input) == true) {
					// 8. quit 프로토콜 처리
					printWriter.println("quit:");
					printWriter.flush();
					break;
				} else {
					// 9. 메시지 처리
					printWriter.println("message:" + encodedMessage);
					printWriter.flush();
				}
			}
		} catch (IOException e) {
			log("error: " + e);
		} finally {
			// 10. 자원정리
			try {
				if (scanner != null) {
					scanner.close();
				}
				
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void log(String message) {
		System.out.println("[Client#" + Thread.currentThread().getId()  + "] " + message);
	}

}
