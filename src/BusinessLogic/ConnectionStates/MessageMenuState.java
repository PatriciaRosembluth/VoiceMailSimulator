package BusinessLogic.ConnectionStates;
import BusinessLogic.ActualConnection;
import BusinessLogic.Message;


public class MessageMenuState implements ConnectionState{
	   public void dial(String key, ActualConnection connection)
	   {
	      if (key.equals("1"))
	      {
	         String output = "";
	         Message m = connection.currentMailbox.getCurrentMessage();
	         if (m == null) output += "No messages." + "\n";
	         else output += m.getText() + "\n";
	         output += ActualConnection.MESSAGE_MENU_TEXT;
	         connection.speakToAllUIs(output);
	      }
	      else if (key.equals("2"))
	      {
	         connection.currentMailbox.saveCurrentMessage();
	         connection.speakToAllUIs(ActualConnection.MESSAGE_MENU_TEXT);
	      }
	      else if (key.equals("3"))
	      {
	         connection.currentMailbox.removeCurrentMessage();
	         connection.speakToAllUIs(ActualConnection.MESSAGE_MENU_TEXT);
	      }
	      else if (key.equals("4"))
	      {
	         //connection.state = Connection.MAILBOX_MENU;
	    	  connection.currentState = new MailBoxMenuState();
	         connection.speakToAllUIs(ActualConnection.MAILBOX_MENU_TEXT);
	      }
	   }
	   public int getState(){
		   return 4;
	   }

}
