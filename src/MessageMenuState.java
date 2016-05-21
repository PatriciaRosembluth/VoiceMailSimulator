
public class MessageMenuState implements ConnectionState{
	   public void dial(String key, Connection connection)
	   {
	      if (key.equals("1"))
	      {
	         String output = "";
	         Message m = connection.currentMailbox.getCurrentMessage();
	         if (m == null) output += "No messages." + "\n";
	         else output += m.getText() + "\n";
	         output += Connection.MESSAGE_MENU_TEXT;
	         connection.speakToAllUIs(output);
	      }
	      else if (key.equals("2"))
	      {
	         connection.currentMailbox.saveCurrentMessage();
	         connection.speakToAllUIs(Connection.MESSAGE_MENU_TEXT);
	      }
	      else if (key.equals("3"))
	      {
	         connection.currentMailbox.removeCurrentMessage();
	         connection.speakToAllUIs(Connection.MESSAGE_MENU_TEXT);
	      }
	      else if (key.equals("4"))
	      {
	         //connection.state = Connection.MAILBOX_MENU;
	    	  connection.currentState = new MailBoxMenuState();
	         connection.speakToAllUIs(Connection.MAILBOX_MENU_TEXT);
	      }
	   }
	   public int getState(){
		   return 4;
	   }

}
