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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Base64;

import chat.ChatClientThread;
import chat.ChatServer;

public class ChatWindow {
	
	private static final String SERVER_IP = "127.0.0.1";

	private String nickname;
	private Socket socket;
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private BufferedReader bufferedReader;
    private PrintWriter printWriter;

	public ChatWindow(String name, Socket socket) {
		this.nickname = name;
		this.socket = socket;
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.BLACK);
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
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
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
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		// IOStream 받아오기
		try {
			socket = new Socket(SERVER_IP, ChatServer.PORT);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
            printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
            
            printWriter.println("join:" + nickname);
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		// ChatClientThread 생성
		new ChatClientThread(bufferedReader).start();
	}
	
	private void sendMessage() {
		try {
			String message = textField.getText();
			String encodedMessage = Base64.getEncoder().encodeToString(message.getBytes("utf-8"));
			
			if (encodedMessage.isEmpty()) {
				return;
			} else if ("quit".equals(message)) {
				printWriter.println("quit:");
		        printWriter.flush();
		        System.exit(0);
			}
			System.out.println("메세지 보내는 프로토콜을 구현!: " + message);
			
			printWriter.println("message:" + encodedMessage);
	        printWriter.flush();
			
			textField.setText("");
			textField.requestFocus();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	private void finish() {
		// quit protocol 구현
		printWriter.println("quit:");
        printWriter.flush();
        
        System.exit(0);
		
		// exit java application
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	private class ChatClientThread extends Thread {
		BufferedReader bufferedReader;
	    
		public ChatClientThread(BufferedReader bufferedReader){
	        this.bufferedReader = bufferedReader;
	    }

	    @Override
	    public void run() {
	        try {
	            String line = null;
	            while((line = bufferedReader.readLine()) != null) {
	            	updateTextArea(line);
	            }
	        } catch (SocketException e) {
	            System.out.println("");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
}
