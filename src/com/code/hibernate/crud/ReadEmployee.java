package com.code.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.entity.Employee;

public class ReadEmployee {

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
			Employee employee = new Employee("Abigail", "Jimenez", "Company");
			
			// Start a transaction
			session.beginTransaction();
			
			// Save 
			System.out.println("Saving employee");
			session.save(employee);
			
			// Commit transaction
			session.getTransaction().commit();
			System.out.println("Saved employee "+employee);
			
			// New session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Retrieve employee based on the id: primary key
			System.out.println("\nGetting employee with id:"+ employee.getId());
			
			Employee myEmployee = session.get(Employee.class, employee.getId());
			
			System.out.println("Data of employee"+myEmployee);
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
