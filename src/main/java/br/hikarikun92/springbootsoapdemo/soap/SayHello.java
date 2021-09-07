//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.3.0 
// Consulte <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2021.09.07 às 02:44:47 PM BRT 
//


package br.hikarikun92.springbootsoapdemo.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de SayHello complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SayHello"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HelloRequest" type="{http://learnwebservices.com/services/hello}helloRequest"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SayHello", propOrder = {
    "helloRequest"
})
public class SayHello {

    @XmlElement(name = "HelloRequest", required = true)
    protected HelloRequest helloRequest;

    /**
     * Obtém o valor da propriedade helloRequest.
     * 
     * @return
     *     possible object is
     *     {@link HelloRequest }
     *     
     */
    public HelloRequest getHelloRequest() {
        return helloRequest;
    }

    /**
     * Define o valor da propriedade helloRequest.
     * 
     * @param value
     *     allowed object is
     *     {@link HelloRequest }
     *     
     */
    public void setHelloRequest(HelloRequest value) {
        this.helloRequest = value;
    }

}
