package TestBussinesLogic;
import static org.junit.Assert.*;
import org.junit.Test;

import BusinessLogic.Message;


public class _MessageTest {

	@Test
	public void itShouldReturnTheMessage() {
		Message message = new Message("Hola mundo");
		assertEquals("Hola mundo", message.getText());
	}

}