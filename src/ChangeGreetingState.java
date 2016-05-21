
public class ChangeGreetingState implements ConnectionState{
	   public void dial(String key, Connection connection)
	   {
	      if (key.equals("#"))
	      {
	         connection.currentMailbox.setGreeting(connection.currentRecording);
	         connection.currentRecording = "";
	         //connection.state = Connection.MAILBOX_MENU;
	         connection.currentState =  new MailBoxMenuState();
	         connection.speakToAllUIs(Connection.MAILBOX_MENU_TEXT);
	      }
	   }
	   
	   public int getState(){
		   return 6;
	   }

}
