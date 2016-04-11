import org.junit.Test;
import org.mockito.Mockito;
import org.junit.Before;
import static org.mockito.Mockito.*;

import java.util.List;

public class _ConnectionRecordingTest {

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
    public void inLogItShouldVerifiPassShowMessageAndSetStateToMailBoxMenu() {

        when(system.findMailbox("1")).thenReturn(mailbox);
        when(mailbox.checkPasscode("2")).thenReturn(true);

        conn.dial("1");
        conn.dial("#");
        conn.dial("2");
        conn.dial("#");
        verify(phone).speak(MAILBOX_MENU_TEXT);
        assert (conn.isInMailBoxMenu());
    }

    @Test
    public void inLogItShouldVerifiPassReturnFalseAndShowErrorMessage() {
        when(system.findMailbox("1")).thenReturn(mailbox);
        when(mailbox.checkPasscode("2")).thenReturn(false);

        conn.dial("1");
        conn.dial("#");
        conn.dial("2");
        conn.dial("#");
        verify(phone).speak("Incorrect passcode. Try again!");
    }
}