import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

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
      List<UserInterface> uis = new ArrayList<UserInterface>();
      UserInterface consola = new Telephone(console);
      GUIVoiceMail window = new GUIVoiceMail();
      window.getJframe().setVisible(true);
      uis.add(window);
      uis.add(consola);
      Connection c = new Connection(system, uis);        
      consola.run(c);
   }
   
}
