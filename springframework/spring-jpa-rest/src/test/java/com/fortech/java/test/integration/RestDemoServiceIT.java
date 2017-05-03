package com.fortech.java.test.integration;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.Assert;
import org.junit.Test;

import com.fortech.java.entities.Person;

public class RestDemoServiceIT {

	private String baseUrl = "http://localhost:8080/starting-spring-0.0.1-SNAPSHOT/rest/person/";
	
	@Test
	public void testSave() throws JsonGenerationException,
			JsonMappingException, IOException {
	
		Person person = new Person();
		person.setName("John");
		person.setBirthDate(new Date(1990, 02,01));
		
		
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonFeature.class);
	
		Client client = ClientBuilder.newClient(clientConfig);
	
		WebTarget webTarget = client
				.target(baseUrl);
	
		Builder request = webTarget.request(MediaType.APPLICATION_JSON);
	
		Response response = request.post(Entity.entity(person, MediaType.APPLICATION_JSON));
		Assert.assertTrue(response.getStatus() == 200);
	
		Long personId = response.readEntity(Long.class);
	
		ObjectMapper mapper = new ObjectMapper();
		System.out
				.print("saved *************************** "
						+ mapper.writerWithDefaultPrettyPrinter()
								.writeValueAsString(personId));
	
	}

	@Test
	public void testList() throws JsonGenerationException,
			JsonMappingException, IOException {

		List<Person> list = list();

		ObjectMapper mapper = new ObjectMapper();
		System.out.print(mapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(list));

		Assert.assertTrue("At least one person is present",
				list != null);
	}

	private List<Person> list() {
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonFeature.class);

		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget webTarget = client
				.target(baseUrl+ "list");

		Builder request = webTarget.request();
		request.header("Content-type", MediaType.APPLICATION_JSON);

		Response response = request.get();
		Assert.assertTrue(response.getStatus() == 200);

		List<Person> podcasts = response
				.readEntity(new GenericType<List<Person>>() {
				});
		return podcasts;
	}

	@Test
	public void testGetById() throws JsonGenerationException,
			JsonMappingException, IOException {

		List<Person> list = list();
		if (list.size() == 0){
			return;
		}
		Long personId = list.get(0).getId();
		
		
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonFeature.class);

		Client client = ClientBuilder.newClient(clientConfig);

		WebTarget webTarget = client
				.target(baseUrl + personId);

		Builder request = webTarget.request(MediaType.APPLICATION_JSON);

		Response response = request.get();
		Assert.assertTrue(response.getStatus() == 200);

		Person podcast = response.readEntity(Person.class);

		ObjectMapper mapper = new ObjectMapper();
		System.out
				.print("Received from database *************************** "
						+ mapper.writerWithDefaultPrettyPrinter()
								.writeValueAsString(podcast));

	}
	
	
	
}
