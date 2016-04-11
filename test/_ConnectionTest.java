import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

public class _ConnectionTest {
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
    }
    
	@Test
	public void newConnectionShouldBeConnected() {
	    verify(window).speak("Enter mailbox number followed by #");
	    assertTrue(conn.isConnected());
	}
	@Test
	public void whenDialInAConnectedStateItShouldChangeToRecording() {
	    
	    when(system.findMailbox("1")).thenReturn(mailbox);
	    when(mailbox.getGreeting()).thenReturn("Hola mailbox");
	    
	    
	    conn.dial("1");
	    conn.dial("#");
	    
	    verify(phone).speak("Hola mailbox");
	    assertTrue(conn.isRecording());
	}
	
	@Test
	public void whenDialInAConnectedStateAndNoMailboxFoundItShouldShowAnErrorMessage() {
		
	    when(system.findMailbox("10")).thenReturn(null);
	   
	    conn.dial("10");
	    conn.dial("#");
	    
	    verify(phone).speak("Incorrect mailbox number. Try again!");
	}
	
	@Test
	public void enterMailBoxMenu() {
		
	    String mailboxText = "Enter 1 to listen to your messages\n"
	            + "Enter 2 to change your passcode\n"
	            + "Enter 3 to change your greeting";
	    
	    when(system.findMailbox("1")).thenReturn(mailbox);
	    when(mailbox.checkPasscode("1")).thenReturn(true);
	    
	    conn.dial("1");
	    conn.dial("#");
	    conn.dial("1");
	    conn.dial("#");
	    
	    assertTrue(conn.isInMailBoxMenu());
	    verify(phone).speak(mailboxText);
	
	}
	
	@Test
	public void incorrectPassCode() {
	    
	    when(system.findMailbox("1")).thenReturn(mailbox);
	    when(mailbox.checkPasscode("2")).thenReturn(false);
	    
	    conn.dial("1");
	    conn.dial("#");
	    conn.dial("2");
	    conn.dial("#");
	    
	    assertFalse(conn.isInMailBoxMenu());
	    verify(phone).speak("Incorrect passcode. Try again!");
	
	}
	
	@Test
	public void getIntoChangePasscodeOption(){
	    
	    when(system.findMailbox("1")).thenReturn(mailbox);
	    when(mailbox.checkPasscode("1")).thenReturn(true);
	  
	    conn.dial("1");
	    conn.dial("#");
	    conn.dial("1");
	    conn.dial("#");
	    conn.dial("2");
	    verify(phone).speak("Enter new passcode followed by the # key");
	}
	
}