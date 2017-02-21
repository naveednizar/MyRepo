package com.project.mvc.dao;

import java.util.List;

import com.project.mvc.model.Person;

public interface PersonDAO {
	
	public void addPerson(Person person);
	public void removePerson(int id);
	public void updatePerson(Person person);
	public List<Person> listPersons();
	public Person getPersonById(int id);

}
