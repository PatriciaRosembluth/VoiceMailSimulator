package BusinessLogic.ConnectionStates;

import BusinessLogic.ActualConnection;
import BusinessLogic.PhoneBook;

public class ContactsState implements ConnectionState {
	PhoneBook contacts;
	String input;
	
	public int getState() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public void dial(String key, ActualConnection connection) {
		// TODO Auto-generated method stub
		
		if(key.equals("1"))
		{
			contacts.show();
		
		}
		else if(key.equals("2"))
		{
			
			if(key.equals("#"))
			{
				//contacts.add();
			}
			
		
		}
		
		// TODO Auto-generated method stub


	}

}
