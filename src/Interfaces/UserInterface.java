package Interfaces;



import javax.swing.JFrame;

import source.ActualConnection;
public interface UserInterface {
	public void speak(String output);
	public void run(ActualConnection c);
	public JFrame getJFrame();
}
