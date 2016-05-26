package BusinessLogic;
public class Contact {
	private String name;
	private int number;
	
	public Contact(String xname, int xnumber){
		this.name = xname;
		this.number = xnumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
