package com.project.mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.project.mvc.dao.PersonDAO;
import com.project.mvc.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {
	
	public static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);
	
	private SessionFactory sessionFactory;
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addPerson(Person person) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(person);
		
		logger.info("Person Saved Successfully. Person Details: " + person);
		
	}

	public void removePerson(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		
		if(p != null) {
			session.delete(p);
		}
		
		logger.info("Session deleted successfully");
		
	}

	public void updatePerson(Person person) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(person);
		
		logger.info("Person updated successfully");
	}

	@SuppressWarnings("unchecked")
	public List<Person> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Person> personList = session.createQuery("from Person").list();
		
		for (Person p: personList) {
			logger.info("Person: " + p);
		}
		return personList;
	}

	public Person getPersonById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		
		logger.info("Person Loaded Successfully. Person Details=" + p);
		return p;
	}

	

}