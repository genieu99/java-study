package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.SocketException;

public class ChatClientThread extends Thread {
	BufferedReader bufferedReader;
    
	public ChatClientThread(BufferedReader bufferedReader){
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run() {
        try {
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (SocketException e) {
            System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
