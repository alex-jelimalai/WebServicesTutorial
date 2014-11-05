package com.up_and_running.ch2.adage2;

import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Alexandr Jelimalai
 */
public class JsonAllResource extends ServerResource {

    @Get
    public Representation toJson() {
        JsonRepresentation jsonRepresentation = null;
        try {
            final String jsonString = new ObjectMapper().writeValueAsString(Adages.getList());
            jsonRepresentation = new JsonRepresentation(jsonString);
            jsonRepresentation.setIndenting(true);
        } catch (Exception e) {
        }
        return jsonRepresentation;

    }

}
