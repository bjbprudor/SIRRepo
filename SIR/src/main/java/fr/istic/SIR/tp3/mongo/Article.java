package fr.istic.SIR.tp3.mongo;

import java.util.Collection;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;


@Entity
public class Article {

    @Id
	ObjectId idArticle;
	String name;
	int stars;
	
	@Embedded
	Collection<Person> buyers ;

	public Article()
	{
		
	}
	
	public ObjectId getId() {
		return idArticle;
	}
	public void setId(ObjectId id) {
		this.idArticle = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	
	
	
	
	
	
}
