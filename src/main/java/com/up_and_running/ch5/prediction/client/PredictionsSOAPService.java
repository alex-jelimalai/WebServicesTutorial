package com.up_and_running.ch5.prediction.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.4-b01 Generated source version: 2.2
 */
@WebServiceClient(name = "PredictionsSOAPService",
                  targetNamespace = "http://server.prediction.ch5.up_and_running.com/",
                  wsdlLocation = "http://localhost:8080/WebServicesTutorial/prediction-soap?wsdl")
public class PredictionsSOAPService extends Service {

    private final static URL PREDICTIONSSOAPSERVICE_WSDL_LOCATION;
    private final static WebServiceException PREDICTIONSSOAPSERVICE_EXCEPTION;
    private final static QName PREDICTIONSSOAPSERVICE_QNAME = new QName("http://server.prediction.ch5.up_and_running.com/", "PredictionsSOAPService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/WebServicesTutorial/prediction-soap?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PREDICTIONSSOAPSERVICE_WSDL_LOCATION = url;
        PREDICTIONSSOAPSERVICE_EXCEPTION = e;
    }


    public PredictionsSOAPService() {
        super(__getWsdlLocation(), PREDICTIONSSOAPSERVICE_QNAME);
    }


    public PredictionsSOAPService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PREDICTIONSSOAPSERVICE_QNAME, features);
    }


    public PredictionsSOAPService(URL wsdlLocation) {
        super(wsdlLocation, PREDICTIONSSOAPSERVICE_QNAME);
    }


    public PredictionsSOAPService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PREDICTIONSSOAPSERVICE_QNAME, features);
    }


    public PredictionsSOAPService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }


    public PredictionsSOAPService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }


    /**
     * @return returns PredictionsSOAP
     */
    @WebEndpoint(name = "PredictionsSOAPPort")
    public PredictionsSOAP getPredictionsSOAPPort() {
        return super.getPort(new QName("http://server.prediction.ch5.up_and_running.com/", "PredictionsSOAPPort"), PredictionsSOAP.class);
    }


    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy. Supported features not in the <code>features</code> parameter
     *            will have their default values.
     * @return returns PredictionsSOAP
     */
    @WebEndpoint(name = "PredictionsSOAPPort")
    public PredictionsSOAP getPredictionsSOAPPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://server.prediction.ch5.up_and_running.com/", "PredictionsSOAPPort"), PredictionsSOAP.class, features);
    }


    private static URL __getWsdlLocation() {
        if (PREDICTIONSSOAPSERVICE_EXCEPTION != null) {
            throw PREDICTIONSSOAPSERVICE_EXCEPTION;
        }
        return PREDICTIONSSOAPSERVICE_WSDL_LOCATION;
    }

}