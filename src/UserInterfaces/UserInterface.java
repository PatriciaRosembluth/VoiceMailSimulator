package UserInterfaces;

import BusinessLogic.ActualConnection;

public abstract class UserInterface {
	public abstract void speak(String output);
	public abstract void run(ActualConnection c);
}
