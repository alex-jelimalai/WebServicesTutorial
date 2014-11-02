package com.up_and_running.ch2.adage;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.google.common.collect.ImmutableSet;

/**
 *
 * @author Alexandr Jelimalai
 */
@ApplicationPath("/resourcesA")
public class RestfulAdage extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return ImmutableSet.<Class<?>> of(Adages.class);
    }
}
