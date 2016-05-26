package BusinessLogic.ConnectionStates;

import BusinessLogic.ActualConnection;

public interface ConnectionState {
	public void dial(String key, ActualConnection connection);
	public int getState(); 
}
