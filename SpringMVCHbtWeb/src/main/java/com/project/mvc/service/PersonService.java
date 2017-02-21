package com.project.mvc.service;

import java.util.List;

import com.project.mvc.model.Person;

public interface PersonService {
	
	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPerson();
	public void deletePerson(int id);
	public Person getPersonById(int id);

}
