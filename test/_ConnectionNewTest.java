import org.junit.Test;
import org.mockito.Mockito;
import org.junit.Before;
import static org.mockito.Mockito.*;

import java.util.List;

public class _ConnectionNewTest { 

	List<UserInterface> mockList;
	Mailbox mailbox;
    MailSystem system;
    UserInterface phone;
    UserInterface window;
    Connection conn;

    private static String MESSAGE_MENU_TEXT = "Enter 1 to listen to the current message\n"
                    + "Enter 2 to save the current message\n"
                    + "Enter 3 to delete the current message\n"
                    + "Enter 4 to return to the main menu";

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
    public void newConnectionShouldShowInitialPromotAndSetStateToConnected() {
        verify(phone,times(2)).speak("Enter mailbox number followed by #");
        assert (conn.isConnected());
    }

    @Test
    public void asConnectedDial1shouldGetMailBoxSpeakGreetingAndSetStateToRecording() {
        when(system.findMailbox("1")).thenReturn(mailbox);
        conn.dial("1");
        conn.dial("#");
        verify(phone).speak(mailbox.getGreeting());
        assert (conn.isRecording());
    }

    @Test
    public void asConnectedDial10shouldGetNullSpeakErrorMsjAndSetStateToRecording() {
        when(system.findMailbox("10")).thenReturn(null);
        conn.dial("1");
        conn.dial("#");
        verify(phone).speak("Incorrect mailbox number. Try again!");
    }

    @Test
    public void afterRecordingHangoutShouldSaveAMessageAndResetConnection(){
        String msgText = "This is a new message.";
        when(system.findMailbox("1")).thenReturn(mailbox);
        when(mailbox.checkPasscode("1")).thenReturn(true);
        when(mailbox.getCurrentMessage()).thenReturn(new Message(msgText));

        conn.dial("1");
        conn.dial("#");
        conn.dial(msgText);
        conn.hangup();
        conn.dial("1");
        conn.dial("#");
        conn.dial("1");
        conn.dial("#");
        conn.dial("1");
        conn.dial("1");
        verify(phone).speak(msgText+"\n"+MESSAGE_MENU_TEXT);
    }
}