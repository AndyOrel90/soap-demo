package com.revature.soap;

import javax.xml.ws.Endpoint;

public class HelloPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/hello", new HelloService());
	}

}
