package multichat.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import multichat.common.Data;

public class ChatClientMain extends JFrame implements ActionListener, Runnable {
	String ip;
	int port;
	String username;
	
	Socket socket;
	ObjectInputStream input;
	ObjectOutputStream output;
	
	JTextArea outputText;		//채팅 내용 출력창
	JScrollPane scroll;			//채팅 내용창 스크롤바
	JTextField inputText;		//채팅 내용 입력창
	JList<String> userList;		//채팅 참여자 목록
	
	public static void main(String[] args) {
	}

	public ChatClientMain(String ip, int port) {
		this.ip = ip;
		this.port = port;
		
		//채팅창 생성
		createUI();
		//창 닫을 때 서버 접속 종료
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				disconnect();
			}
		});
		
		//대화명 입력 대화상자
		UsernameDialog dialog = new UsernameDialog(this);
		dialog.setVisible(true);
		setTitle("채팅 (" + username + ")");
		
		connect();
	}
	
	//채팅 화면 구성
	public void createUI() {
		setBounds(300, 300, 400, 500);
		
		outputText = new JTextArea();
		outputText.setLineWrap(true);

		scroll = new JScrollPane(outputText);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		inputText = new JTextField();
		inputText.addActionListener(this);
		
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label = new JLabel("[ 채팅 참여자 ]");
		
		userList = new JList<String>();
		
		add(scroll);
		add(inputText, BorderLayout.SOUTH);
		add(panel, BorderLayout.EAST);
		panel.add(label, BorderLayout.NORTH);
		panel.add(userList);
		
		setVisible(true);
	}

	//대화내용 출력창에 메세지 출력
	public void output(String msg) {
	}
	
	//서버 접속
	public void connect() {
	}
	
	//서버 접속 종료
	public void disconnect() {
		
	}
	
	//입력 이벤트 처리
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	//서버로부터의 전송 대기
	@Override
	public void run() {
		Data data = null;
		int state = 0;
		String name = null;
		String message = null;
		
		while (true) {
			
		}		
	}
}
