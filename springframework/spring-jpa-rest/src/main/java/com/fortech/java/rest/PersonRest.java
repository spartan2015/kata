package com.fortech.java.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fortech.java.entities.Person;
import com.fortech.java.services.PersonService;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Component
public class PersonRest {
	@Autowired
	private PersonService personService;

	@GET
	@Path("/{byId}")
	@Produces(value=MediaType.APPLICATION_JSON)
	public Response get(@PathParam("byId") Long byId) {
		Person person = personService.get(byId);
		if (person != null){
			return Response.ok(person).build();
		}
		else{
			return Response.noContent().build();
		}
	}

	@GET
	@Path("/list")
	@Produces(value=MediaType.APPLICATION_JSON)
	public Response list() {
		List<Person> list = personService.list();
		return Response.ok(list).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(Person person) {
		try{
			personService.save(person);
			return Response.ok(person.getId()).build();
		}catch(Exception ex){
			return Response.serverError().build();
		}		
	}

	@DELETE
	public Response delete(Person person) {
		try{
			personService.delete(person);
			return Response.ok().build();
		}catch(Exception ex){
			return Response.serverError().build();
		}	
	}
}
