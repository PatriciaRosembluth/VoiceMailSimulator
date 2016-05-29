package BusinessLogic.ConnectionStates;
import BusinessLogic.ActualConnection;


public class MailBoxMenuState implements ConnectionState{

	   public void dial(String key, ActualConnection connection)
	   {
	      if (key.equals("1"))
	      {
	         //connection.state = Connection.MESSAGE_MENU;
	    	  connection.currentState = new MessageMenuState();
	         connection.speakToAllUIs(ActualConnection.MESSAGE_MENU_TEXT);
	      }
	      else if (key.equals("2"))
	      {
	         //connection.state = Connection.CHANGE_PASSCODE;
	    	  connection.currentState = new ChangePassCodeState();
	         connection.speakToAllUIs("Enter new passcode followed by the # key");
	      }
	      else if (key.equals("3"))
	      {
	         //connection.state = Connection.CHANGE_GREETING;
	    	  connection.currentState = new ChangeGreetingState();
	         connection.speakToAllUIs("Record your greeting, then press the # key");
	      }
	      else if (key.equals("4"))
	      {
	         //connection.state = Connection.CHANGE_GREETING;
	    	  connection.currentState = new ContactsState();
	         connection.speakToAllUIs(ActualConnection.CONTACTS_MENU);
	      }
	   }
	   
	   public int getState(){
		   return 3;
	   }
}
