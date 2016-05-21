import java.util.Scanner;
/**
   This program tests the mail system. A single phone
   communicates with the program through System.in/System.out.
*/
public class MailSystemTester
{
   private static final int MAILBOX_COUNT = 20;
   
   public static void main(String[] args)
   {
      MailSystem system = new MailSystem(MAILBOX_COUNT);
      Scanner console = new Scanner(System.in);
      UserInterface consola = new Telephone(console);
      UserInterface window = new GUIVoiceMail();
      window.getJFrame().setVisible(true);
      Connection c = new Connection(system);        
      c.addUI(window);
      c.addUI(consola);
      window.run(c);
      consola.run(c);
   }
}
