package States;

import source.ActualConnection;
import source.PhoneBook;

public class ContactsState implements ConnectionState {
	PhoneBook contacts;
	String input;
	@Override
	public void dial(String key, ActualConnection connection) {
		if(key.equals("1"))
		{
			contacts.show();
		
		}
		else if(key.equals("2"))
		{
			
			if(key.equals("#"))
			{
				contacts.add();
			}
			
		
		}
		
		// TODO Auto-generated method stub

	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 8;
	}

}
