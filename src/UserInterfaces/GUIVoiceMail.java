package UserInterfaces;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.sql.*;

import Adapter.SqliteConnection;
import BusinessLogic.ActualConnection;

public class GUIVoiceMail extends UserInterface {

	private JFrame frmTelephone;
	private JTextField textFieldSpeak;
	private JTextPane textFieldListen;
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnHashTag, btnH, btnSC;
	private ActualConnection conn;
	private String data = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIVoiceMail window = new GUIVoiceMail();
					window.frmTelephone.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	/**
	 * Create the application.
	 */
	public GUIVoiceMail() {
		initialize();
		connection = SqliteConnection.dbConnector(); 
	}
	
	public void speak(String output) {
		textFieldListen.setText(output);
	}
	
	 public void run(ActualConnection c) {
		 conn = c;
		 frmTelephone.setVisible(true);
		 buttonAction();
		
	}
	  
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelephone = new JFrame();
		frmTelephone.setTitle("Telephone");
		frmTelephone.setBounds(100, 100, 291, 396);
		frmTelephone.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelephone.getContentPane().setLayout(null);
		
		btn1 = new JButton("1");
		btn1.setBounds(10, 117, 77, 23);
		frmTelephone.getContentPane().add(btn1);
		
		btn2 = new JButton("2");
		btn2.setBounds(97, 117, 77, 23);
		frmTelephone.getContentPane().add(btn2);
		
		btn3 = new JButton("3");
		btn3.setBounds(184, 117, 77, 23);
		frmTelephone.getContentPane().add(btn3);
		
		btn4 = new JButton("4");
		btn4.setBounds(10, 151, 77, 23);
		frmTelephone.getContentPane().add(btn4);
		
		btn5 = new JButton("5");
		btn5.setBounds(97, 151, 77, 23);
		frmTelephone.getContentPane().add(btn5);
		
		btn6 = new JButton("6");
		btn6.setBounds(184, 151, 77, 23);
		frmTelephone.getContentPane().add(btn6);
		
		btn7 = new JButton("7");
		btn7.setBounds(10, 185, 77, 23);
		frmTelephone.getContentPane().add(btn7);
		
		btn8 = new JButton("8");
		btn8.setBounds(97, 185, 77, 23);
		frmTelephone.getContentPane().add(btn8);
		
		btn9 = new JButton("9");
		btn9.setBounds(184, 185, 77, 23);
		frmTelephone.getContentPane().add(btn9);
		
		btnHashTag = new JButton("#");
		btnHashTag.setBounds(10, 219, 77, 23);
		frmTelephone.getContentPane().add(btnHashTag);
		
		btn0 = new JButton("0");
		btn0.setBounds(97, 219, 77, 23);
		frmTelephone.getContentPane().add(btn0);
		
		btnH = new JButton("H");
		btnH.setBounds(184, 219, 77, 23);
		frmTelephone.getContentPane().add(btnH);
		
		btnSC = new JButton("Save Contact");
		btnSC.setBounds(10, 253, 116, 23);
		frmTelephone.getContentPane().add(btnSC);
		
		textFieldSpeak = new JTextField();
		textFieldSpeak.setBounds(14, 323, 251, 23);
		frmTelephone.getContentPane().add(textFieldSpeak);
		textFieldSpeak.setColumns(10);
		
		textFieldListen = new JTextPane();
		textFieldListen.setBounds(10, 11, 251, 95);
		frmTelephone.getContentPane().add(textFieldListen);
		
		
	}

	private void buttonAction() {
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText("");
				textFieldSpeak.setText("1");
				conn.dial(textFieldSpeak.getText());
				data+="1";
			}
		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText("");
				textFieldSpeak.setText("2");
				conn.dial(textFieldSpeak.getText());
				data+="2";
			}
		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText("");
				textFieldSpeak.setText("3");
				conn.dial(textFieldSpeak.getText());
				data+="3";
			}
		});
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText("");
				textFieldSpeak.setText("4");
				conn.dial(textFieldSpeak.getText());
				data+="4";
			}
		});
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText("");
				textFieldSpeak.setText("5");
				conn.dial(textFieldSpeak.getText());
				data+="5";
			}
		});
		
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText("");
				textFieldSpeak.setText("6");
				conn.dial(textFieldSpeak.getText());
				data+="6";
			}
		});
		
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText("");
				textFieldSpeak.setText("7");
				conn.dial(textFieldSpeak.getText());
				data+="7";
			}
		});
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText("");
				textFieldSpeak.setText("8");
				conn.dial(textFieldSpeak.getText());
				data+="8";
			}
		});
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText("");
				textFieldSpeak.setText("9");
				conn.dial(textFieldSpeak.getText());
				data+="9";
			}
		});
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText("");
				textFieldSpeak.setText("0");
				conn.dial(textFieldSpeak.getText());
				data+="0";
			}
		});
		btnHashTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText("");
				textFieldSpeak.setText("#");
				conn.dial(textFieldSpeak.getText());
				data+="#";
				textFieldSpeak.setText("");
			}
		});
		btnH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn.record(textFieldSpeak.getText());
				conn.hangup();
				try {
					String query ="INSERT INTO Messages (mailbox, message) VALUES ('" + data + "','" +textFieldSpeak.getText()+"')";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.executeUpdate();
					data="";
				} catch (Exception r) {
					JOptionPane.showMessageDialog(null, r);
				}
				textFieldSpeak.setText("");
			}
		});
		btnSC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn.record(textFieldSpeak.getText());
			}
		});
	}
}
