package source;
import java.util.ArrayList;

public class PhoneBook {
	private ArrayList<Contact> contacts;
	
	public PhoneBook(){
		contacts = new ArrayList<Contact>();
	}
	
	public Contact remove(int id){
		return contacts.remove(id);
	}
	
	public void add(Contact newContact){
		contacts.add(newContact);
	} 
	
	public Contact peek(int id){
		return contacts.get(id);
	}
	
	 public int size()
	{
	    return contacts.size();
	}
	
}
