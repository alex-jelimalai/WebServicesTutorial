package com.up_and_running.ch2.adage2;

import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

/**
 * @author Alexandr Jelimalai
 */
public class UpdateResource extends ServerResource {

    @Put
    public Representation updateAdage(Representation representation) {
        Form form = new Form(representation);
        Status status = null;
        String msg = "";
        String sid = form.getFirstValue("id");
        if (sid == null)
            msg = badRequest("No ID given.\n");
        Integer id = null;
        try {
            id = Integer.parseInt(sid.trim());
        } catch (Exception e) {
            msg = badRequest("Ill-formed ID.\n");
        }
        final String words = form.getFirstValue("words");
        if (words == null || words.isEmpty()) {
            msg = badRequest("Unspecified words");
        }

        if (msg.isEmpty()) {
            final Adage adage = Adages.find(id);
            if (adage == null)
                msg = badRequest("No adage with ID " + id + "\n");
            else {
                adage.setWords(words);
                msg = "Adage " + id + " update.\n";
            }
        }
        return new StringRepresentation(msg, MediaType.TEXT_PLAIN);

    }


    private String badRequest(String msg) {
        Status error = new Status(Status.CLIENT_ERROR_BAD_REQUEST, msg);
        setStatus(error);
        return error.toString();
    }

}
