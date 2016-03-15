package se.sbin.dwtest;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import port.incoming.DwResource;

public class DwTest extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        new DwTest().run(args);
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        environment.jersey().register(new DwResource());
    }
}