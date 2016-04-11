import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import java.util.List;

/**
 * Created by Deleguard on 4/1/16.
 */
public class _ConnectionMailboxMenuTest {
	
	List<UserInterface> mockList;
	Mailbox mailbox;
    MailSystem system;
    UserInterface phone;
    UserInterface window;
    Connection conn;
   
    @Before
    public void setup() {
    	
    	mockList = mock(List.class);
    	system = mock(MailSystem.class);
    	phone = mock(Telephone.class);
    	window= mock(GUIVoiceMail.class);
	    conn = new Connection(system);
	    conn.addUI(phone);
	    conn.addUI(window);
	    mailbox = mock(Mailbox.class);
        when(system.findMailbox("1")).thenReturn(mailbox);
        when(mailbox.checkPasscode("1")).thenReturn(true);
        inMailboxLoggedIn();
    }

    @Test
    public void inMailboxMenuEnter1ForListenMessages() {
        String MESSAGE_MENU_TEXT = "Enter 1 to listen to the current message\n"
                + "Enter 2 to save the current message\n"
                + "Enter 3 to delete the current message\n"
                + "Enter 4 to return to the main menu";
        conn.dial("1");
        assert (conn.isInMessageMenu());
        verify(phone).speak(MESSAGE_MENU_TEXT);
    }

    @Test
    public void inMailboxMenuEnter2ForChangingPasscode() {

        conn.dial("2");
        assert (conn.isInChangePassword());
        verify(phone).speak("Enter new passcode followed by the # key");
    }

    @Test
    public void inMailboxMenuEnter3ForChangingGreeting() {

        conn.dial("3");
        assert (conn.isInChangeGreeting());
        verify(phone).speak("Record your greeting, then press the # key");
    }

    private void inMailboxLoggedIn() {
        conn.dial("1");
        conn.dial("#");
        conn.dial("1");
        conn.dial("#");
    }
}