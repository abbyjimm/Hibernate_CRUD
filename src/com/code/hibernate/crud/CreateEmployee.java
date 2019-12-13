package com.code.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.entity.Employee;

public class CreateEmployee {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			// Session object to save Java object
			// Create a Employee object
			System.out.println("Creating new employee");
			Employee employee = new Employee("Marylee", "Martinez", "Company");
			
			// Start a transaction
			session.beginTransaction();
			
			// Save 
			System.out.println("Saving employee");
			session.save(employee);
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
