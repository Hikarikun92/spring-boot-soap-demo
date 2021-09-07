package br.hikarikun92.springbootsoapdemo;

import br.hikarikun92.springbootsoapdemo.soap.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.webservices.client.AutoConfigureMockWebServiceServer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.test.client.MockWebServiceServer;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

import javax.xml.bind.JAXBException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.ws.test.client.RequestMatchers.connectionTo;
import static org.springframework.ws.test.client.RequestMatchers.payload;
import static org.springframework.ws.test.client.ResponseCreators.withPayload;

/**
 * Spring Boot test class with a configured mock server to simulate web service methods.
 */
@SpringBootTest
@AutoConfigureMockWebServiceServer
class HelloClientTest {
    @Autowired
    private MockWebServiceServer server; //The server we will use to check requests and simulate responses

    @Autowired
    private HelloClient client;

    //Utility classes for converting objects to XML
    @Autowired
    private Jaxb2Marshaller marshaller;

    private final ObjectFactory factory = new ObjectFactory();

    @Test
    void testSayHello() throws JAXBException {
        final String expectedRequest = getExpectedRequest("John Doe");
        final String expectedResponse = getExpectedResponse("Hello John Doe");

        //Expect that the client calls the web service in this URI with the expected payload, and respond with a specific
        //message. The client will NOT call the real server in this test. This is useful for simulating a real SOAP call
        //while making the test not depend on any external resources.
        server.expect(connectionTo("http://www.learnwebservices.com/services/hello"))
                .andExpect(payload(new StringSource(expectedRequest)))
                .andRespond(withPayload(new StringSource(expectedResponse)));

        final String response = client.sayHello("John Doe");
        assertEquals("Hello John Doe", response);

        //After this test, the mock server will trigger a validation to see if the client has called the server as
        //expected. You can trigger this verification yourself with method "server.verify()".
    }

    //Create a XML payload corresponding to the expected request. You could write it yourself; we're using this method
    //to avoid writing XML boilerplate code.
    private String getExpectedRequest(String name) throws JAXBException {
        final HelloRequest request = new HelloRequest();
        request.setName(name);

        final SayHello sayHello = new SayHello();
        sayHello.setHelloRequest(request);

        final StringResult result = new StringResult();
        marshaller.createMarshaller().marshal(factory.createSayHello(sayHello), result);

        return result.toString();
    }

    //Create a XML payload corresponding to the expected response
    private String getExpectedResponse(String message) throws JAXBException {
        final HelloResponse response = new HelloResponse();
        response.setMessage(message);

        final SayHelloResponse sayHelloResponse = new SayHelloResponse();
        sayHelloResponse.setHelloResponse(response);

        final StringResult result = new StringResult();
        marshaller.createMarshaller().marshal(factory.createSayHelloResponse(sayHelloResponse), result);

        return result.toString();
    }
}
