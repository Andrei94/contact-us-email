package contact.us.email;

import io.micronaut.function.executor.FunctionInitializer;
import io.micronaut.function.FunctionBean;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;

import java.io.IOException;
import java.util.function.Function;

@FunctionBean("contact-us-email")
public class ContactUsEmailFunction extends FunctionInitializer implements Function<ContactUsEmail, ContactUsEmail> {
	@Override
	public ContactUsEmail apply(ContactUsEmail msg) {
		SesClient build = SesClient.builder().region(Region.EU_CENTRAL_1).build();
		build.sendEmail(SendEmailRequest.builder()
				.destination(Destination.builder().toAddresses("andreiprecup@yahoo.com").build())
				.replyToAddresses(msg.getEmail())
				.source("andreiprecup69@gmail.com")
				.message(Message.builder()
						.subject(Content.builder().data(msg.getSubject()).charset("UTF-8").build())
						.body(Body.builder().text(Content.builder().data("Name: " + msg.getName() + System.lineSeparator() + msg.getMessage()).build()).build())
						.build())
				.build()
		);
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

