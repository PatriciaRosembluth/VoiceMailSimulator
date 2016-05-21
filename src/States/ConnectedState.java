package States;
import source.ActualConnection;


public class ConnectedState implements ConnectionState{
	   public void dial(String key, ActualConnection connection)
	   {
	      if (key.equals("#"))
	      {
	         connection.currentMailbox = connection.system.findMailbox(connection.accumulatedKeys);
	         if (connection.currentMailbox != null)
	         {
	            //connection.state = Connection.RECORDING;
	        	 connection.currentState = new RecordingState();
	            connection.speakToAllUIs(connection.currentMailbox.getGreeting());
	            
	         }
	         else
	        	 connection.speakToAllUIs("Incorrect mailbox number. Try again!");
	         connection.accumulatedKeys = "";
	      }
	      else
	         connection.accumulatedKeys += key;
	   }
	   
	   public int getState(){
		   return 1;
	   }

}
