package br.hikarikun92.springbootsoapdemo;

import org.springframework.boot.webservices.client.WebServiceTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {
    /**
     * Creates a JAXB 2 marshaller/unmarshaller for the web services, using the classes in package {@code br.hikarikun92.springbootsoapdemo.soap}.
     *
     * @return The JAXB 2 marshaller/unmarshaller.
     */
    @Bean
    public Jaxb2Marshaller marshaller() {
        final Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("br.hikarikun92.springbootsoapdemo.soap");
        return marshaller;
    }

    /**
     * Creates a web services client using the auto-configured {@link WebServiceTemplateBuilder} and setting the default
     * URI to our example server.
     *
     * @param builder The builder (along with its customizers) to create a {@link org.springframework.ws.client.core.WebServiceTemplate}.
     * @return The web services client, as a Spring bean.
     */
    @Bean
    public HelloClient helloClient(WebServiceTemplateBuilder builder, Jaxb2Marshaller marshaller) {
        final HelloClient client = new HelloClient();

        //Setting the template must be the first step; further customizations will act upon the built WebServiceTemplate
        client.setWebServiceTemplate(builder.build());

        //Set the default URI to our host server
        client.setDefaultUri("http://www.learnwebservices.com/services/hello");

        //Set the marshaller and unmarshaller to the one configured
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        return client;
    }
}
