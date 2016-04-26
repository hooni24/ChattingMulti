package multichat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//채팅 서버 메인
public class ChatServerMain {
	int port;					//서버의 PORT 번호
	ServerSocket serverSocket;	//서버 소켓
	Socket client;				//클라이언트 접속하면 생성되는 소켓
	
	public static void main(String[] args) {
		ChatServerMain chatServer = new ChatServerMain(3333);
		chatServer.start();
	}
	
	public ChatServerMain(int port) {
		this.port = port;
	}
	
	public void start() {		//서버소켓 생성, 접속대기, 서버 스레드 생성(만들어진 소켓or 스트림 넘김), 스레드 실행
		System.out.println("server opened!");
		try {
			serverSocket = new ServerSocket(port);			//포트는 처음 한 번만 만들고, 그 다음부터는 accept대기만 하면 된다.
		} catch (IOException e1) {	}
		
		while (true) {
			try {
				System.out.println("waiting for clients..");
				client = serverSocket.accept();
				System.out.println("Client connected!!" + client.getInetAddress());
			} catch (IOException e) {	}
			Thread th = new Thread(new ChatServerThread(client));
			th.start();
		}//while
	}//start()
}//class
