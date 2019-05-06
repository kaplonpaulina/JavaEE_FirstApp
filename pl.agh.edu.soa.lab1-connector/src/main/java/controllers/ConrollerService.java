
package controllers;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ConrollerService", targetNamespace = "http://controllers/", wsdlLocation = "http://localhost:8080/pl.agh.edu.soa.lab1-ejb/Conroller?wsdl")
public class ConrollerService
    extends Service
{

    private final static URL CONROLLERSERVICE_WSDL_LOCATION;
    private final static WebServiceException CONROLLERSERVICE_EXCEPTION;
    private final static QName CONROLLERSERVICE_QNAME = new QName("http://controllers/", "ConrollerService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/pl.agh.edu.soa.lab1-ejb/Conroller?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CONROLLERSERVICE_WSDL_LOCATION = url;
        CONROLLERSERVICE_EXCEPTION = e;
    }

    public ConrollerService() {
        super(__getWsdlLocation(), CONROLLERSERVICE_QNAME);
    }

    public ConrollerService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CONROLLERSERVICE_QNAME, features);
    }

    public ConrollerService(URL wsdlLocation) {
        super(wsdlLocation, CONROLLERSERVICE_QNAME);
    }

    public ConrollerService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CONROLLERSERVICE_QNAME, features);
    }

    public ConrollerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ConrollerService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Conroller
     */
    @WebEndpoint(name = "ConrollerPort")
    public Conroller getConrollerPort() {
        return super.getPort(new QName("http://controllers/", "ConrollerPort"), Conroller.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Conroller
     */
    @WebEndpoint(name = "ConrollerPort")
    public Conroller getConrollerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://controllers/", "ConrollerPort"), Conroller.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CONROLLERSERVICE_EXCEPTION!= null) {
            throw CONROLLERSERVICE_EXCEPTION;
        }
        return CONROLLERSERVICE_WSDL_LOCATION;
    }

}