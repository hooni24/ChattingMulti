package multichat.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import multichat.common.Data;

public class ChatServerThread implements Runnable {
	public static ArrayList<ChatServerThread> chatList = new ArrayList<ChatServerThread>();		//접속중인 클라이언트 목록
	public static ArrayList<String> usernames = new ArrayList<String>();		//접속자 이름 목록
	
	Socket socket;
	ObjectInputStream input;
	ObjectOutputStream output;
	String username;
	String addr;
	
	
	public ChatServerThread(Socket socket) {
	}

	//클라이언트로부터의 전송을 기다림.
	@Override
	public void run() {
		
		while (true) {
		}
	}

	//전체 접속자에게 전송
	public void broadCasting(Data data) {
	}
	
}
