import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;
import org.junit.Before;

import static org.mockito.Mockito.*;

import java.util.List;


public class _ConnectionMessageMenuTest {
	List<UserInterface> mockList;
	Mailbox mailbox;
    MailSystem system;
    UserInterface phone;
    UserInterface window;
    Connection conn;

    private static String MAILBOX_MENU_TEXT = "Enter 1 to listen to your messages\n"
            + "Enter 2 to change your passcode\n"
            + "Enter 3 to change your greeting";
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

        when(system.findMailbox("1")).thenReturn(mailbox);
        when(mailbox.checkPasscode("1")).thenReturn(true);
        dialToMailboxMenu();

    }

    @Test
    public void inMessageMenuListenMessageNoMessagesItShouldShowError(){
        when(mailbox.getCurrentMessage()).thenReturn(null);
        conn.dial("1");
        verify(phone).speak("No messages.\n"+MESSAGE_MENU_TEXT);
    }


    @Test
    public void inMessageMenuListenCurrentMessageShouldShowIT(){
        Message message = new Message("This is a message.");
        when(mailbox.getCurrentMessage()).thenReturn(message);
        conn.dial("1");
        assertEquals("This is a message.",message.getText());
        verify(phone).speak("This is a message.\n"+MESSAGE_MENU_TEXT);
    }

    @Test
    public void inMessageMenuSaveCurrentMessage(){
        conn.dial("2");
        verify(mailbox).saveCurrentMessage();
        verify(phone,times(2)).speak(MESSAGE_MENU_TEXT);
    }

    @Test
    public void inMessageMenuRemoveCurrentMessage() {
        conn.dial("3");
        verify(mailbox).removeCurrentMessage();
        verify(phone,times(2)).speak(MESSAGE_MENU_TEXT);
    }

    @Test
    public void inMessageMenuReturnToMailboxMenu(){
        conn.dial("4");
        assert (conn.isInMailBoxMenu());
        verify(phone,times(2)).speak(MAILBOX_MENU_TEXT);
    }

    private void dialToMailboxMenu() {
        conn.dial("1");
        conn.dial("#");
        conn.dial("1");
        conn.dial("#");
        conn.dial("1");
    }

}