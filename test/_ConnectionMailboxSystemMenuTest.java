import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class _ConnectionMailboxSystemMenuTest {

	List<UserInterface> mockList;
	Mailbox mailbox;
    MailSystem system;
    UserInterface phone;
    UserInterface window;
    Connection conn;

    private static String MAILBOX_MENU_TEXT = "Enter 1 to listen to your messages\n"
                    + "Enter 2 to change your passcode\n"
                    + "Enter 3 to change your greeting"; 
   
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
    }

	
	@Test
    public void inMailSystemMenuItShouldChangePasscode() {
        when(system.findMailbox("1")).thenReturn(mailbox);
        when(mailbox.checkPasscode("1")).thenReturn(true);

        conn.dial("1");
        conn.dial("#");
        conn.dial("1");
        conn.dial("#");
        conn.dial("2");
        conn.dial("9");
        conn.dial("#");
        verify(mailbox).setPasscode("9");
        assert (conn.isInMailBoxMenu());
        verify(phone,times(2)).speak(MAILBOX_MENU_TEXT);
    }

    @Test
    public void inMailSystemMenuShouldChangeGreeting(){
        when(system.findMailbox("1")).thenReturn(mailbox);
        when(mailbox.checkPasscode("1")).thenReturn(true);

        conn.dial("1");
        conn.dial("#");
        conn.dial("1");
        conn.dial("#");
        conn.dial("3");
        conn.record("Greeting");
        conn.dial("#");
        verify(mailbox).setGreeting("Greeting");
        assert(conn.isInMailBoxMenu());
        verify(phone,times(2)).speak(MAILBOX_MENU_TEXT);
    }

}