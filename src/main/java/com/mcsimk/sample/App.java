package com.mcsimk.sample;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Module;
import com.mcsimk.sample.rest.SampleController;
import com.mcsimk.sample.config.modules.BootstrapPropertiesModule;
import io.logz.guice.jersey.JerseyModule;
import io.logz.guice.jersey.JerseyServer;
import io.logz.guice.jersey.configuration.JerseyConfiguration;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        JerseyConfiguration configuration = JerseyConfiguration.builder()
                .addPackage("com.mcsimk.sample.rest")
                .addPort(8080)
                .build();

        List<Module> modules = new ArrayList<>();
        modules.add(new JerseyModule(configuration));
        modules.add(new BootstrapPropertiesModule());
        modules.add(new AbstractModule() {
            @Override
            protected void configure() {
                bind(SampleController.class);
            }
        });

        Guice.createInjector(modules)
                .getInstance(JerseyServer.class).start();
    }
}
