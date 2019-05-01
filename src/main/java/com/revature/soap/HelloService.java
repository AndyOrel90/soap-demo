package com.revature.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class HelloService {
	public String sayHello(@WebParam(name = "name") String name) {
		return "Hello, " + name;
	}

	@WebMethod
	public Artist getEmployee(int id) {
		return new Artist(id, "Bob Ross");
	}

	@WebMethod
	public Artist addArtist(int id, String name) {
		System.out.println(id + name);
		return new Artist(id, name);
	}
}
