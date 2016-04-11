import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import java.util.List;

/**
 * Created by Deleguard on 4/1/16.
 */
public class _ConnectionMailboxMenuTest {


    Mailbox currentMailbox;
    MailSystem mailSystem;
 
    Connection connection;
    UserInterface phone;
   
   

    @Before
    public void setup() {
    	
    	List<UserInterface> mockList = Mockito.mock(List.class);  
        currentMailbox = mock(Mailbox.class);
        mailSystem = mock(MailSystem.class);
       
        connection = new Connection(mailSystem, mockList);
        when(mailSystem.findMailbox("1")).thenReturn(currentMailbox);
        when(currentMailbox.checkPasscode("1")).thenReturn(true);
        inMailboxLoggedIn();
    }

    @Test
    public void inMailboxMenuEnter1ForListenMessages() {
        String MESSAGE_MENU_TEXT = "Enter 1 to listen to the current message\n"
                + "Enter 2 to save the current message\n"
                + "Enter 3 to delete the current message\n"
                + "Enter 4 to return to the main menu";
        connection.dial("1");
        assert (connection.isInMessageMenu());
        verify(phone).speak(MESSAGE_MENU_TEXT);
    }

    @Test
    public void inMailboxMenuEnter2ForChangingPasscode() {

        connection.dial("2");
        assert (connection.isInChangePassword());
        verify(phone).speak("Enter new passcode followed by the # key");
    }

    @Test
    public void inMailboxMenuEnter3ForChangingGreeting() {

        connection.dial("3");
        assert (connection.isInChangeGreeting());
        verify(phone).speak("Record your greeting, then press the # key");
    }

    private void inMailboxLoggedIn() {
        connection.dial("1");
        connection.dial("#");
        connection.dial("1");
        connection.dial("#");
    }
}