package contact.us.email;

import io.micronaut.core.annotation.*;

@Introspected
public class ContactUsEmail {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

