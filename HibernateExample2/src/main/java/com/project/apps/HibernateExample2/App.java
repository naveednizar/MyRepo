package com.project.apps.HibernateExample2;

import org.hibernate.Session;

import com.project.apps.Stock;
import com.project.persistence.HiberanteUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Maven + Hibernate + MySQL");
        Session session = HiberanteUtil.getSessionFactory().openSession();

        session.beginTransaction();
        Stock stock = new Stock();

        stock.setStockCode("4715");
        stock.setStockName("GENM");

        session.save(stock);
        session.getTransaction().commit();
    }
}
