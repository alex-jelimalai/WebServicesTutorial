package com.up_and_running.ch2.adage2;

import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.ext.xml.DomRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author Alexandr Jelimalai
 */
public class XmlOneResource extends ServerResource {

    @Get
    public Representation getByIdToXmlRepresentation(Representation data) {
        DomRepresentation dom = null;
        String msg = null;
        Object sid = getRequest().getAttributes().get("id");
        if (sid == null) {
            msg = badRequest("No ID given.\n");
            return new StringRepresentation(msg, MediaType.APPLICATION_XMI);
        }
        Integer id = null;
        try {
            id = Integer.parseInt(sid.toString().trim());
        } catch (Exception e) {
            msg = badRequest("Ill-formed ID.\n");
        }
        try {
            dom = new DomRepresentation(MediaType.TEXT_XML);
            dom.setIndenting(true);
            Document doc = dom.getDocument();
            Element root = doc.createElement("adages");
            if (msg != null) {
                createElement(doc, root, msg);
            } else {
                Adage adage = Adages.find(id);
                if (adage != null) {
                    final String domElementData = adage.toString();
                    createElement(doc, root, domElementData);
                }
            }
            doc.appendChild(root);
        } catch (Exception e) {
        }
        return dom;
    }


    private void createElement(Document doc, Element root, String domElementData) {
        Element next = doc.createElement("adage");
        next.appendChild(doc.createTextNode(domElementData));
        root.appendChild(next);
    }


    private String badRequest(String msg) {
        Status error = new Status(Status.CLIENT_ERROR_BAD_REQUEST, msg);
        return error.toString();
    }
}
