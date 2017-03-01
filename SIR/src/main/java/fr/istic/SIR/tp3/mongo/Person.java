package fr.istic.SIR.tp3.mongo;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Person {
	
	@Id
	ObjectId idPerson;
	String name;
	@Embedded
	Address address ;
    	
	public Person()
	{
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ObjectId getId() {
		return idPerson;
	}
	public void setId(ObjectId id) {
		this.idPerson = id;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	

}
