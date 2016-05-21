package States;
import source.ActualConnection;

public class RecordingState implements ConnectionState {
	   public void dial(String key, ActualConnection connection)
	   {
	      if (key.equals("#"))
	      {
	         if (connection.currentMailbox.checkPasscode(connection.accumulatedKeys))
	         {
	            //connection.state = Connection.MAILBOX_MENU;
	            connection.currentState=new MailBoxMenuState();
	        	connection.speakToAllUIs(ActualConnection.MAILBOX_MENU_TEXT);
	         }
	         else
	        	 connection.speakToAllUIs("Incorrect passcode. Try again!");
	         connection.accumulatedKeys = "";
	      }
	      else
	         connection.accumulatedKeys += key;
	   }
	   public int getState(){
		   return 2;
	   }
}
