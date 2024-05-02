package chat;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		
		try {
			// 1. 키보드 연결
			
			// 2. socket 생성
			
			// 3. 연결
			
			// 4. reader/writer 생성
			
			// 5.join 프로토콜
			System.out.print("닉네임>> ");
			String nickname = scanner.nextLine();
			printWriter.println("join" + nickname);
			printWriter.flush();
			
			// 6. ChatClientReceiveThread 시작
			
			// 7. 키보드 입력 처리
			while (true) {
				System.out.print(">>");
				String input = scanner.nextLine();
				
				if ("quit".equals(input) == true) {
					// 8. quit 프로토콜 처리
					break;
				} else {
					// 9. 메시지 처리
				}
			}
		} catch (IOException e) {
			log("error: " + e);
		} finally {
			// 10. 자원정리
		}
	}
	
	public static void log(String message) {
		System.out.println("[Client#" + Thread.currentThread().getId()  + "] " + message);
	}

}
