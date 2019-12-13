package com.code.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.entity.Employee;

public class UpdateEmployee {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			int employeeId = 2;
			
			// Now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Retrieve employee based on the id: primary key
			System.out.println("\nGetting employee with id:"+ employeeId);
			
			Employee myEmployee = session.get(Employee.class,  employeeId);
			
			System.out.println("Updating employee");
			myEmployee.setFirstName("Danna");
			
			// Commit the transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
