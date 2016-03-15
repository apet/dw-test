package port.incoming;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class DwResource {

    @GET
    public String helloWorld() {
        return "Hello World!";
    }
}
