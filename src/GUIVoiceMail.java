import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;

public class GUIVoiceMail {

	private JFrame frmTelephone;
	private JTextField textFieldListen;
	private JTextField textFieldSpeak;
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnHashTag, btnH, btnQ;
	private static final int MAILBOX_COUNT = 20;

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

	/**
	 * Create the application.
	 */
	public GUIVoiceMail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelephone = new JFrame();
		frmTelephone.setTitle("Telephone");
		frmTelephone.setBounds(100, 100, 291, 312);
		frmTelephone.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelephone.getContentPane().setLayout(null);
		
		textFieldListen = new JTextField();
		textFieldListen.setBounds(10, 11, 251, 46);
		frmTelephone.getContentPane().add(textFieldListen);
		textFieldListen.setColumns(10);
		
		btn1 = new JButton("1");
		btn1.setBounds(10, 68, 77, 23);
		frmTelephone.getContentPane().add(btn1);
		
		btn2 = new JButton("2");
		btn2.setBounds(97, 68, 77, 23);
		frmTelephone.getContentPane().add(btn2);
		
		btn3 = new JButton("3");
		btn3.setBounds(184, 68, 77, 23);
		frmTelephone.getContentPane().add(btn3);
		
		btn4 = new JButton("4");
		btn4.setBounds(10, 102, 77, 23);
		frmTelephone.getContentPane().add(btn4);
		
		btn5 = new JButton("5");
		btn5.setBounds(97, 102, 77, 23);
		frmTelephone.getContentPane().add(btn5);
		
		btn6 = new JButton("6");
		btn6.setBounds(184, 102, 77, 23);
		frmTelephone.getContentPane().add(btn6);
		
		btn7 = new JButton("7");
		btn7.setBounds(10, 136, 77, 23);
		frmTelephone.getContentPane().add(btn7);
		
		btn8 = new JButton("8");
		btn8.setBounds(97, 136, 77, 23);
		frmTelephone.getContentPane().add(btn8);
		
		btn9 = new JButton("9");
		btn9.setBounds(184, 136, 77, 23);
		frmTelephone.getContentPane().add(btn9);
		
		btnHashTag = new JButton("#");
		btnHashTag.setBounds(10, 170, 77, 23);
		frmTelephone.getContentPane().add(btnHashTag);
		
		btn0 = new JButton("0");
		btn0.setBounds(97, 170, 77, 23);
		frmTelephone.getContentPane().add(btn0);
		
		btnH = new JButton("H");
		btnH.setBounds(184, 170, 77, 23);
		frmTelephone.getContentPane().add(btnH);
		
		btnQ = new JButton("Q");
		btnQ.setBounds(10, 205, 251, 23);
		frmTelephone.getContentPane().add(btnQ);
		
		textFieldSpeak = new JTextField();
		textFieldSpeak.setBounds(10, 239, 251, 23);
		frmTelephone.getContentPane().add(textFieldSpeak);
		textFieldSpeak.setColumns(10);
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText(textFieldSpeak.getText().concat("1"));
			}
		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText(textFieldSpeak.getText().concat("2"));
			}
		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText(textFieldSpeak.getText().concat("3"));
			}
		});
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText(textFieldSpeak.getText().concat("4"));
			}
		});
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText(textFieldSpeak.getText().concat("5"));
			}
		});
		
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText(textFieldSpeak.getText().concat("6"));
			}
		});
		
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText(textFieldSpeak.getText().concat("7"));
			}
		});
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText(textFieldSpeak.getText().concat("8"));
			}
		});
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText(textFieldSpeak.getText().concat("9"));
			}
		});
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSpeak.setText(textFieldSpeak.getText().concat("0"));
			}
		});
		
	}
}
