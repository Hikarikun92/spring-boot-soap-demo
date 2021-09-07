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
 * <p>Classe Java de SayHelloResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="SayHelloResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="HelloResponse" type="{http://learnwebservices.com/services/hello}helloResponse"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SayHelloResponse", propOrder = {
    "helloResponse"
})
public class SayHelloResponse {

    @XmlElement(name = "HelloResponse", required = true)
    protected HelloResponse helloResponse;

    /**
     * Obtém o valor da propriedade helloResponse.
     * 
     * @return
     *     possible object is
     *     {@link HelloResponse }
     *     
     */
    public HelloResponse getHelloResponse() {
        return helloResponse;
    }

    /**
     * Define o valor da propriedade helloResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link HelloResponse }
     *     
     */
    public void setHelloResponse(HelloResponse value) {
        this.helloResponse = value;
    }

}
