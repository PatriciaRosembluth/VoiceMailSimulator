import java.util.ArrayList;
import java.util.List;

public class Connection
{
	   MailSystem system;
	   Mailbox currentMailbox;
	   String currentRecording;
	   String accumulatedKeys;
	   ConnectionState currentState = null;
	   int state;
	   List<UserInterface> uis= new ArrayList<UserInterface>();
	   private static final String INITIAL_PROMPT = 
	         "Enter mailbox number followed by #";      
	   static final String MAILBOX_MENU_TEXT = 
	         "Enter 1 to listen to your messages\n"
	         + "Enter 2 to change your passcode\n"
	         + "Enter 3 to change your greeting";
	   static final String MESSAGE_MENU_TEXT = 
	         "Enter 1 to listen to the current message\n"
	         + "Enter 2 to save the current message\n"
	         + "Enter 3 to delete the current message\n"
	         + "Enter 4 to return to the main menu";
	   
   public Connection(MailSystem s)
   {
      system = s;
   }
   
   public void addUI(UserInterface ui){
	   uis.add(ui);	 
	   resetConnection();
   }

   public void dial(String key)
   {
      currentState.dial(key, this);
   }
   
   public void record(String voice)
   {
      if (currentState.getState() == 2 || currentState.getState() == 6)
         currentRecording += voice;
   }

   public void hangup()
   {
      if (currentState.getState() == 2)
         currentMailbox.addMessage(new Message(currentRecording));
      	resetConnection();
   }
   
   public boolean isConnected() {
	    return currentState.getState() == 1;
	 }

	 public boolean isRecording() {
	    return currentState.getState() == 2;
	 }

	 public boolean isInMailBoxMenu() {
	    return currentState.getState() == 3;
	 }

	 public boolean isInMessageMenu() {
	    return currentState.getState() == 4;
	 }

	 public boolean isInChangePassword() {
	    return currentState.getState() == 5;
	 }

	 public boolean isInChangeGreeting() {
	    return currentState.getState() == 6;
	 }

   private void resetConnection(){
      currentRecording = "";
      accumulatedKeys = "";
      currentState = new ConnectedState();
      speakToAllUIs(INITIAL_PROMPT);
   }
   
   void speakToAllUIs(String output) {
	   	for(UserInterface ui : uis) {
	   		ui.speak(output);
	   	}
   }
}











