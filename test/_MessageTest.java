import static org.junit.Assert.*;
import org.junit.Test;

import source.Message;

public class _MessageTest {

	@Test
	public void itShouldReturnTheMessage() {
		Message message = new Message("Hola mundo");
		assertEquals("Hola mundo", message.getText());
	}

}
