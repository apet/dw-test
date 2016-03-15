package se.sbin.dwtest.it;

import io.dropwizard.Configuration;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.ClassRule;
import org.junit.Test;
import se.sbin.dwtest.DwTest;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

import static io.dropwizard.testing.ResourceHelpers.resourceFilePath;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DwTestIT {
    @ClassRule
    public static final DropwizardAppRule<Configuration> RULE
            = new DropwizardAppRule<Configuration>(DwTest.class, resourceFilePath("integration.yml"));

    @Test
    public void shouldGetGreeting() {
        Client client = new JerseyClientBuilder().build();

        Response response = client.target(
                String.format("http://localhost:%d/hello", RULE.getLocalPort()))
                .request()
                .get();

        assertThat(response.getStatus(), equalTo(200));
        assertThat(response.readEntity(String.class), equalTo("Hello World!"));
    }


}
