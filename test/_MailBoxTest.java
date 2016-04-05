import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class _MailBoxTest {
	@Test
	public void VerificarCodigoDePaso() {
		Mailbox mailbox = new Mailbox("code","greeting");
		assertEquals(true,mailbox.checkPasscode("code"));	
	}
	
	@Test
	public void EditarCodigoDePaso() {
		Mailbox mailbox = new Mailbox("code","greenting");
		mailbox.setPasscode("code2");
		assertEquals(true,mailbox.checkPasscode("code2"));	
	}
	
	@Test
	public void VerificarBienvenida() {
		Mailbox mailbox = new Mailbox("code","Welcome");
		assertEquals("Welcome",mailbox.getGreeting());	
	}
	
	@Test
	public void EditarBienvenida() {
		Mailbox mailbox = new Mailbox("code","Welcome");
		mailbox.setGreeting("Welcome Home");
		assertEquals("Welcome Home",mailbox.getGreeting());	
	}
	
	@Test
	public void AgregarMensajeAlistaDeMensajesNuevos() {
		Mailbox mailbox = new Mailbox("code","Welcome");
		Message message = new Message("Hola como estas?"); 
		mailbox.addMessage(message);
		assertEquals(message,mailbox.getCurrentMessage());	
	}
	
	@Test
	public void GuardarMensajes() {
		Mailbox mailbox = new Mailbox("code","Welcome");
		Message message1 = new Message("Hola como estas?");
		mailbox.addMessage(message1);
		mailbox.saveCurrentMessage();
		assertEquals(message1,mailbox.getCurrentMessage());	
	}
	
	@Test
	public void EliminarMensaje() {
		Mailbox mailbox = new Mailbox("code","Welcome");
		Message message1 = new Message("Hola como estas?");
		mailbox.addMessage(message1);
		mailbox.removeCurrentMessage();
		assertEquals(null,mailbox.getCurrentMessage());	
	}
	
	@Test
	public void NoExistenMensajesParaElimnar() {
		Mailbox mailbox = new Mailbox("code","Welcome");
		mailbox.saveCurrentMessage();
		assertEquals(null,mailbox.getCurrentMessage());	
	}
	
	@Test
	public void eliminarMensajesGuardados() {
		Mailbox mailbox = new Mailbox("code","Welcome");
		Message message = new Message("Hola como estas?");
		mailbox.addMessage(message);
		mailbox.saveCurrentMessage();
		mailbox.saveCurrentMessage();
		assertEquals(message,mailbox.getCurrentMessage());	
	}
	
	
}
