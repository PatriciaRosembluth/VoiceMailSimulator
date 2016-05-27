package BusinessLogic;
import java.util.ArrayList;
import java.util.List;

import BusinessLogic.ConnectionStates.ConnectedState;
import BusinessLogic.ConnectionStates.ConnectionState;
import UserInterfaces.UserInterface;

public class ActualConnection
{
	   public MailSystem system;
	   public Mailbox currentMailbox;
	   public String currentRecording;
	   public String accumulatedKeys;
	   public PhoneBook phoneBook;
	   public String nameContact;
	   public String numberContact;
	   public ConnectionState currentState = null;
	   int state;
	   List<UserInterface> uis= new ArrayList<UserInterface>();
	   private static final String INITIAL_PROMPT = 
	         "Enter mailbox number followed by #";      
	   public static final String MAILBOX_MENU_TEXT = 
	         "Enter 1 to listen to your messages\n"
	         + "Enter 2 to change your passcode\n"
	         + "Enter 3 to change your greeting\n"
	         +"Enter 4  contacts\n";
	   public static final String MESSAGE_MENU_TEXT = 
	         "Enter 1 to listen to the current message\n"
	         + "Enter 2 to save the current message\n"
	         + "Enter 3 to delete the current message\n"
	         + "Enter 4 to return to the main menu";
	   
	   public static final String CONTACTS_MENU = 
       "Enter 1 to see contacts\n"
       + "Enter 2 to add contact\n"
       + "Enter 3 to delete contact\n"
       + "Enter 4 to return to the main menu";
	   
   public ActualConnection(MailSystem s)
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
      if (currentState.getState() == 2 || currentState.getState() == 6 || currentState.getState() == 8)
         currentRecording += voice;
   }

   public void hangup()
   {
      if (currentState.getState() == 2)
         currentMailbox.addMessage(new Message(currentRecording));
      	resetConnection();
      	//adapter.save(#mailbox,message);
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
   
   public void speakToAllUIs(String output) {
	   	for(UserInterface ui : uis) {
	   		ui.speak(output);
	   	}
   }

public void saveContact(String xContact){
	Contact newContact=new Contact(xContact);
	
	phoneBook.add(newContact);
	
}
}











