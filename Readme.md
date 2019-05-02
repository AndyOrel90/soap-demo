# Soap-Demo
Contract Last example generating a JAX-WS Soap service. WSDL generated and found at:
http://localhost:8080/hello?WSDL

Example message to sayHello() method:
```xml
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <sayHello xmlns="http://soap.revature.com/">
            <name xmlns="">YourNameHere</name>
        </sayHello>
    </Body>
</Envelope>
```

# Soap
  * “Expose” and “Consume” Web Services
  * Simple Object Access Protocol
  * Protocol for XML based communication across the Internet
  * Platform and language-independent
  * Similar: Corba, Dcom, Java RMI
  * SOAP is pure XML and therefore language agnostic
  * Not tied to a specific transport protocol: HTTP, SMTP, FTP, MSNQ, IBM MQSeries, etc.

### SOAP w/HTTP
  * Messages sent within Http POST Requests
  * Http must set content type to text/xml

### SOAP Message
  * Envelope – (mandatory), defines start/end of message
  * Header – (optional), optional attributes to be used when processing message
  * Body – (mandatory), XML data with message to be sent
  * Fault – (optional), describes errors that may have occurred when processing
  * Defined in default namespace
  * for SOAP – www.w3.org/2001/12/soap-envelope
  * for encoding and datatypes – www.w3.org/2001/12/soap-encoding
  * Envelope packaging contents of message
  * Only one body element allowed
  * Changing SOAP version requires change of envelope
  * SOAP Header/Body != HTTP Header/Body: entire message goes inside Http Req/Resp body
  #### Message Structure
  ```xml
    <xml version=“1.0”?>
    <soap-env:Envelope xmlns=soap-env=”www.w3.org/2001/12/soap-envelope” soap-env:encodingStyle=”www.w3.org/2001/12/soap-encoding”>
      <soap-env:Header>
      </soal-env:Header>
      <soap-env:Body>
        <soap-env:Fault>
        </soap-env:Fault>
      </soap-env:Body>
    </soap-env:Envelope>
  ```

  #### Faults
  * One fault block per message
  * Optional
  * Success: 200-299 (HttpBinding)
  * Soap Fault: 500-599
  * Elements
    * `<faultCode>`
    * `<soap-env:versionMismatch>` - invalid namespace for env
    * `<soap-env:mustUnderstand>` - immediate child of header element not understood
    * `<soap-env:client>` - message was incorrectly formed
    * `<soap-env:Server>` - error with server
    * `<faultString>`
    * `<details>`
    
### WSDL
  * Web Service Description Language
  * XML file describing everything about the service
  * “Contract” or “Endpoint”
  * Like an interface
  * Contract first vs contract last
  * Two ways of creating a soap service
  * Did you write WSDL first, or Implementation (Java code) first?
  * Important WSDL Elements (definitions):
  * name (optional)
  * targetNamespace – logical namespace for info about service
  * xmlns – default wsdl namespace, http://schema.xmlsoap.org/wsdl
  * All WSDL elements go in this namespace
  * xmlns:xsd, xmlns:soap
  * Specifies soap-specific info and datatypes
    * types port message porttype operation (definition) binding service
    * types – any complex datatype used in document (not necessary if only simple types)
    * port – specify single endpoint as address for binding
    * message – define data elements for each operation (method params, return values)
    * porttype – defines operations that can be performed and the messages involved
    * operation – abstract description of action supported by service
    * binding – specify protocol and data format for operations and messages
    * service – specify port address(es) of binding
    
### Jax-WS – Java API for XML Web Services
  * This is to set up service providers + consumers
  * Annotation-based
  * Supported by open source framework Apache CXF (also supports other protocols)
  * Jax-B – Java Architecture for XML Binding
  * Marshalling – convert Java obj to XML file
  * Unmarshalling – convert XML to Java obj
  * WSDL Soap Binding styles
  * Use to translate WSDL binding to soap message body
  * Model: Literal (DOCUMENT) vs Encoded (RPC)
  * DOCUMENT – you define XML structure of message body (“message-oriented”)
  * RPC – request body must contain operation name and method parameters
  * Literal: contents conform to user-defined xsd
  * Encoded: uses xsd datatypes but body doesn't need to conform to user-defined xsd