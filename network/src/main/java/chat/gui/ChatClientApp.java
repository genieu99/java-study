package chat.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import chat.ChatServer;

public class ChatClientApp {

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = new Socket();
		
		while( true ) {		
			System.out.println("닉네임을 입력하세요.");
			System.out.print(">> ");
			name = scanner.nextLine();
			
			if (!name.isEmpty()) {
				break;
			}
			System.out.println("닉네임은 한글자 이상 입력해야 합니다.\n");
		}

		new ChatWindow(name, socket).show();
	}

}
