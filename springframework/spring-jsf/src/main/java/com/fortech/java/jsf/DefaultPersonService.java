package com.fortech.java.jsf;

import java.util.List;

import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

@Named("personService")
public class DefaultPersonService implements PersonService {

	private String baseUrl = "http://localhost:8080/starting-spring/rest/person";

	@Override
	public List<Person> getList() {

		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonFeature.class);

		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget webTarget = client.target(baseUrl + "/list");

		Builder request = webTarget.request(MediaType.APPLICATION_JSON);

		Response response = request.get();
		
		List<Person> persons = response
				.readEntity(new GenericType<List<Person>>() {
				});
				
		return persons;
	}

}