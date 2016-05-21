public class RecordingState implements ConnectionState {
	   public void dial(String key, Connection connection)
	   {
	      if (key.equals("#"))
	      {
	         if (connection.currentMailbox.checkPasscode(connection.accumulatedKeys))
	         {
	            //connection.state = Connection.MAILBOX_MENU;
	            connection.currentState=new MailBoxMenuState();
	        	connection.speakToAllUIs(Connection.MAILBOX_MENU_TEXT);
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
