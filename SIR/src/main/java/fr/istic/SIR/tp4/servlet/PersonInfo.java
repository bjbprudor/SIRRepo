package fr.istic.SIR.tp4.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Person;

@WebServlet (name= "personinfo" ,urlPatterns={ "/PersonInfo" })
public class PersonInfo extends HttpServlet 
{

	EntityManager manager;
	
	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
		EntityManagerFactory factory =  Persistence.createEntityManagerFactory("example");
        this.manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
	}
	
	@Override
	public void destroy() 
	{
		// TODO Auto-generated method stub
		super.destroy();
		manager.close();
	}
		
	@Override
	public void doPost(HttpServletRequest request ,HttpServletResponse response ) throws ServletException, IOException 
	{		
		response .setContentType( "text/html" );
		String nom = request.getParameter("name");
		String prenom = request.getParameter("firstname");
        Person p1 = new Person();
        p1 = new Person(nom, prenom, null,null,null);        	
        manager.persist(p1);        	
        manager.getTransaction().commit();
        System.out.println(".. done");
        doGet(request,response);
	}
	
	@Override
	protected void doGet(HttpServletRequest req , HttpServletResponse resp ) throws ServletException, IOException 
	{
    	Collection<Person> list = new ArrayList<>();
    	list = manager.createQuery("Select a From Person a", Person.class).getResultList();
    	
		PrintWriter p = new PrintWriter(resp.getOutputStream());
		
		String txt = "<HTML>\n<BODY>\n" + "<H1>Recapitulatif des Personnes</H1>\n<UL>";
		for (Person person : list) 
		{
			txt += "<LI>Id : "+ person.getId() + " Prenom : " + person.getPrenom() + " Nom : " + person.getNom() + "</LI>";
		}
		txt += "</UL></BODY></HTML>";
		
		p.print(txt);
		p.flush();
        System.out.println(".. done");
	}
	
	
}
