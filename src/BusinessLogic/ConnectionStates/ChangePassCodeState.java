package BusinessLogic.ConnectionStates;
import BusinessLogic.ActualConnection;

public class ChangePassCodeState implements ConnectionState {
	  public void dial(String key, ActualConnection connection)
	   {
	      if (key.equals("#"))
	      {
	         connection.currentMailbox.setPasscode(connection.accumulatedKeys);
	         //connection.state = Connection.MAILBOX_MENU;
	         connection.currentState =  new MailBoxMenuState();
	         connection.speakToAllUIs(ActualConnection.MAILBOX_MENU_TEXT);
	         connection.accumulatedKeys = "";
	      }
	      else
	         connection.accumulatedKeys += key;
	   }
	  public int getState(){
		   return 5;
	   }

}
