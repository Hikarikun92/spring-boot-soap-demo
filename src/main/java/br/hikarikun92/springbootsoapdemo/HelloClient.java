package br.hikarikun92.springbootsoapdemo;

import br.hikarikun92.springbootsoapdemo.soap.HelloRequest;
import br.hikarikun92.springbootsoapdemo.soap.ObjectFactory;
import br.hikarikun92.springbootsoapdemo.soap.SayHello;
import br.hikarikun92.springbootsoapdemo.soap.SayHelloResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;

public class HelloClient extends WebServiceGatewaySupport {
    private final ObjectFactory factory = new ObjectFactory();

    /**
     * Send a request to the web service host, which will receive the {@code name} parameter and return a greeting message.
     *
     * @param name The name the server will greet.
     * @return The returned message.
     */
    public String sayHello(String name) {
        //Create the request object with the desired name
        final HelloRequest request = new HelloRequest();
        request.setName(name);

        //Wrap it in this class representing the operation to be executed
        final SayHello sayHello = new SayHello();
        sayHello.setHelloRequest(request);

        //Wrap it in a JAXBElement so that the request can be marshalled to XML
        final JAXBElement<SayHello> sayHelloElement = factory.createSayHello(sayHello);

        //Send the request, receiving the response as an unmarshalled JAXBElement
        @SuppressWarnings("unchecked") final JAXBElement<SayHelloResponse> responseElement = (JAXBElement<SayHelloResponse>) getWebServiceTemplate().marshalSendAndReceive(sayHelloElement);
        //Retrieve the response object and then the response message inside it
        return responseElement.getValue().getHelloResponse().getMessage();
    }
}
