package States;
import source.ActualConnection;


public class ChangeGreetingState implements ConnectionState{
	   public void dial(String key, ActualConnection connection)
	   {
	      if (key.equals("#"))
	      {
	         connection.currentMailbox.setGreeting(connection.currentRecording);
	         connection.currentRecording = "";
	         //connection.state = Connection.MAILBOX_MENU;
	         connection.currentState =  new MailBoxMenuState();
	         connection.speakToAllUIs(ActualConnection.MAILBOX_MENU_TEXT);
	      }
	   }
	   
	   public int getState(){
		   return 6;
	   }

}
