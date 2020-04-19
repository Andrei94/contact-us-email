package contact.us.email;

import io.micronaut.function.executor.FunctionInitializer;
import io.micronaut.function.FunctionBean;

import javax.inject.*;
import java.io.IOException;
import java.util.function.Function;

@FunctionBean("contact-us-email")
public class ContactUsEmailFunction extends FunctionInitializer implements Function<ContactUsEmail, ContactUsEmail> {
	@Override
	public ContactUsEmail apply(ContactUsEmail msg) {
		return msg;
	}

	/**
	 * This main method allows running the function as a CLI application using: echo '{}' | java -jar function.jar
	 * where the argument to echo is the JSON to be parsed.
	 */
	public static void main(String... args) throws IOException {
		ContactUsEmailFunction function = new ContactUsEmailFunction();
		function.run(args, (context) -> function.apply(context.get(ContactUsEmail.class)));
	}
}

