package com.jwt.ejb.business.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jwt.ejb.entity.Employee;

/**
 * Session Bean implementation class ManageEmployeeBean
 */
@Stateless
public class ManageEmployeeBean implements EmployeeRemote {

	@PersistenceContext(unitName = "EmpMgmtPU")
    private EntityManager entityManager;
 
    public ManageEmployeeBean() {
 
    }
 
    public boolean addEmployee(Employee employee) {
        entityManager.persist(employee);
        return true;
    }

}
