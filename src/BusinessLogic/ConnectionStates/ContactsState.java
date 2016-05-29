package BusinessLogic.ConnectionStates;

import BusinessLogic.ActualConnection;
import BusinessLogic.PhoneBook;
import BusinessLogic.Contact;

public class ContactsState implements ConnectionState {
	PhoneBook contacts;
	String inputContact;
	
	
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
			connection.speakToAllUIs("Enter new contact 'name-number'");
			connection.saveContact(connection.currentRecording);
			connection.currentRecording="";
			connection.currentState =  new MailBoxMenuState();
	        connection.speakToAllUIs(ActualConnection.MAILBOX_MENU_TEXT);
			
			
		
		}
		
		 


	}

}
