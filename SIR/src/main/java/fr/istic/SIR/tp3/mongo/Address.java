package fr.istic.SIR.tp3.mongo;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
@Entity
public class Address {

	@Id
	ObjectId idAddress;
	String street;
	String city;
	String postcode;
	String country;

	public Address()
	{
		
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostCode(String postcode) {
		this.postcode = postcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public ObjectId getId() {
		return idAddress;
	}
	public void setId(ObjectId id) {
		this.idAddress = id;
	}
	
	
	
	


}
