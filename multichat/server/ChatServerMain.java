package multichat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//채팅 서버 메인
public class ChatServerMain {
	int port;					//서버의 PORT 번호
	ServerSocket serverSocket;	//서버 소켓
	
	public static void main(String[] args) {
		ChatServerMain chatServer = new ChatServerMain(3333);
		chatServer.start();
	}
	
	public ChatServerMain(int port) {
		this.port = port;
	}
	
	public void start() {
		while (true) {
		}
	}
}
