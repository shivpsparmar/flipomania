package com.flipkart.flipomania;

import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.flipkart.flipomania.core.configuration.FlipomaniaConfiguration;
import com.flipkart.flipomania.representations.ShortListed;
import com.flipkart.flipomania.resources.ShortlistResource;
import com.flipkart.flipomania.services.Selector;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.GuiceBundle;
import com.sun.org.apache.xerces.internal.xs.ShortList;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.text.SimpleDateFormat;

/**
 * Hello world!
 */
public class FlipomaniaApplication extends Application<FlipomaniaConfiguration> {
    public static void main(String[] args) throws Exception {
        new FlipomaniaApplication().run(args);
    }

    @Override
    public String getName() {
        return "Flipomania";
    }

    @Override
    public void run(FlipomaniaConfiguration flipomaniaConfiguration, Environment environment) throws Exception {
        Injector injector= Guice.createInjector(new FlipomaniaModule());
        final ShortlistResource shortlistResource= injector.getInstance(ShortlistResource.class);
        environment.jersey().register(shortlistResource);
    }

    @Override
    public void initialize(Bootstrap<FlipomaniaConfiguration> bootstrap) {
        GuiceBundle<FlipomaniaConfiguration> guiceBundle = GuiceBundle.<FlipomaniaConfiguration>newBuilder().setConfigClass(FlipomaniaConfiguration.class).addModule(new FlipomaniaModule()).build(Stage.DEVELOPMENT);
        bootstrap.addBundle(guiceBundle);
        bootstrap.getObjectMapper().registerModule(new JodaModule());
        bootstrap.getObjectMapper().setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:SS"));
    }
}
