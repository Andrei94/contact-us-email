package contact.us.email;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class ContactUsEmailFunctionTest {
	@Inject
	ContactUsEmailClient client;

	@Test
	public void testFunction() {
		ContactUsEmail body = new ContactUsEmail();
		body.setName("contact-us-email");
		assertEquals(true, client.apply(body).blockingGet());
	}
}
