package contact.us.email;

import io.micronaut.function.client.FunctionClient;
import io.micronaut.http.annotation.Body;
import io.reactivex.Single;

import javax.inject.Named;

@FunctionClient
public interface ContactUsEmailClient {
	@Named("contact-us-email")
	Single<Boolean> apply(@Body ContactUsEmail body);
}
