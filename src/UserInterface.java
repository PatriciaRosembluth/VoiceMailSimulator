import javax.swing.JFrame;
public interface UserInterface {
	public void speak(String output);
	public void run(Connection c);
	public JFrame getJFrame();
}
