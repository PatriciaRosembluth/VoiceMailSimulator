import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;


public class GUIVoiceMail {

	private JFrame frmVoiceMail;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIVoiceMail window = new GUIVoiceMail();
					window.frmVoiceMail.setVisible(true);
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
		frmVoiceMail = new JFrame();
		frmVoiceMail.setTitle("Voice Mail");
		frmVoiceMail.setBounds(100, 100, 332, 240);
		frmVoiceMail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVoiceMail.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(21, 21, 269, 23);
		frmVoiceMail.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.setBounds(21, 55, 50, 23);
		frmVoiceMail.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("2");
		button.setBounds(81, 55, 50, 23);
		frmVoiceMail.getContentPane().add(button);
		
		JButton button_1 = new JButton("3");
		button_1.setBounds(141, 55, 50, 23);
		frmVoiceMail.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("4");
		button_2.setBounds(21, 89, 50, 23);
		frmVoiceMail.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("5");
		button_3.setBounds(81, 89, 50, 23);
		frmVoiceMail.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("6");
		button_4.setBounds(141, 89, 50, 23);
		frmVoiceMail.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("7");
		button_5.setBounds(21, 123, 50, 23);
		frmVoiceMail.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("8");
		button_6.setBounds(81, 123, 50, 23);
		frmVoiceMail.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("9");
		button_7.setBounds(141, 123, 50, 23);
		frmVoiceMail.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("0");
		button_8.setBounds(81, 157, 50, 23);
		frmVoiceMail.getContentPane().add(button_8);
		
		JButton btnNewButton_1 = new JButton("Send");
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setBounds(201, 55, 89, 57);
		frmVoiceMail.getContentPane().add(btnNewButton_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.RED);
		btnDelete.setBounds(201, 123, 89, 57);
		frmVoiceMail.getContentPane().add(btnDelete);
		
		JButton button_9 = new JButton("#");
		button_9.setBounds(21, 157, 43, 23);
		frmVoiceMail.getContentPane().add(button_9);
		
		JButton btnH = new JButton("h");
		btnH.setBounds(141, 157, 50, 23);
		frmVoiceMail.getContentPane().add(btnH);
	}
}
