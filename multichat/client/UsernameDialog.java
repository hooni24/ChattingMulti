package multichat.client;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class UsernameDialog extends JDialog implements ActionListener {
	ChatClientMain chatClient;
	JLabel label;
	JTextField text;
	JButton bt;
	
	public UsernameDialog(ChatClientMain chatClient) {
		super(chatClient, "대화명 입력", true);
		this.chatClient = chatClient;
		setBounds(350, 350, 200, 100);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		label = new JLabel("대화명");
		text = new JTextField(10);
		bt = new JButton("확인");
		bt.addActionListener(this);
		
		setLayout(new GridLayout(2, 1));
		JPanel p = new JPanel();
		add(p);
		add(bt);
		p.add(label);
		p.add(text);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				inputUsername();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		inputUsername();
	}
	
	
	public void inputUsername() {
		String username = text.getText();
		if (username.isEmpty()) {
			JOptionPane.showMessageDialog(this, "대화명을 입력해주세요.");
			return;
		}
		chatClient.username = username;
		this.dispose();
	}
}
