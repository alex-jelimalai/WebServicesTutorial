package com.up_and_running.ch2.adage2;

import java.util.List;

import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 * @author Alexandr Jelimalai
 */
public class PlainResource extends ServerResource {

    @Get
    public Representation toPlain() {
        List<Adage> list = Adages.getList();
        return new StringRepresentation(list.toString(), MediaType.TEXT_PLAIN);
    }
}
