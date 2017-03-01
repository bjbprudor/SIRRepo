package fr.istic.SIR.tp4.servlet;

import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import domain.Chauffage;
import domain.Person;
import domain.Residence;

@Path ("/hello")
public class SampleWebService 
{
	@GET
	@Produces (MediaType.TEXT_PLAIN)
	public String sayHello() 
	{
		return "Hello, how are you?";
	}

	@GET
	@Path ("/home")
	@Produces (MediaType.APPLICATION_JSON)
	public Residence getHome() 
	{
		Residence r = new Residence();
		Collection<Chauffage> chauff = new ArrayList<Chauffage>();
		chauff.add(new Chauffage("ref123","samsung",null));
		Person p = new Person("bjb","prudor",null,null,null);
		r.setPerson(p);
		r.setNbpiece(12);
		r.setTaille(13.44f);
		return r;
	}
	
}