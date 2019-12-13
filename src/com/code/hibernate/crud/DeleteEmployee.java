package com.code.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.code.hibernate.entity.Employee;

public class DeleteEmployee {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			int employeeId = 1;
			
			// Now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Retrieve student based on the id: primary key
			System.out.println("\nGetting employee with id:"+ employeeId);
			
			Employee myEmployee = session.get(Employee.class,  employeeId);
			
			// Delete record
			System.out.println("Deleting employee: "+myEmployee);
			session.delete(myEmployee);
			
			// Commit the transaction
			session.getTransaction().commit();
						
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
